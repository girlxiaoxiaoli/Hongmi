package zz.guojin.hongmi.fragment;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;

import zz.guojin.hongmi.activity.ConfirmGetMoneyActivity;
import zz.guojin.hongmi.activity.DeDetailsActivity;
import zz.guojin.hongmi.adapter.MyOutAdapter;
import zz.guojin.hongmi.adapter.ViewHodler;
import zz.guojin.hongmi.bean.MarryBean;
import zz.guojin.hongmi.bean.MarryBean.Marry;
import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.utils.ToastUtils;
import zz.guojin.hongmi.view.XListView;
import zz.guojin.hongmi.R;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class GetPipeiFrafment extends BaseListFragment {
	private MyOutAdapter adapter;
	private Request<String> request;
	ArrayList<Marry> msgg = new ArrayList<MarryBean.Marry>();

	

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		if (ISFIRST) {
			currIndex = 0;
		}

		ToRequestUrl(request, TAG, MUrlUtil.BASE_URL + MUrlUtil.GIVE_PP, null,
				number, currIndex, 376);

	}

  @Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
	// TODO Auto-generated method stub
	super.onActivityResult(requestCode, resultCode, data);
//	if(resultCode==2){
//		onRefresh();
//	}
}

	@Override
	public void initAdapter(XListView xListView) {
		// TODO Auto-generated method stub
		adapter = new MyOutAdapter(getActivity(),
				R.layout.get_order_match_list_item, msgg) {

			@Override
			public void covert(int position, ViewHodler hodler) {
				hodler.setText(R.id.tew_tew_id, msgg.get(position).getId());
				hodler.setText(R.id.tew_p_user, msgg.get(position).getUser());
				hodler.setText(R.id.tew_jb, msgg.get(position).getJb());
				hodler.setText(R.id.tew_date, msgg.get(position).getDate());
				hodler.setText(R.id.tew_date_hk, msgg.get(position)
						.getDate());
				hodler.setText(R.id.tew_state, msgg.get(position).getZt());
				if (msgg.get(position).getZt().equals("已打款")) {
					hodler.setViewVisibility(R.id.quren, true);
				} else {
					hodler.setViewVisibility(R.id.quren, false);
				}

				
				final String id = msgg.get(position).getId();
				hodler.setViewOnClickListener(R.id.quren,
						new OnClickListener() {

							@Override
							public void onClick(View v) {
								// TODO Auto-generated method stub
								Intent intent = new Intent(getActivity(),
										ConfirmGetMoneyActivity.class);
								intent.putExtra("did", id);
								getActivity().startActivityForResult(intent, 1);
							}
						});
				//
				hodler.setViewOnClickListener(R.id.detail,
						new OnClickListener() {

							@Override
							public void onClick(View v) {
								// TODO Auto-generated method stub
								Intent intent = new Intent(getActivity(),
										DeDetailsActivity.class);
								intent.putExtra("did", id);
								getActivity().startActivity(intent);
							}
						});
			}
		};
		xListView.setAdapter(adapter);

	}

	@Override
	public void doWhatForRequest(int what, String info) {
		// TODO Auto-generated method stub
		if (what == 376) {
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
			MarryBean marryBean = gson.fromJson(info, MarryBean.class);

			if (REFRESH) {
				adapter.refreshItem(marryBean.getData());
				REFRESH = false;
			} else {
				adapter.addItemLast(marryBean.getData());

			}
			// 如果第一次加载的条目比较，就隐藏加载更多
			if (ISFIRST) {
				if (marryBean.getData().size() < number) {
					xlistview.hideFootView();
				}
			}
		}
	}
}
