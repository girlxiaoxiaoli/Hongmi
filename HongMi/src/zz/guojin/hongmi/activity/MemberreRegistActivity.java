package zz.guojin.hongmi.activity;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.rest.Request;


import butterknife.Bind;

import butterknife.OnClick;
import zz.guojin.hongmi.bean.RuquestBean;
import zz.guojin.hongmi.bean.VipShowBean;
import zz.guojin.hongmi.utils.AppManager;
import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.utils.MyCountDownTimer;
import zz.guojin.hongmi.utils.ReLoginUtil;
import zz.guojin.hongmi.utils.ToastUtils;
import zz.guojin.hongmi.utils.UiUtils;
import zz.guojin.hongmi.R;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MemberreRegistActivity extends BaseActivity {
	@Bind(R.id.img_back)
	ImageView goback;
	@Bind(R.id.title_main)
	TextView titleTextView;
	@Bind(R.id.et_shouj)
	EditText shouj;
	@Bind(R.id.et_pswd)
	EditText pswd;
	@Bind(R.id.et_qrpswd)
	EditText qrpswd;
	@Bind(R.id.et_erpswd)
	EditText erpswd;
	@Bind(R.id.et_qrerpswd)
	EditText qrerpswd;
	@Bind(R.id.et_jies_elim)
	EditText jies_elim;
	@Bind(R.id.et_jies_sj)
	EditText jies_sj;
	@Bind(R.id.cb_toyi)
	CheckBox tyl;
	@Bind(R.id.et_name1)
	EditText name1;
	@Bind(R.id.but_zhuce)
	Button zhuce;
	@Bind(R.id.ll_regist)
	LinearLayout ll_regist;
	@Bind(R.id.et_sms_code)
	EditText et_sms_code;
	@Bind(R.id.btn_sms)
	Button btn_sms;
	// Button zhuce;
	String ty;
	private String code;
	private String pemail;
	private Context ctx;
	Request<String> request;

	
	private void SetView() {
		// TODO Auto-generated method stub
		tyl.setOnCheckedChangeListener(new CheckBox.OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				// TODO Auto-generated method stub
				if (isChecked = true) {
					ty = "ye";
				}

			}
		});
	}

	// 短信验证
	@OnClick(R.id.btn_sms)
	public void smsConfig(Button btn) {
		
		String mphone = shouj.getText().toString().trim();
		Logger.i(mphone+"----");
		Map<String,Object> params = new HashMap<String, Object>();
		params.put("user", mphone);
		ToRequestUrl(request, TAG, MUrlUtil.BASE_URL + MUrlUtil.SMS_PWD, params,-1,-1,599);
		
		
	
	}

	

	@OnClick(R.id.but_zhuce)
	public void onClick(View v) {
		
		// 真实姓名
		// String username = name.getText().toString().trim();
		String phone = shouj.getText().toString().trim();// 手机号
		// String user = uname.getText().toString().trim();
		String password = pswd.getText().toString().trim();
		String qrpassword = qrpswd.getText().toString().trim();
		String ejmm = erpswd.getText().toString().trim();
		String qrejmm = qrerpswd.getText().toString().trim();
		// String email = elim.getText().toString().trim();
		String truen = name1.getText().toString().trim();
		// 短信验证码
		String smsnum = et_sms_code.getText().toString().trim();
		if (TextUtils.isEmpty(smsnum)) {
			ToastUtils.showTextToast(ctx, "请输入验证码");
			return;
		}
		if (!password.equals(qrpassword)) {
			ToastUtils.showTextToast(ctx, "确认两次密码输入一致");
			return;
		}
		if (!ejmm.equals(qrejmm)) {
			ToastUtils.showTextToast(ctx, "确认两次密码输入一致");
			return;
		}
		if (!"ye".equals(ty)) {
			ToastUtils.showTextToast(ctx, "确认是否了解所有风险");
			return;
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("user", phone);
		// request.add("user", user);
		params.put("password", password);
		params.put("secped", ejmm);
		// request.add("email", email);
		params.put("ty", ty);
		params.put("code", code);
		params.put("truen", truen);
		params.put("pemail", pemail);
		params.put("smsnum", smsnum);
		ToRequestUrl(request, TAG, MUrlUtil.BASE_URL
				+ MUrlUtil.VIP_URL, params, -1, -1, 112);
	
		
	}

	

	// 点击左上角按钮返回上一个页面
	@OnClick(R.id.img_back)
	public void goBack() {
		finish();
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		if (ev.getAction() == MotionEvent.ACTION_DOWN) {

			// 获得当前得到焦点的View，一般情况下就是EditText（特殊情况就是轨迹求或者实体案件会移动焦点）
			View v = getCurrentFocus();

			if (UiUtils.isShouldHideInput(v, ev)) {
				InputMethodManager im = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				UiUtils.hideSoftInput(v.getWindowToken(), im);
			}
		}
		return super.dispatchTouchEvent(ev);
	}

	@Override
	public int getLayoutResId() {
		// TODO Auto-generated method stub
		return R.layout.activity_regist;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		AppManager.getInstance().addActivity(this);
		ctx = this;
	}

	@Override
	public void initView() {
		// TODO Auto-generated method stub
		titleTextView.setText("注册会员");
	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub
		SetView();
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		ToRequestUrl(request, TAG, MUrlUtil.BASE_URL + MUrlUtil.SHOW_URL, null,
				-1, -1, 113);

	}

	@Override
	public void toStartProgressDialog() {
		// TODO Auto-generated method stub
		toStartProgressDialg(true);
	}

	@Override
	public void doWhatForRequest(int what, String info) {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		if(what==599){
			RuquestBean smsBean = gson
					.fromJson(info, RuquestBean.class);
			if ("1".equals(smsBean.getError())) {
				ToastUtils.showTextToast(ctx, smsBean.getMsg());
				MyCountDownTimer mdt = new MyCountDownTimer(btn_sms,
						120000, 1000);
				mdt.start();
				return;
			} else {
				ToastUtils.showTextToast(ctx, smsBean.getMsg());
				return;
			}
		}else if(what == 112) {
			
			
			RuquestBean ru = gson.fromJson(info, RuquestBean.class);
			if ("1".equals(ru.getError())) {
				ToastUtils.showTextToast(ctx, ru.getMsg());
				return;
			} else if ("0".equals(ru.getError())) {
				ToastUtils.showTextToast(ctx, ru.getMsg());
				return;
			} else if ("3".equals(ru.getError())) {
				ToastUtils.showTextToast(ctx, ru.getMsg());
				ReLoginUtil.LoginAgain(ctx, LoginActivity.class);
				return;
			}

		}else{
			
			VipShowBean vs = gson.fromJson(info, VipShowBean.class);
			// 激活码
			code = vs.getData().getPin();
			// 获取推荐人用户
			pemail = vs.getData().getUe_account();
			jies_elim.setText(vs.getData().getUe_account());
			// 获取推荐人手机
			jies_sj.setText(vs.getData().getUe_phone());
		}
	}
}
