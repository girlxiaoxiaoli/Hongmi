package zz.guojin.hongmi.activity;

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
import zz.guojin.hongmi.bean.QiangdanBean;
import zz.guojin.hongmi.bean.QiangdanBean.QiangBean;
import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.utils.ToastUtils;
import zz.guojin.hongmi.view.XListView;
import zz.guojin.hongmi.R;
import android.R.integer;
import android.view.View;
import android.view.View.OnClickListener;

public class QiangActivity extends BaseListActivity {

	private ArrayList<QiangdanBean.QiangBean> beanList = new ArrayList<QiangdanBean.QiangBean>();

	private MyOutAdapter adapter;
	private Request<String> request;
	private int removePosition;
	private int id;

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		
		if (ISFIRST) {
			currIndex = 0;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		ToRequestUrl(request, TAG, MUrlUtil.BASE_URL + MUrlUtil.QIANG_URL, map,
				number, currIndex, 500);

	}


	@Override
	public void initAdapter(XListView xListView) {
		// TODO Auto-generated method stub
		adapter = new MyOutAdapter(this, R.layout.qiang_list_item,
				beanList) {

			@Override
			public void covert(final int position, ViewHodler hodler) {

				hodler.setText(R.id.qiang_id, beanList.get(position)
						.getId());

				hodler.setText(R.id.qiang_handle, beanList.get(position)
						.getUser());
				hodler.setText(R.id.qiang_count, beanList.get(position)
						.getJb());
				hodler.setText(R.id.qiang_interest, beanList.get(position)
						.getType());

				hodler.setText(R.id.qiang_day, beanList.get(position)
						.getDate());
				
				final String uid = beanList.get(position).getId();
				final String jb = beanList.get(position).getJb();
				final String user = beanList.get(position).getUser();
				removePosition = position;
				hodler.setViewOnClickListener(R.id.tv_confirm_qiang,
						new OnClickListener() {

							@Override
							public void onClick(View v) {
								// TODO Auto-generated method stub
								
                        removePosition = position;
								Map<String, Object> map = new HashMap<String, Object>();
								map.put("id", uid);
								map.put("user", user);
								map.put("jb", jb);
								ToRequestUrl(request, TAG, MUrlUtil.BASE_URL
										+ MUrlUtil.QIANG, map, -1, -1,
										555);

							}
						});

			}
		};
		xListView.setAdapter(adapter);

	}

	@Override
	public void initTitle() {
		// TODO Auto-generated method stub
		id = getIntent().getIntExtra("id", 0);
		switch (id) {
		case 1:
			setTitle("青铜区");
			break;
		case 2:
			setTitle("白银区");
			break;
		case 3:
			setTitle("黄金区");
			break;
		case 4:
			setTitle("白钻区");
			break;

		default:
			break;
		}
	}

	@Override
	public void doWhatForRequest(int what, String info) {
		// TODO Auto-generated method stub

		if (what == 500) {
			
			Logger.i(TAG + "response.get()=" + info);
			Gson gson = new Gson();
				QiangdanBean qiangdanBean =gson.fromJson(info, QiangdanBean.class);

			if (REFRESH) {
				adapter.refreshItem(qiangdanBean.getData());
				REFRESH = false;
			} else {
				adapter.addItemLast(qiangdanBean.getData());

			}
			// 如果第一次加载的条目比较，就隐藏加载更多
			if (ISFIRST) {
				if (qiangdanBean.getData().size() < number) {
					xListView.hideFootView();
				}
			}
		}
		if (what == 555) {
			
			JSONObject jsonObject;
			try {
				jsonObject = new JSONObject(info);
				String msg = jsonObject.getString("msg");
				String error = jsonObject.getString("error");
				ToastUtils.showTextToast(QiangActivity.this, msg);
				if ("1".equals(error)) {
					adapter.removeDate(removePosition);

				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				Logger.e(TAG + "提交" + e.getMessage());
			}

		}

	}

}
