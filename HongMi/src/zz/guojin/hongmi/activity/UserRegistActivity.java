package zz.guojin.hongmi.activity;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONException;
import org.json.JSONObject;

import zz.guojin.hongmi.utils.AppManager;
import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.utils.MyCountDownTimer;
import zz.guojin.hongmi.utils.NetUtils;
import zz.guojin.hongmi.utils.ReLoginUtil;
import zz.guojin.hongmi.utils.ToastUtils;
import zz.guojin.hongmi.utils.UiUtils;
import zz.guojin.hongmi.R;

import android.content.Context;
import android.graphics.Color;
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

import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.rest.Request;

public class UserRegistActivity extends BaseActivity implements OnClickListener {
	// (R.id.img_back)
	ImageView goback;
	// (R.id.title_main)
	TextView title;
	// (R.id.cb_toyi)
	CheckBox tyl;
	// (R.id.et_superior)
	EditText et_superior;
	// (R.id.et_login_phone)
	EditText et_login_phone;
	// (R.id.et_sms_code)
	EditText et_sms_code;
	// (R.id.et_true_name)
	EditText et_true_name;
	// (R.id.et_pwd)
	EditText et_pwd;
	// (R.id.et_pwd2)
	EditText et_pwd2;
	// (R.id.et_pwd_second)
	EditText et_pwd_second;
	// (R.id.et_pwd_second2)
	EditText et_pwd_second2;
	// (R.id.et_card)
	EditText et_card;
	// (R.id.et_qq)
	EditText et_qq;
	// (R.id.et_bank_account)
	EditText et_bank_account;
	// (R.id.et_bank_name)
	EditText et_bank_name;
	// (R.id.et_bank_user)
	EditText et_bank_user;
	// (R.id.et_chat)
	EditText et_chat;
	// (R.id.et_alipay)
	EditText et_alipay;
	// (R.id.but_zhuce)
	Button zhuce;
	// (R.id.ll_regist)
	LinearLayout ll_regist;
	// (R.id.btn_sms)
	Button btn_sms;
	// Button zhuce;
	String ty;
	private Request<String> request;
	private String mphone;
	private String code;
	private String pemail;
	private Context ctx;
	static int time = 120;
	private Timer timer;
	private static final int SEND_PHONE_CODE_TIME = 1001;

	// gridview用户注册界面

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
			if (!NetUtils.checkNet(ctx)) {
				ToastUtils.showTextToast(ctx, "网络连接不可用");
				return;
			}
			// 推荐人
			String referrer = et_superior.getText().toString().trim();
			// 登陆手机号
			String phone = et_login_phone.getText().toString().trim();
			// 短信验证码
			String sms_code = et_sms_code.getText().toString().trim();
			// 真实姓名
			String true_name = et_true_name.getText().toString().trim();
			// 登陆密码
			String pwd = et_pwd.getText().toString().trim();
			// 确认登陆密码
			String pwd2 = et_pwd2.getText().toString().trim();
			// 二级密码
			String secondPwd = et_pwd_second.getText().toString().trim();
			// 确认二级密码
			String secondPwd2 = et_pwd_second2.getText().toString().trim();
			// 身份证件
			String cardNum = et_card.getText().toString().trim();
			// qq
			String qq = et_qq.getText().toString().trim();
			// 银行账号
			String bankCard = et_bank_account.getText().toString().trim();
			// 银行名称
			String bankName = et_bank_name.getText().toString().trim();
			// 开户人
			String bankUser = et_bank_user.getText().toString().trim();
			// 微信
			String chatNum = et_chat.getText().toString().trim();
			// 支付宝
			String alipay = et_alipay.getText().toString().trim();
			if (!pwd2.equals(pwd)) {
				ToastUtils.showTextToast(ctx, "两次登陆密码不一致");
				return;
			}
			if (!secondPwd2.equals(secondPwd)) {
				ToastUtils.showTextToast(ctx, "两次二级密码不一致");
				return;
			}
			if (TextUtils.isEmpty(referrer) || TextUtils.isEmpty(phone)
					|| TextUtils.isEmpty(sms_code)
					|| TextUtils.isEmpty(true_name) || TextUtils.isEmpty(pwd)
					|| TextUtils.isEmpty(pwd2) || TextUtils.isEmpty(secondPwd)
					|| TextUtils.isEmpty(secondPwd2)
					|| TextUtils.isEmpty(cardNum) || TextUtils.isEmpty(qq)
					|| TextUtils.isEmpty(bankCard)
					|| TextUtils.isEmpty(bankName)
					|| TextUtils.isEmpty(bankUser)
					|| TextUtils.isEmpty(chatNum) || TextUtils.isEmpty(alipay)) {
				ToastUtils.showTextToast(ctx, "每一项都是必填内容");
				return;
			}
			if (pwd.length() < 6) {
				ToastUtils.showTextToast(context, "请输入6--12位登陆密码");
				return;
			}
			if (!"ye".equals(ty)) {
				ToastUtils.showTextToast(ctx, "确认是否了解所有风险");
				return;
			}
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("truen", true_name);// 姓名
			params.put("user", phone);// 账号，电话
			params.put("pemail", referrer);// 推荐人账号
			params.put("smsnum", sms_code);// 验证码
			params.put("password", pwd); // 登陆密码
			params.put("password1", pwd2);// 确认登陆密码
			params.put("secped", secondPwd);// 二级
			params.put("secpwd1", secondPwd2);// 确认二级
			params.put("sfz", cardNum);// 身份证
			params.put("qq", qq);// qq
			params.put("yhzh", bankCard);// 银行账号
			params.put("yhmc", bankName);// 银行名称
			params.put("zhxm", bankUser);// 开户人
			params.put("weixin", chatNum);// 微信
			params.put("zfb", alipay);// 支付宝
			ToRequestUrl(request, TAG, MUrlUtil.BASE_URL + MUrlUtil.REGIST,
					params, -1, -1, 112);

			break;
		case R.id.img_back:
			AppManager.getInstance().killActivity(this);
			break;
		case R.id.btn_sms:
			String mphone = et_login_phone.getText().toString().trim();

			if (isMobileNum(mphone)) {
				Map<String, Object> params1 = new HashMap<String, Object>();
				params1.put("user", mphone);
				ToRequestUrl(request, TAG,
						MUrlUtil.BASE_URL + MUrlUtil.SMS_PWD, params1, -1, -1,
						599);

			} else {
				ToastUtils.showTextToast(ctx, "手机号格式不对");
				return;
			}
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

	// 正则表达式 判断手机号
	public static boolean isMobileNum(String mobiles) {
		Pattern p = Pattern.compile("^1[34578]\\d{9}$");
		Matcher m = p.matcher(mobiles);
		return m.matches();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		//

	}

	@Override
	public int getLayoutResId() {
		// TODO Auto-generated method stub
		return R.layout.activity_regists;
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
		title = (TextView) findViewById(R.id.title_main);
		tyl = (CheckBox) findViewById(R.id.cb_toyi);
		et_superior = (EditText) findViewById(R.id.et_superior);
		et_login_phone = (EditText) findViewById(R.id.et_login_phone);
		et_sms_code = (EditText) findViewById(R.id.et_sms_code);
		et_true_name = (EditText) findViewById(R.id.et_true_name);
		et_pwd = (EditText) findViewById(R.id.et_pwd);
		et_pwd2 = (EditText) findViewById(R.id.et_pwd2);
		et_pwd_second = (EditText) findViewById(R.id.et_pwd_second);
		et_superior = (EditText) findViewById(R.id.et_superior);

		et_pwd_second2 = (EditText) findViewById(R.id.et_pwd_second2);
		et_card = (EditText) findViewById(R.id.et_card);
		et_qq = (EditText) findViewById(R.id.et_qq);
		et_bank_account = (EditText) findViewById(R.id.et_bank_account);
		et_bank_name = (EditText) findViewById(R.id.et_bank_name);
		et_bank_user = (EditText) findViewById(R.id.et_bank_user);
		et_chat = (EditText) findViewById(R.id.et_chat);
		et_alipay = (EditText) findViewById(R.id.et_alipay);
		zhuce = (Button) findViewById(R.id.but_zhuce);

		ll_regist = (LinearLayout) findViewById(R.id.ll_regist);
		btn_sms = (Button) findViewById(R.id.btn_sms);
		title.setText("注册");

	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub
		zhuce.setOnClickListener(this);
		goback.setOnClickListener(this);
		btn_sms.setOnClickListener(this);
		SetView();
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub

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
			String msg = jsonObject.getString("msg");
			String error = jsonObject.getString("error");
			ToastUtils.showTextToast(ctx, msg);
			if (what == 112) {
				// AppManager.getInstance().killActivity(this);

				if ("3".equals(error)) {
					ReLoginUtil.LoginAgain(ctx, LoginActivity.class);
					return;
				}
			}
			if (what == 599) {
				if ("发送成功".equals(msg)) {
					btn_sms.setBackgroundColor(Color.GRAY);
					btn_sms.setTextColor(0xffffffff);
					btn_sms.setEnabled(false);
					MyCountDownTimer mdt = new MyCountDownTimer(btn_sms,
							120000, 1000,0);
					mdt.start();

					return;
				}
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			Logger.e(TAG + e.getMessage());
		}
	}

}
