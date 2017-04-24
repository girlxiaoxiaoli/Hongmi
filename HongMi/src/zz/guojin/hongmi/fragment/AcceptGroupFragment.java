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
import zz.guojin.hongmi.bean.AcceptHelpGroupBean;
import zz.guojin.hongmi.bean.AcceptHelpGroupBean.DataBean;
import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.utils.ToastUtils;
import zz.guojin.hongmi.view.XListView;
import zz.guojin.hongmi.R;


public class AcceptGroupFragment extends BaseListFragment {

	private ArrayList<DataBean> beanList = new ArrayList<DataBean>();
	private MyOutAdapter adapter;
	private Request<String> request;

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

		ToRequestUrl(request, TAG, MUrlUtil.BASE_URL
				+ MUrlUtil.ACCEPT_HELP_GROUP, null, number, currIndex, 361);

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
				R.layout.accept_group_list_item, beanList) {

			@Override
			public void covert(int position, ViewHodler hodler) {
				// TODO Auto-generated method stub
				hodler.setText(R.id.tv_acc_group_code, beanList.get(position)
						.getJid());
				hodler.setText(R.id.tv_acc_group_account, beanList
						.get(position).getJjb());
				hodler.setText(R.id.tv_acc_group_date, beanList.get(position)
						.getJdate());
				hodler.setText(R.id.tv_acc_group_user, beanList.get(position)
						.getJuser());
				hodler.setText(R.id.tv_acc_group_phone, beanList.get(position)
						.getJhone());
				hodler.setText(R.id.tv_acc_group_tjuser, beanList.get(position)
						.getUser_tjr());
				if ("0".equals(beanList.get(position).getZt())) {
					hodler.setText(R.id.tv_acc_group_state, "未匹配");

				} else if ("1".equals(beanList.get(position).getZt())) {
					hodler.setText(R.id.tv_acc_group_state, "已匹配");
				}

			}
		};
		xListView.setAdapter(adapter);
	}

	@Override
	public void doWhatForRequest(int what, String info) {
		// TODO Auto-generated method stub
		if (what == 361) {
			
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

			Gson gson = new Gson();
			AcceptHelpGroupBean acceptBean = gson.fromJson(info,
					AcceptHelpGroupBean.class);

			if (REFRESH) {
				adapter.refreshItem(acceptBean.getData());
				REFRESH = false;
			} else {
				adapter.addItemLast(acceptBean.getData());

			}
			// 如果第一次加载的条目比较，就隐藏加载更多
			if (ISFIRST) {
				if (acceptBean.getData().size() < number) {
					xlistview.hideFootView();
				}
			}
		}
	}
}
