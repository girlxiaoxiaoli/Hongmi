package zz.guojin.hongmi.activity;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.RequestQueue;
import com.yolanda.nohttp.rest.Response;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zz.guojin.hongmi.bean.SheDetailsBean;
import zz.guojin.hongmi.bean.SheDetailsBean.Data;
import zz.guojin.hongmi.utils.AppManager;
import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.utils.ToastUtils;
import zz.guojin.hongmi.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class SheDetailsActivity extends BaseActivity {
	@Bind(R.id.she_id)
	TextView sid;
	@Bind(R.id.she_jb)
	TextView sjb;
	@Bind(R.id.she_ue_truename)
	TextView sue_truename;
	@Bind(R.id.she_ue_accname)
	TextView sue_accname;
	@Bind(R.id.she_ue_account)
	TextView sue_account;
	@Bind(R.id.she_data)
	TextView sdata;
	// @Bind(R.id.she_weixin)TextView sweixin;
	@Bind(R.id.she_yhmc)
	TextView syhmc;
	@Bind(R.id.she_zfb)
	TextView szfb;
	@Bind(R.id.she_yhzh)
	TextView syhzh;
	@Bind(R.id.title_main)
	TextView title;
	@Bind(R.id.img_back)
	ImageView iv_goback;
	@Bind(R.id.dakuan_layout)
	LinearLayout dakuan_layout;
	private Request<String> request;
	private Context context;

	private String extra;

	@OnClick(R.id.img_back)
	public void goBack(ImageView iv) {
		AppManager.getInstance().killActivity(this);
	}

	@Override
	public int getLayoutResId() {
		// TODO Auto-generated method stub
		return R.layout.activity_she_details;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		AppManager.getInstance().addActivity(this);
		context = this;
		ButterKnife.bind(this);
		Intent intent = getIntent();
		extra = intent.getStringExtra("sid");
	}

	@Override
	public void initView() {
		// TODO Auto-generated method stub
		dakuan_layout.setVisibility(View.GONE);
		title.setText("收款方信息");

	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", extra);
		ToRequestUrl(request, TAG, MUrlUtil.BASE_URL + MUrlUtil.SHE_DETAILS,
				params, -1, -1, 378);

	}

	@Override
	public void toStartProgressDialog() {
		// TODO Auto-generated method stub
		toStartProgressDialg(true);

	}

	@Override
	public void doWhatForRequest(int what, String info) {
		// TODO Auto-generated method stub
		try {
			JSONObject jsonObject = new JSONObject(info);
			String error = jsonObject.getString("error");
			if ("1".equals(error)) {

				Gson gson = new Gson();
				SheDetailsBean shebean = gson.fromJson(info,
						SheDetailsBean.class);
				Data data = shebean.getData();
				sid.setText(data.getId());
				sjb.setText(data.getJb());
				sue_accname.setText(data.getUe_accname());
				sue_account.setText(data.getUe_account());
				sdata.setText(data.getDate());
				// sweixin.setText(data.getWeixin());
				syhmc.setText(data.getYhmc());
				szfb.setText(data.getZfb());
				syhzh.setText(data.getYhzh());
				sue_truename.setText(data.getUe_truename());

			} else {
				String msg = jsonObject.getString("msg");
				ToastUtils.showTextToast(context, msg);
			}
		} catch (Exception e) {
			// TODO: handle exception
			Logger.e(TAG + e.getMessage());
		}

	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		ButterKnife.unbind(this);
	}
}
