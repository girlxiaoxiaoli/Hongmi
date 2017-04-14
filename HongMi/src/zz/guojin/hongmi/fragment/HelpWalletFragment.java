package zz.guojin.hongmi.fragment;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;

import zz.guojin.hongmi.adapter.MyOutAdapter;
import zz.guojin.hongmi.adapter.ViewHodler;
import zz.guojin.hongmi.bean.HelpWalletBean;
import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.utils.ToastUtils;
import zz.guojin.hongmi.view.XListView;
import zz.guojin.hongmi.R;
/**
 * 奖金总额
 * @author Administrator
 *
 */
public class HelpWalletFragment extends BaseListFragment {

	private List<HelpWalletBean.WalletData> walletList = new ArrayList<HelpWalletBean.WalletData>();
	private MyOutAdapter adapter;
	private Request<String> request;

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		if (ISFIRST) {
			currIndex = 0;
		}

		ToRequestUrl(request, TAG, MUrlUtil.BASE_URL + MUrlUtil.HELP_WALLET,
				null, number, currIndex, 301);

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
				R.layout.help_wallet_list_item, walletList) {

			@Override
			public void covert(int position, ViewHodler hodler) {
				hodler.setText(R.id.help_wallet_id, walletList.get(position)
						.getUg_id());
				hodler.setText(R.id.help_wallet_date, walletList.get(position)
						.getUg_gettime());
				hodler.setText(R.id.help_wallet_explain, walletList
						.get(position).getUg_note()
						);

				hodler.setText(R.id.help_wallet_in_out,walletList.get(position).getUg_money());
				hodler.setText(R.id.help_wallet_old, walletList
						.get(position).getUg_allget());
				hodler.setText(R.id.help_wallet_new, walletList
						.get(position).getUg_balance());
				hodler.setText(R.id.help_wallet_acount, walletList
						.get(position).getUg_account());

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
					ToastUtils.showTextToast(getActivity(), "没有更多数据");
					return;
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
			Logger.e(TAG+e.getMessage());
			}
			Logger.i(TAG + "response.get()=" + info);
			Gson gson = new Gson();
			HelpWalletBean helpWalletBean = gson.fromJson(info,
					HelpWalletBean.class);

			if (REFRESH) {
				adapter.refreshItem(helpWalletBean.getData());
				REFRESH = false;
			} else {
				adapter.addItemLast(helpWalletBean.getData());

			}
			// 如果第一次加载的条目比较，就隐藏加载更多
			if (ISFIRST) {
				if (helpWalletBean.getData().size() < number) {
					xlistview.hideFootView();
				}
			}
		}
	}

}
