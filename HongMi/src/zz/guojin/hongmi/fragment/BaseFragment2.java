package zz.guojin.hongmi.fragment;

import java.io.File;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import zz.guojin.hongmi.activity.LoginActivity;
import zz.guojin.hongmi.bean.NewsBean;
import zz.guojin.hongmi.utils.NetUtils;
import zz.guojin.hongmi.utils.ReLoginUtil;
import zz.guojin.hongmi.utils.ToastUtils;

import com.google.gson.Gson;
import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.RequestQueue;
import com.yolanda.nohttp.rest.Response;

import android.R.integer;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment2 extends Fragment {
	protected String TAG = getClassName();
	protected View rootView;
	protected RequestQueue queue;
	protected ProgressDialog pDialog = null;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		super.onCreateView(inflater, container, savedInstanceState);
		rootView = inflater.inflate(getLayoutResId(), container, false);
		queue = NoHttp.newRequestQueue();
		init();
		initView();
		initListener();
//		initData();
		return rootView;
	}
@Override
public void onActivityCreated(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onActivityCreated(savedInstanceState);
	initData();
}
  
	/**
	 * rootView布局
	 * 
	 * @return
	 */
	public abstract int getLayoutResId();

	public abstract void init();

	public abstract void initView();

	public abstract void initListener();

	public abstract void initData();

	public void ToRequestUrl(Request<String> request, String TAG, String url,
			Map<String, Object> params, int number, int currentIndex, int what) {
		if (!NetUtils.checkNet(getActivity())) {
			ToastUtils.showTextToast(getActivity(), "网络未连接");
			return;
		}
		request = NoHttp.createStringRequest(url, RequestMethod.GET);
		request.setCancelSign(TAG);
		if (number != -1 || currentIndex != -1) {
			request.add("number", number);
			request.add("start", number * currentIndex);
		}
		if (params != null) {
			Iterator<Map.Entry<String, Object>> it = params.entrySet()
					.iterator();
			while (it.hasNext()) {
				Map.Entry<String, Object> entry = it.next();
				if (entry.getValue() instanceof String) {
					request.add(entry.getKey(), (String) entry.getValue());
				} else if (entry.getValue() instanceof File) {
					request.add(entry.getKey(), (File) entry.getValue());
				} else if (entry.getValue() instanceof Boolean) {
					request.add(entry.getKey(), (Boolean) entry.getValue());

				} else if (entry.getValue() instanceof Integer) {
					request.add(entry.getKey(), (Integer) entry.getValue());
				}

			}
		}

		queue.add(what, request, new OnResponseListener<String>() {

			@Override
			public void onStart(int what) {
				// TODO Auto-generated method stub
				toStartProgressDialog();
			}

			@Override
			public void onSucceed(int what, Response<String> response) {
				// TODO Auto-generated method stub
				doWhatForRequest1(what, response);
			}

			@Override
			public void onFailed(int what, Response<String> response) {
				// TODO Auto-generated method stub

			}

			@Override
			public void onFinish(int what) {
				// TODO Auto-generated method stub
				stopProgressDialog();
			}
		});
	}

	public abstract void toStartProgressDialog();

	public void toStartProgressDialg(boolean isStart) {

		if (isStart) {
			pDialog = ProgressDialog.show(getActivity(), null, "Loading...");
		}

	}

	public void stopProgressDialog() {
		if (pDialog != null && pDialog.isShowing()) {
			pDialog.dismiss();
		}
	}

	/**
	 * 网络请求数据处理
	 * 
	 * @param what
	 * @param response
	 */
	public void doWhatForRequest1(int what, Response<String> response) {
		String jsonInfo = response.get();
		try {
			JSONObject jsonObject = new JSONObject(jsonInfo);
			String error = jsonObject.getString("error");
			if ("0".equals(error)) {
				String msg = jsonObject.getString("msg");
				ToastUtils.showTextToast(getActivity(), msg);
				return;
			} else if ("1".equals(error)) {
				doWhatForRequest(what, jsonInfo);
			
			} else if ("3".equals(error)) {
				String msg = jsonObject.getString("msg");
				ToastUtils.showTextToast(getActivity(), msg);
				ReLoginUtil.LoginAgain(getActivity(), LoginActivity.class);
			}
		}catch (Exception e) {
			// TODO: handle exception
			Logger.e(TAG+"=="+e.getMessage());
		}
		

	}

	public abstract void doWhatForRequest(int what, String info);

	// 避免重复覆盖fragment
	@Override
	public void setMenuVisibility(boolean menuVisible) {
		super.setMenuVisibility(menuVisible);
		if (this.getView() != null) {
			this.getView()
					.setVisibility(menuVisible ? View.VISIBLE : View.GONE);
		}
	}

	// 当fragment所依赖的activity消亡时，解除控件绑定
	@Override
	public void onDestroyView() {
		super.onDestroyView();
		if (queue != null) {
			queue.cancelBySign(TAG);
			queue = null;
		}
		if (pDialog != null && pDialog.isShowing()) {
			pDialog.cancel();
			pDialog = null;
		}

	}

	public String getClassName() {
		return this.getClass().getSimpleName();
	}

}
