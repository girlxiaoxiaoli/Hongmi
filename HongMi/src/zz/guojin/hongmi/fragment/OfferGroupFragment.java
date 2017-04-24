package zz.guojin.hongmi.fragment;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.rest.Request;
import zz.guojin.hongmi.adapter.MyOutAdapter;
import zz.guojin.hongmi.adapter.ViewHodler;
import zz.guojin.hongmi.bean.OfferHelpGroupBean;
import zz.guojin.hongmi.bean.OfferHelpGroupBean.DataBean;
import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.utils.ToastUtils;
import zz.guojin.hongmi.view.XListView;
import zz.guojin.hongmi.R;

public class OfferGroupFragment extends BaseListFragment {

	private ArrayList<DataBean> newsList = new ArrayList<DataBean>();
	private MyOutAdapter adapter;
	private Request<String> request;

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		if (ISFIRST) {
			currIndex = 0;
		}

		ToRequestUrl(request, TAG, MUrlUtil.BASE_URL
				+ MUrlUtil.OFFER_HELP_GROUP, null, number, currIndex, 310);

	}




	@Override
	public void initAdapter(XListView xListView) {
		// TODO Auto-generated method stub
		adapter = new MyOutAdapter(getActivity(),
				R.layout.offer_group_list_item, newsList) {

			@Override
			public void covert(int position, ViewHodler hodler) {
				hodler.setText(R.id.tv_offer_group_pid, newsList.get(position)
						.getPid());
				hodler.setText(R.id.tv_offer_group_account,
						newsList.get(position).getPjb());
				hodler.setText(R.id.tv_offer_group_date, newsList.get(position)
						.getPdate());
				hodler.setText(R.id.tv_offer_group_recommend,
						newsList.get(position).getUser_tjr());
				hodler.setText(R.id.tv_offer_group_user, newsList.get(position)
						.getPuser());
				hodler.setText(R.id.tv_offer_phone, newsList.get(position)
						.getPhone());
				hodler.setText(R.id.tv_offer_group_state, newsList
						.get(position).getZt());
				if ("0".equals(newsList.get(position).getZt())) {
					hodler.setText(R.id.tv_offer_group_state, "未匹配");

				} else if ("1".equals(newsList.get(position).getZt())) {
					hodler.setText(R.id.tv_offer_group_state, "已匹配");
				}
			}
		};
		xListView.setAdapter(adapter);

	}

	@Override
	public void doWhatForRequest(int what, String info) {
		// TODO Auto-generated method stub
		if (what == 310) {
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
			OfferHelpGroupBean fmJson = gson.fromJson(info,
					OfferHelpGroupBean.class);
			if (REFRESH) {
				adapter.refreshItem(fmJson.getData());
				REFRESH = false;
			} else {
				adapter.addItemLast(fmJson.getData());

			}
			// 如果第一次加载的条目比较，就隐藏加载更多
			if (ISFIRST) {
				if (fmJson.getData().size() < number) {
					xlistview.hideFootView();
				}
			}
		}
	}

}
