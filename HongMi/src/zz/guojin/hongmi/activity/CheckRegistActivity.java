package zz.guojin.hongmi.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import com.google.gson.Gson;
import com.yolanda.nohttp.rest.Request;
import zz.guojin.hongmi.adapter.MyOutAdapter;
import zz.guojin.hongmi.adapter.ViewHodler;
import zz.guojin.hongmi.bean.PassBean;
import zz.guojin.hongmi.bean.PassBean.Passed;
import zz.guojin.hongmi.utils.AppManager;
import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.utils.ToastUtils;
import zz.guojin.hongmi.view.XListView;
import zz.guojin.hongmi.R;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;

public class CheckRegistActivity extends BaseListActivity {

	ArrayList<Passed> passed = new ArrayList<Passed>();
	private MyOutAdapter adapter;
	private Request<String> request;
	private Context ctx;
	private int removePosition;

	// gridview团队管理

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		ToRequestUrl(request, TAG, MUrlUtil.BASE_URL + MUrlUtil.SHOU_PASS_URL,
				null, number, currIndex, 201);
		super.initData();
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		AppManager.getInstance().addActivity(this);
		ctx = this;
	}


	@Override
	public void initTitle() {
		// TODO Auto-generated method stub
		title.setText("团队管理");
	}

	@Override
	public void initAdapter(XListView xListView) {
		// TODO Auto-generated method stub
		adapter = new MyOutAdapter(CheckRegistActivity.this,
				R.layout.passcontent, passed) {

			@Override
			public void covert(final int position, ViewHodler hodler) {
				// TODO Auto-generated method stub

				hodler.setText(R.id.tv_bh, passed.get(position).getUe_id());
				hodler.setText(R.id.tv_yx, passed.get(position).getUe_account());
				hodler.setText(R.id.tv_zcsj, passed.get(position)
						.getUe_regtime());
				hodler.setText(R.id.tv_caoz, passed.get(position)
						.getUe_truename());
				hodler.setText(R.id.tv_status, passed.get(position)
						.getUe_status());
				if("已激活".equals(passed.get(position).getUe_status())){
					hodler.setViewVisibility(R.id.tv_shq, false);
				}else{
					hodler.setViewVisibility(R.id.tv_shq, true);

				}
				hodler.setViewOnClickListener(R.id.tv_shq,
						new OnClickListener() {

							@Override
							public void onClick(View v) {
								// TODO Auto-generated method stub
								removePosition = position;
								Map<String, Object> map = new HashMap<String, Object>();

								map.put("id", passed.get(position).getUe_id());
								ToRequestUrl(request, TAG, MUrlUtil.BASE_URL
										+ MUrlUtil.PASS_URL, map, -1, -1, 200);
							}
						});
			}
		};
		xListView.setAdapter(adapter);
	}

	@Override
	public void doWhatForRequest(int what, String info) {
		// TODO Auto-generated method stub
		try {
			JSONObject jsonObject = new JSONObject(info);
			if (what == 201) {
				if (jsonObject.getJSONArray("data").length() <= 0) {
					ToastUtils.showTextToast(ctx, "没有更多数据了");
					return;
				}
				Gson gson = new Gson();
				PassBean bean = gson.fromJson(info, PassBean.class);
				if (REFRESH) {
					adapter.refreshItem(bean.getData());
				}
				adapter.addItemLast(bean.getData());
				if (ISFIRST || bean.getData().size() < number) {
					xListView.hideFootView();
				}

			}
			if (what == 200) {
				String error = jsonObject.getString("error");
				String msg = jsonObject.getString("msg");
				ToastUtils.showTextToast(ctx, msg);
				if ("1".equals(error)) {
					adapter.removeDate(removePosition);
				}

			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
