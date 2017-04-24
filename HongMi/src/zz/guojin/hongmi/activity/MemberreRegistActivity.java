package zz.guojin.hongmi.activity;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.rest.Request;

import zz.guojin.hongmi.bean.RuquestBean;
import zz.guojin.hongmi.bean.VipShowBean;
import zz.guojin.hongmi.utils.AppManager;
import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.utils.MyCountDownTimer;
import zz.guojin.hongmi.utils.ReLoginUtil;
import zz.guojin.hongmi.utils.ToastUtils;
import zz.guojin.hongmi.utils.UiUtils;
import zz.guojin.hongmi.R;
import android.R.integer;
import android.content.Context;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MemberreRegistActivity extends BaseActivity implements
		OnClickListener {
	// (R.id.img_back)
	ImageView goback;
	// (R.id.title_main)
	TextView titleTextView;
	// (R.id.et_shouj)
	EditText shouj;
	// (R.id.et_pswd)
	EditText pswd;
	// (R.id.et_qrpswd)
	EditText qrpswd;
	// (R.id.et_erpswd)
	EditText erpswd;
	// (R.id.et_qrerpswd)
	EditText qrerpswd;
	// (R.id.et_jies_elim)
	EditText jies_elim;
	// (R.id.et_jies_sj)
	EditText jies_sj;
	// (R.id.cb_toyi)
	CheckBox tyl;
	// (R.id.et_name1)
	EditText name1;
	// (R.id.but_zhuce)
	Button zhuce;
	// (R.id.ll_regist)
	LinearLayout ll_regist;
	// (R.id.et_sms_code)
	EditText et_sms_code;
	// (R.id.btn_sms)
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

	@Override
	public void onClick(View v) {
		int id = v.getId();
		switch (id) {
		case R.id.but_zhuce:
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
			ToRequestUrl(request, TAG, MUrlUtil.BASE_URL + MUrlUtil.VIP_URL,
					params, -1, -1, 112);

			break;
		case R.id.btn_sms:

			String mphone = shouj.getText().toString().trim();
			Logger.i(mphone + "----");
			Map<String, Object> params1 = new HashMap<String, Object>();
			params1.put("user", mphone);
			ToRequestUrl(request, TAG, MUrlUtil.BASE_URL + MUrlUtil.SMS_PWD,
					params1, -1, -1, 599);

			break;
		case R.id.img_back:
			AppManager.getInstance().killActivity(this);
			break;

		default:
			break;
		}

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
		goback = (ImageView) findViewById(R.id.img_back);
		titleTextView = (TextView) findViewById(R.id.title_main);
		shouj = (EditText) findViewById(R.id.et_shouj);
		pswd = (EditText) findViewById(R.id.et_pswd);
		qrpswd = (EditText) findViewById(R.id.et_qrpswd);
		erpswd = (EditText) findViewById(R.id.et_erpswd);
		qrerpswd = (EditText) findViewById(R.id.et_qrerpswd);
		jies_elim = (EditText) findViewById(R.id.et_jies_elim);
		jies_sj = (EditText) findViewById(R.id.et_jies_sj);
		tyl = (CheckBox) findViewById(R.id.cb_toyi);
		name1 = (EditText) findViewById(R.id.et_name1);
		zhuce = (Button) findViewById(R.id.but_zhuce);
		ll_regist = (LinearLayout) findViewById(R.id.ll_regist);
		et_sms_code = (EditText) findViewById(R.id.et_sms_code);
		btn_sms = (Button) findViewById(R.id.btn_sms);
		titleTextView.setText("注册会员");
	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub
		goback.setOnClickListener(this);
		btn_sms.setOnClickListener(this);
		zhuce.setOnClickListener(this);
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
		if (what == 599) {
			RuquestBean smsBean = gson.fromJson(info, RuquestBean.class);
			if ("1".equals(smsBean.getError())) {
				ToastUtils.showTextToast(ctx, smsBean.getMsg());
				MyCountDownTimer mdt = new MyCountDownTimer(btn_sms, 120000,
						1000,0);
				mdt.start();
				return;
			} else {
				ToastUtils.showTextToast(ctx, smsBean.getMsg());
				return;
			}
		} else if (what == 112) {

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

		} else {

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
