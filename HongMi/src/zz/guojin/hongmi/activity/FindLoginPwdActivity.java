package zz.guojin.hongmi.activity;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.rest.Request;
import zz.guojin.hongmi.utils.AppManager;
import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.utils.MyCountDownTimer;
import zz.guojin.hongmi.utils.SpUtils;
import zz.guojin.hongmi.utils.ToastUtils;
import zz.guojin.hongmi.R;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/10/28. 找回登陆密码
 */

public class FindLoginPwdActivity extends BaseActivity implements OnClickListener {
	//(R.id.img_back)
	ImageView ivGoback;
	//(R.id.title_main)
	TextView titleTextView;
	//(R.id.et_phone)
	EditText etPhone;
	//(R.id.et_phone_code)
	EditText etPhoneCode;
	//(R.id.et_phone_pwd)
	EditText etPhonePwd;
	//(R.id.btn_number_code)
	Button btnNumberCode;

	//(R.id.btn_confirm)
	Button btnConfirm;
	private String loginPhone;
	private String pwd ;
	private Context ctx;
	private Request<String> oneRequest;
	static int time = 120;
	private Timer timer;
	private Request<String> request;
	private static final int SEND_PHONE_CODE_TIME = 1001;


	

	private void findLoginPwd() {
		String code = etPhoneCode.getText().toString().trim();
		pwd = etPhonePwd.getText().toString().trim();
		loginPhone = etPhone.getText().toString().trim();
		if (!TextUtils.isEmpty(code) && !TextUtils.isEmpty(loginPhone)
				&& !TextUtils.isEmpty(pwd)) {
			if (isMobileNum(loginPhone)) {
				Map<String, Object> params = new HashMap<String, Object>();
				params.put("user", loginPhone);
				params.put("smsnum", code);
				params.put("password", pwd);
				ToRequestUrl(request, TAG, MUrlUtil.BASE_URL + MUrlUtil.FORGET,
						params, -1, -1, 10);

			} else {
				ToastUtils.showTextToast(ctx, "手机号不对");
			}
		} else {
			ToastUtils.showTextToast(ctx, "请补全内容");
		}
	}

	private void getCode() {
		loginPhone = etPhone.getText().toString().trim();
		if (!TextUtils.isEmpty(loginPhone)) {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("user", loginPhone);
			ToRequestUrl(request, TAG, MUrlUtil.BASE_URL + MUrlUtil.SMS_PWD,
					params, -1, -1, 2);

		} else {
			ToastUtils.showTextToast(ctx, "请输入手机号");
		}
	}

	

	// 正则表达式 判断手机号
	public static boolean isMobileNum(String mobiles) {
		Pattern p = Pattern.compile("^1[34578]\\d{9}$");
		Matcher m = p.matcher(mobiles);
		return m.matches();
	}

	@Override
	public int getLayoutResId() {
		// TODO Auto-generated method stub
		return R.layout.activity_find_login_pwd;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		AppManager.getInstance().addActivity(this);
	}

	@Override
	public void initView() {
		// TODO Auto-generated method stub
		ivGoback =(ImageView)findViewById(R.id.img_back);
		titleTextView =(TextView)findViewById(R.id.title_main);
		etPhone =(EditText)findViewById(R.id.et_phone);
		etPhoneCode =(EditText)findViewById(R.id.et_phone_code);
		etPhonePwd =(EditText)findViewById(R.id.et_phone_pwd);
		btnNumberCode =(Button)findViewById(R.id.btn_number_code);
		btnConfirm =(Button)findViewById(R.id.btn_confirm);

		titleTextView.setText("忘记密码");
	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub
         btnConfirm.setOnClickListener(this);
         btnNumberCode.setOnClickListener(this);
         ivGoback.setOnClickListener(this);
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		ctx = this;
	
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
			if (what == 10) {
			if("1".equals(error)){
				SpUtils.put(context, "USER_NAME", loginPhone);
				SpUtils.put(context, "PASSWORD", pwd);
			}
			}
			if (what == 2) {
				if ("发送成功".equals(msg)) {
					btnNumberCode.setBackgroundColor(Color.GRAY);
					btnNumberCode.setTextColor(0xffffffff);
					btnNumberCode.setEnabled(false);
					MyCountDownTimer mdt = new MyCountDownTimer(btnNumberCode,
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

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub]
		int id = v.getId();
		switch (id) {
		case R.id.btn_number_code:
			getCode();// 获取验证码
			break;
		case R.id.btn_confirm:
			findLoginPwd();// 找回登陆密码
			break;
		case R.id.img_back:
			finish();
			break;
		}
	}

	
	
}
