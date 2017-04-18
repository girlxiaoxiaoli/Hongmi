package zz.guojin.hongmi.activity;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.RequestQueue;

import butterknife.Bind;
import butterknife.OnClick;
import zz.guojin.hongmi.utils.AppManager;
import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.utils.ReLoginUtil;
import zz.guojin.hongmi.utils.SpUtils;
import zz.guojin.hongmi.utils.ToastUtils;
import zz.guojin.hongmi.R;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ChangeLoginPwdActivity extends BaseActivity {
	@Bind(R.id.img_back)
	ImageView goback;
	@Bind(R.id.title_main)
	TextView title;
	@Bind(R.id.et_pwd)
	EditText et_pwd;
	@Bind(R.id.et_new_pwd)
	EditText et_new_pwd;
	@Bind(R.id.et_confirm_new_pwd)
	EditText et_confirm_new_pwd;
	@Bind(R.id.btn_submit)
	Button btn;
	@Bind(R.id.ll_my_login_pwd)
	LinearLayout ll_my_login_pwd;
	private Context ctx;
	private Request<String> request;
	private String xmm;

	// 点击左上角按钮返回上一个页面
	@OnClick(R.id.img_back)
	public void goBack() {
		finish();
	}

	@OnClick(R.id.btn_submit)
	public void changLoginPwd(View v) {

		String ymm = et_pwd.getText().toString().trim();
		xmm = et_new_pwd.getText().toString().trim();
		String xmmqr = et_confirm_new_pwd.getText().toString().trim();
		if (TextUtils.isEmpty(ymm) || TextUtils.isEmpty(xmm)
				|| TextUtils.isEmpty(xmmqr)) {
			ToastUtils.showTextToast(ctx, "输入内容不能为空");
			return;
		} 
		
		if (!xmm.equals(xmmqr)) {
			ToastUtils.showTextToast(ctx, "两次输入的新密码不一样");
			return;
		}
		if(xmm.length()<6){
			ToastUtils.showTextToast(ctx, "请输入6--12位密码");
			return;
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("ymm", ymm);
		params.put("xmm", xmm);
		params.put("xmmqr", xmmqr);
		ToRequestUrl(request, TAG, MUrlUtil.BASE_URL
				+ MUrlUtil.CHANGE_LOGIN_PWD, params, -1, -1, 119);

	}



	@Override
	public int getLayoutResId() {
		// TODO Auto-generated method stub
		return R.layout.activity_change_pwd;
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
		title.setText("修改登陆密码");
	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub

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
		if (what == 119) {
			try {
				JSONObject jsonObject = new JSONObject(info);
				String error = jsonObject.getString("error");
				String msg = jsonObject.getString("msg");
				ToastUtils.showTextToast(ctx, msg);
				if ("1".equals(error)) {
					SpUtils.put(ctx, "PASSWORD", xmm);

					SpUtils.put(context, "IS_LOGIN", false);
					ReLoginUtil.LoginAgain(ctx, LoginActivity.class);
					return;
				} else if ("0".equals(error)) {
					return;
				} else if ("3".equals(error)) {
					ReLoginUtil.LoginAgain(ctx, LoginActivity.class);
					return;
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				Logger.e(TAG + e.getMessage());
			}
		}
	}
}
