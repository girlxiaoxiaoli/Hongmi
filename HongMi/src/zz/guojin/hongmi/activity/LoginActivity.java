package zz.guojin.hongmi.activity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import zz.guojin.hongmi.utils.AppManager;
import zz.guojin.hongmi.utils.JumpUtil;
import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.utils.SpUtils;
import zz.guojin.hongmi.utils.ToastUtils;
import zz.guojin.hongmi.R;
import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.rest.Request;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends BaseActivity implements OnClickListener {
	// (R.id.img_back)
	ImageView goback;
	// (R.id.title_main)
	TextView title;
	// (R.id.et_user)
	EditText et_user;
	// (R.id.et_pwd)
	EditText et_pwd;
	// (R.id.bt_login)
	Button login;
	// (R.id.tv_forget)
	TextView forget;
	// (R.id.zhucehy)
	TextView zc;

	private static final int LOGINSUCCESS = 101;
	private String username;
	private String password;
	private SharedPreferences sp;
	private Request<String> request;
	private Context context;

	// 忘记密码
	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.tv_forget:
			JumpUtil.JumpActivity(context, FindLoginPwdActivity.class);
			break;
		case R.id.zhucehy:
			JumpUtil.JumpActivity(context, UserRegistActivity.class);
			break;
		case R.id.bt_login:
			username = et_user.getText().toString().trim();
			password = et_pwd.getText().toString().trim();
			if (TextUtils.isEmpty(username) || TextUtils.isEmpty(password)) {
				ToastUtils.showTextToast(context, "账号密码不能为空");
				return;
			}

			Map<String, Object> params = new HashMap<String, Object>();
			params.put("username", username);
			params.put("password", password);
			ToRequestUrl(request, TAG, MUrlUtil.BASE_URL + MUrlUtil.LOGIN_URL,
					params, -1, -1, LOGINSUCCESS);
			break;
		case R.id.img_back:

			break;
		default:
			break;
		}

	}

	@Override
	public int getLayoutResId() {
		// TODO Auto-generated method stub
		return R.layout.activity_login;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		context = this;
	}

	@Override
	public void initView() {
		// TODO Auto-generated method stub
		goback = (ImageView) findViewById(R.id.img_back);
		title = (TextView) findViewById(R.id.title_main);
		et_user = (EditText) findViewById(R.id.et_user);
		et_pwd = (EditText) findViewById(R.id.et_pwd);
		login = (Button) findViewById(R.id.bt_login);
		forget = (TextView) findViewById(R.id.tv_forget);
		zc = (TextView) findViewById(R.id.zhucehy);

		goback.setVisibility(View.GONE);
		title.setText("登陆");
	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub
		forget.setOnClickListener(this);
		zc.setOnClickListener(this);
		login.setOnClickListener(this);
		goback.setOnClickListener(this);

	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		if ((Boolean) SpUtils.get(context, "IS_LOGIN", false)) {
			et_user.setText((String) SpUtils.get(context, "USER_NAME", ""));
			et_user.setSelection(((String) SpUtils
					.get(context, "USER_NAME", "")).length());
			et_pwd.setText((String) SpUtils.get(context, "PASSWORD", ""));
		} else {
			et_user.setText((String) SpUtils.get(context, "USER_NAME", ""));
			et_user.setSelection(((String) SpUtils
					.get(context, "USER_NAME", "")).length());
		}
	}

	@Override
	public void toStartProgressDialog() {
		// TODO Auto-generated method stub
		toStartProgressDialg(true);
	}

	@Override
	public void doWhatForRequest(int what, String info) {
		// TODO Auto-generated method stub
		if (what == LOGINSUCCESS) {

			try {
				JSONObject jsonObject = new JSONObject(info);
				String error = jsonObject.getString("error");
				String msg = jsonObject.getString("msg");
				ToastUtils.showTextToast(context, msg);
				if ("1".equals(error)) {

					// 记住用户名、密码、
					SpUtils.put(context, "USER_NAME", username);
					SpUtils.put(context, "PASSWORD", password);
					SpUtils.put(context, "IS_LOGIN", true);

					JumpUtil.JumpActivity(context, MainActivity.class);
					AppManager.getInstance().killActivity(this);
					return;
				}
			} catch (Exception e) {
				// TODO: handle exception

				Logger.e(getClassName() + "login" + e.getMessage());
			}
		}
	}
}
