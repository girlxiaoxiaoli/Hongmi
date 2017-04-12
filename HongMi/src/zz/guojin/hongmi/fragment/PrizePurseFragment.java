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
import zz.guojin.hongmi.bean.BonusBean;
import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.utils.ToastUtils;
import zz.guojin.hongmi.view.XListView;
import zz.guojin.hongmi.R;

public class PrizePurseFragment extends BaseListFragment {

	private ArrayList<BonusBean.BeanData> dataList = new ArrayList<BonusBean.BeanData>();
	private Request<String> request;
	private MyOutAdapter adapter;



	@Override
	public void initData() {
		// TODO Auto-generated method stub
		if (ISFIRST) {
			currIndex = 0;
		}

		ToRequestUrl(request, TAG,
				MUrlUtil.BASE_URL + MUrlUtil.RECOMMEND_MONEY, null, number,
				currIndex, 200);

	}



	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();
	}

	@Override
	public void initAdapter(XListView xListView) {
		// TODO Auto-generated method stub
		adapter = new MyOutAdapter(getActivity(),
				R.layout.bonus_wallet_list_item, dataList) {

			@Override
			public void covert(int position, ViewHodler hodler) {

				hodler.setText(R.id.tv_bonus_id, dataList.get(position)
						.getUg_id());
				hodler.setText(R.id.tv_bonus_date, dataList.get(position)
						.getUg_gettime());
				hodler.setText(R.id.tv_bonus_explain, dataList.get(position)
						.getUg_note());
				
				hodler.setText(R.id.tv_bonus_count, dataList.get(position)
						.getUg_money());
				

			}
		};
		xListView.setAdapter(adapter);

	}

	@Override
	public void doWhatForRequest(int what, String info) {
		// TODO Auto-generated method stub
		if (what == 200) {
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
			BonusBean tuiJianBean = gson.fromJson(info, BonusBean.class);
			if (REFRESH) {
				adapter.refreshItem(tuiJianBean.getData());
				REFRESH = false;
			} else {
				adapter.addItemLast(tuiJianBean.getData());

			}
			// 如果第一次加载的条目比较，就隐藏加载更多
			if (ISFIRST) {
				if (tuiJianBean.getData().size() < number) {
					xlistview.hideFootView();
				}
			}
		}
	}

}
