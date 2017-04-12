package zz.guojin.hongmi.fragment;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.RequestQueue;
import com.yolanda.nohttp.rest.Response;


import butterknife.Bind;
import butterknife.ButterKnife;
import zz.guojin.hongmi.adapter.MyOutAdapter;
import zz.guojin.hongmi.adapter.ViewHodler;
import zz.guojin.hongmi.bean.GiveOrderPdBean;
import zz.guojin.hongmi.bean.MarryBean;
import zz.guojin.hongmi.bean.GiveOrderPdBean.PdData;
import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.utils.ToastUtils;
import zz.guojin.hongmi.view.XListView;
import zz.guojin.hongmi.view.XListView.IXListViewListener;
import zz.guojin.hongmi.R;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

//舍记录 排单信息     和得记录javabean参数一样，在此就公用一个javaBean 对象
public class GetPaidanFrafment extends BaseListFragment {

	private ArrayList<PdData> pdDataList = new ArrayList<GiveOrderPdBean.PdData>();
	private Request<String> request;
	private MyOutAdapter adapter;


	@Override
	public void initData() {
		// TODO Auto-generated method stub
		if (ISFIRST) {
			currIndex = 0;
		}

		ToRequestUrl(request, TAG, MUrlUtil.BASE_URL + MUrlUtil.GET_PD, null,
				number, currIndex, 360);

	}

	

	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
	}

	@Override
	public void initAdapter(XListView xListView) {
		// TODO Auto-generated method stub
		adapter = new MyOutAdapter(getActivity(),R.layout.give_order_single_list_item, pdDataList) {

			@Override
			public void covert(int position, ViewHodler hodler) {
				hodler.setText(R.id.tv_give_id, pdDataList.get(position).getId());
				hodler.setText(R.id.tv_give_actor, pdDataList.get(position).getUser());
				hodler.setText(R.id.tv_give_accout, pdDataList.get(position).getJb());
				hodler.setText(R.id.tv_give_date, pdDataList.get(position).getDate());
				hodler.setText(R.id.tv_give2_state, pdDataList.get(position).getZt());

			}
		};
		xListView.setAdapter(adapter);
		
	}

	@Override
	public void doWhatForRequest(int what, String info) {
		// TODO Auto-generated method stub
		if (what == 360) {
			try {
				JSONObject jsonObject = new JSONObject(info);
				if(jsonObject.getJSONArray("data").length()<=0){
					ToastUtils.showTextToast(getActivity(), "没有更多数据");
					return;
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
			Logger.e(TAG+e.getMessage());
			}
			Logger.i(TAG + "response.get()=" + info);

			Gson gson = new Gson();
			GiveOrderPdBean getBean = gson.fromJson(info,GiveOrderPdBean.class);
			if (REFRESH) {
				adapter.refreshItem(getBean.getData());
				REFRESH = false;
			} else {
				adapter.addItemLast(getBean.getData());

			}
			// 如果第一次加载的条目比较，就隐藏加载更多
			if (ISFIRST) {
				if (getBean.getData().size() < number) {
					xlistview.hideFootView();
				}
			}
		}
	}
}
