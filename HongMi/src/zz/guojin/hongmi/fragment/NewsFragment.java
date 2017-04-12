package zz.guojin.hongmi.fragment;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;

import android.text.Html;

import com.google.gson.Gson;
import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.rest.Request;

import zz.guojin.hongmi.R;
import zz.guojin.hongmi.activity.LoginActivity;
import zz.guojin.hongmi.adapter.MyOutAdapter;
import zz.guojin.hongmi.adapter.ViewHodler;
import zz.guojin.hongmi.bean.NewsBean;
import zz.guojin.hongmi.bean.NewsBean.NewsDataBean;
import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.utils.ReLoginUtil;
import zz.guojin.hongmi.utils.ToastUtils;
import zz.guojin.hongmi.view.XListView;

public class NewsFragment extends BaseListFragment {
	Request<String> request;
	String TAG = getClassName();
	MyOutAdapter adapter;
	private ArrayList<NewsDataBean> newsbeanList = new ArrayList<NewsDataBean>();

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		super.initData();
		ToRequestUrl(request, TAG, MUrlUtil.BASE_URL + MUrlUtil.NEWS_URL, null,
				number, currIndex, 10);

	}

	@Override
	public void initAdapter(XListView xListView) {
		// TODO Auto-generated method stub
		adapter = new MyOutAdapter(getActivity(), R.layout.news_list_item,
				newsbeanList) {

			@Override
			public void covert(int position, ViewHodler hodler) {
				// TODO Auto-generated method stub
				hodler.setText(R.id.sendtime,
						Html.fromHtml(newsbeanList.get(position).getIf_time()));
				hodler.setText(R.id.cont,
						Html.fromHtml(newsbeanList.get(position).getIf_theme()));
				hodler.setText(R.id.address, Html.fromHtml(newsbeanList.get(
						position).getIf_content()));

			}
		};
		xListView.setAdapter(adapter);

	}

	@Override
	public void doWhatForRequest(int what, String info) {
		// TODO Auto-generated method stub

		try {
			JSONObject jsonObject = new JSONObject(info);
			String error = jsonObject.getString("error");
			if ("0".equals(error)) {
				String msg = jsonObject.getString("msg");
				ToastUtils.showTextToast(getActivity(), msg);
				return;
			} else if ("1".equals(error)) {
				if (what == 10) {
					if (jsonObject.getJSONArray("data").length() <= 0) {
						ToastUtils.showTextToast(getActivity(), "没有更多数据");
						return;
					}
					Gson gson = new Gson();
					NewsBean news = gson.fromJson(info, NewsBean.class);
					if (REFRESH) {
						adapter.refreshItem(news.getData());
						REFRESH = false;
					} else {
						adapter.addItemLast(news.getData());

					}
					// 如果第一次加载的条目比较，就隐 藏加载更多
					if (ISFIRST) {
						if (news.getData().size() < number) {
							xlistview.hideFootView();
						}
					}
				}
			} else if ("3".equals(error)) {
				String msg = jsonObject.getString("msg");
				ToastUtils.showTextToast(getActivity(), msg);
				ReLoginUtil.LoginAgain(getActivity(), LoginActivity.class);
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			Logger.e(getClassName() + "网络请求" + e.getMessage());
		}

	}

}
