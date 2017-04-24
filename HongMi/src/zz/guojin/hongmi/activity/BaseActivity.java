package zz.guojin.hongmi.activity;

import java.io.File;
import java.util.Iterator;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import zz.guojin.hongmi.utils.AppManager;
import zz.guojin.hongmi.utils.NetUtils;
import zz.guojin.hongmi.utils.ReLoginUtil;
import zz.guojin.hongmi.utils.ToastUtils;
import zz.guojin.hongmi.utils.UiUtils;

import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.RequestQueue;
import com.yolanda.nohttp.rest.Response;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;

public abstract class BaseActivity extends Activity {
	protected String TAG = getClassName();
	protected RequestQueue queue;
	protected ProgressDialog pDialog = null;
	protected Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);// 竖屏
		setContentView(getLayoutResId());
		AppManager.getInstance().addActivity(this);
		context = this;
		queue = NoHttp.newRequestQueue();
		init();
		initView();
		initListener();
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
		if (!NetUtils.checkNet(context)) {
			ToastUtils.showTextToast(context, "网络未连接");
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
				doWhatForRequest(what, response);
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
			pDialog = ProgressDialog.show(context, null, "Loading...");
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
	public void doWhatForRequest(int what, Response<String> response) {
		String jsonInfo = response.get();
		try {
			JSONObject jsonObject = new JSONObject(jsonInfo);
			String error = jsonObject.getString("error");
			if ("0".equals(error)) {

				String msg = jsonObject.getString("msg");
				ToastUtils.showTextToast(context, msg);
				Logger.e(getClassName() + "请求错误！！！" + msg);
				return;

			} else if ("1".equals(error)) {
				doWhatForRequest(what, jsonInfo);
			} else if ("3".equals(error)) {
				String msg = jsonObject.getString("msg");
				Logger.e(getClassName() + msg);
				ToastUtils.showTextToast(context, msg);
				ReLoginUtil.LoginAgain(context, LoginActivity.class);
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			Logger.e(getClassName() + "网络请求" + e.getMessage());
		}

	}

	public abstract void doWhatForRequest(int what, String info);

	@Override
	public void onDestroy() {
		super.onDestroy();
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

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		if (ev.getAction() == MotionEvent.ACTION_DOWN) {

			// 获得当前得到焦点的View，一般情况下就是EditText（特殊情况就是轨迹求或者实体案件会移动焦点）
			View v = getCurrentFocus();

			if (UiUtils.isShouldHideInput(v, ev)) {
				InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				UiUtils.hideSoftInput(v.getWindowToken(), im);
			}
		}
		return super.dispatchTouchEvent(ev);
	}
}
