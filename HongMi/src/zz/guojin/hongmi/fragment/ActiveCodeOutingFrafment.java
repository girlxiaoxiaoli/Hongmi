package zz.guojin.hongmi.fragment;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.yolanda.nohttp.Logger;

import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;

import zz.guojin.hongmi.adapter.MyOutAdapter;
import zz.guojin.hongmi.adapter.ViewHodler;
import zz.guojin.hongmi.bean.Exchangebean;
import zz.guojin.hongmi.bean.Exchangebean.ExchangeDataBean;
import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.utils.ToastUtils;
import zz.guojin.hongmi.view.XListView;
import zz.guojin.hongmi.R;



//激活码转出
public class ActiveCodeOutingFrafment extends BaseListFragment {


	ArrayList<ExchangeDataBean> exhg = new ArrayList<ExchangeDataBean>();

	private Request<String> request;
	private MyOutAdapter adapter;
//	@Override
//	public void onResume() {
//		// TODO Auto-generated method stub
//		super.onResume();
//		onRefresh();
//	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		if (ISFIRST) {
			currIndex = 0;
		}

		ToRequestUrl(request, TAG, MUrlUtil.BASE_URL + MUrlUtil.EXCHANGE_OUTING, null,
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
		adapter = new MyOutAdapter(getActivity(),R.layout.activity_exchange, exhg) {

			@Override
			public void covert(int position, ViewHodler hodler) {
				
				hodler.setText(R.id.ug_id, exhg.get(position).getUg_account());
				hodler.setText(R.id.js_user, exhg.get(position).getUg_othraccount());
				hodler.setText(R.id.ug_gettime, exhg.get(position).getUg_money());
				hodler.setText(R.id.ug_allget, exhg.get(position).getUg_gettime());
				hodler.setText(R.id.ug_money,exhg.get(position).getUg_note());

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
			Exchangebean whg = gson.fromJson(info, Exchangebean.class);
			if (REFRESH) {
				adapter.refreshItem(whg.getData());
				REFRESH = false;
			} else {
				adapter.addItemLast(whg.getData());

			}
			// 如果第一次加载的条目比较，就隐藏加载更多
			if (ISFIRST) {
				if (whg.getData().size() < number) {
					xlistview.hideFootView();
				}
			}
		}
	}
}
