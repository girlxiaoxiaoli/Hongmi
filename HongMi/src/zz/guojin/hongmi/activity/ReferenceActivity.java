package zz.guojin.hongmi.activity;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.rest.Request;

import zz.guojin.hongmi.adapter.MyOutAdapter;
import zz.guojin.hongmi.adapter.ViewHodler;
import zz.guojin.hongmi.bean.RecommendBean;

import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.utils.ToastUtils;
import zz.guojin.hongmi.view.XListView;
import zz.guojin.hongmi.R;

//团队成员
public class ReferenceActivity extends BaseListActivity {
	private ArrayList<RecommendBean.RecommendData> recommendList = new ArrayList<RecommendBean.RecommendData>();
	private MyOutAdapter adapter;
	private Request<String> request;

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		if (ISFIRST) {
			currIndex = 0;
		}

		ToRequestUrl(request, TAG, MUrlUtil.BASE_URL
				+ MUrlUtil.RECOMMEND_PERSON, null, number, currIndex, 301);

	}

	@Override
	public void initTitle() {
		// TODO Auto-generated method stub
	setTitle("团队成员");
		
	}

	@Override
	public void initAdapter(XListView xListView) {
		// TODO Auto-generated method stub
		adapter = new MyOutAdapter(ReferenceActivity.this, R.layout.recommend_list_item,
				recommendList) {

			@Override
			public void covert(int position, ViewHodler hodler) {

				hodler.setText(R.id.tv_user_id, recommendList.get(position)
						.getUe_id());
				hodler.setText(R.id.tv_nickname, recommendList.get(position)
						.getUe_theme());
				hodler.setText(R.id.tv_phone, recommendList.get(position)
						.getUe_account());

				hodler.setText(R.id.tv_username, recommendList.get(position)
						.getUe_account());
				hodler.setText(R.id.tv_recommend, recommendList.get(position)
						.getUe_accname());
				hodler.setText(R.id.tv_register_person,
						recommendList.get(position).getZcr());
				hodler.setText(R.id.tv_join_time, recommendList.get(position)
						.getUe_regtime());

			}
		};
		xListView.setAdapter(adapter);

	}

	@Override
	public void doWhatForRequest(int what, String info) {
		// TODO Auto-generated method stub
		if (what == 301) {
			try {
				JSONObject jsonObject = new JSONObject(info);
				if(jsonObject.getJSONArray("data").length()<=0){
					ToastUtils.showTextToast(ReferenceActivity.this, "没有更多数据");
					return;
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
			Logger.e(TAG+e.getMessage());
			}
			Logger.i(TAG + "response.get()=" + info);
			Gson gson = new Gson();
			RecommendBean recommendBean = gson.fromJson(info,
					RecommendBean.class);
			setSecondTitle("团队人数："+recommendBean.getNum()+"人");

			List<RecommendBean.RecommendData> recommendData = recommendBean
					.getData();
			if (REFRESH) {
				adapter.refreshItem(recommendData);
				REFRESH = false;
			} else {
				adapter.addItemLast(recommendData);

			}
			// 如果第一次加载的条目比较，就隐藏加载更多
			if (ISFIRST) {
				if (recommendData.size() < number) {
					xListView.hideFootView();
				}
			}
		}
	}


}
