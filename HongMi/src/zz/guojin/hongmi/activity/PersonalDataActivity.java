package zz.guojin.hongmi.activity;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.RequestQueue;
import com.yolanda.nohttp.rest.Response;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import zz.guojin.hongmi.bean.PersonalBean;
import zz.guojin.hongmi.bean.RuquestBean;
import zz.guojin.hongmi.utils.AppManager;
import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.utils.NetUtils;
import zz.guojin.hongmi.utils.ReLoginUtil;
import zz.guojin.hongmi.utils.ToastUtils;
import zz.guojin.hongmi.utils.UiUtils;
import zz.guojin.hongmi.R;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PersonalDataActivity extends BaseActivity {

	// @Bind(R.id.tv_theme)EditText theme;
	@Bind(R.id.img_back)
	ImageView goback;
	@Bind(R.id.title_main)
	TextView title;
	@Bind(R.id.real_name)
	TextView name;
	@Bind(R.id.tv_supper_user)
	TextView tv_supper_user;
	@Bind(R.id.tv_qq)
	TextView tv_qq;
	@Bind(R.id.tv_bank_user)
	TextView tv_bank_user;
	
	@Bind(R.id.tv_phone)
	TextView phone;
	@Bind(R.id.tv_weixin)
	TextView weixin;
	@Bind(R.id.tv_zhifu)
	TextView zhifu;
	@Bind(R.id.tv_bank)
	TextView bank;
	@Bind(R.id.tv_bank_account)
	TextView bank_account;
	@Bind(R.id.ll_my_personal_data)
	LinearLayout ll_my_personal_data;
	private Context ctx;
	Request<String> request;

	// 点击左上角按钮返回上一个页面
	@OnClick(R.id.img_back)
	public void goBack() {
		finish();
	}

	@Override
	public int getLayoutResId() {
		// TODO Auto-generated method stub
		return R.layout.activity_personal_data;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		ctx = this;
	}

	@Override
	public void initView() {
		// TODO Auto-generated method stub
		title.setText("个人资料");
	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		ToRequestUrl(request, TAG, MUrlUtil.BASE_URL + MUrlUtil.PERSONAL_DATA,
				null, -1, -1, 212);
	}

	@Override
	public void toStartProgressDialog() {
		// TODO Auto-generated method stub
		toStartProgressDialg(true);
	}

	@Override
	public void doWhatForRequest(int what, String info) {
		// TODO Auto-generated method stub
		if (what == 212) {
			Gson gson = new Gson();
			PersonalBean personalBean = gson.fromJson(info, PersonalBean.class);

			name.setText(personalBean.getData().getUe_truename());
			phone.setText(personalBean.getData().getUe_account());
			weixin.setText(personalBean.getData().getWeixin());
			zhifu.setText(personalBean.getData().getZfb());
			bank.setText(personalBean.getData().getYhmc());
			bank_account.setText(personalBean.getData().getYhzh());
			tv_supper_user.setText(personalBean.getData().getUe_accname());
			tv_qq.setText(personalBean.getData().getUe_qq());
			tv_bank_user.setText(personalBean.getData().getZhxm());
		}

	}
}
