package zz.guojin.hongmi.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;

import zz.guojin.hongmi.adapter.MyOutAdapter;
import zz.guojin.hongmi.adapter.ViewHodler;
import zz.guojin.hongmi.bean.OfferPurseBean;
import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.utils.ToastUtils;
import zz.guojin.hongmi.view.XListView;
import zz.guojin.hongmi.R;
import android.R.integer;
import android.view.View;
import android.view.View.OnClickListener;
/**
 * 实时奖金
 * @author Administrator
 *
 */
public class OfferHelpPurseFragment extends BaseListFragment {

	private ArrayList<OfferPurseBean.PurseBean> beanList = new ArrayList<OfferPurseBean.PurseBean>();
	private String uid;// 编号id
	private String withdraw;// 提现
	private MyOutAdapter adapter;
	private Request<String> request;
	private int removePosition;

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		if (ISFIRST) {
			currIndex = 0;
		}

		ToRequestUrl(request, TAG, MUrlUtil.BASE_URL + MUrlUtil.INTEREST, null,
				number, currIndex, 500);

	}



	@Override
	public void initAdapter(XListView xListView) {
		// TODO Auto-generated method stub
		adapter = new MyOutAdapter(getActivity(),
				R.layout.help_purse_list_item, beanList) {

			@Override
			public void covert(final int position, ViewHodler hodler) {

				hodler.setText(R.id.help_purse_id, beanList.get(position)
						.getId());

				hodler.setText(R.id.help_purse_count, beanList.get(position)
						.getJb());
				hodler.setText(R.id.help_purse_interest, beanList.get(position)
						.getInter());
				hodler.setText(R.id.help_purse_day, beanList.get(position)
						.getDday());
				hodler.setText(R.id.time_help_purse, beanList.get(position)
						.getDate());

				hodler.setText(R.id.help_purse_handle, beanList.get(position)
						.getPlay());
				withdraw = beanList.get(position).getPlay();
				uid = beanList.get(position).getId();
				
				hodler.setViewOnClickListener(R.id.tv_confirm,
						new OnClickListener() {

							@Override
							public void onClick(View v) {
								// TODO Auto-generated method stub
								removePosition = position;
							
								Map<String, Object> map = new HashMap<String, Object>();
								map.put("id", uid);
								ToRequestUrl(request, TAG, MUrlUtil.BASE_URL
										+ MUrlUtil.CONFIRM_MONEY, map, -1, -1,
										555);

							}
						});

			}
		};
		xListView.setAdapter(adapter);

	}

	@Override
	public void doWhatForRequest(int what, String info) {
		// TODO Auto-generated method stub
		if (what == 500) {
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
			OfferPurseBean offerPurseBean = gson.fromJson(info,
					OfferPurseBean.class);

			if (REFRESH) {
				adapter.refreshItem(offerPurseBean.getData());
				REFRESH = false;
			} else {
				adapter.addItemLast(offerPurseBean.getData());

			}
			// 如果第一次加载的条目比较，就隐藏加载更多
			if (ISFIRST) {
				if (offerPurseBean.getData().size() < number) {
					xlistview.hideFootView();
				}
			}
		}
		if (what == 555) {
			
			JSONObject jsonObject;
			try {
				jsonObject = new JSONObject(info);
				String error = jsonObject.getString("error");
				String msg = jsonObject.getString("msg");
				ToastUtils.showTextToast(getActivity(), msg);
				if("1".equals(error)){
					adapter.removeDate(removePosition);
				}
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				Logger.e(TAG + "提交" + e.getMessage());
			}

		}

	}

}
