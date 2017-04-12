package zz.guojin.hongmi.activity;

import zz.guojin.hongmi.bean.RuquestBean;
import zz.guojin.hongmi.utils.AppManager;
import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.utils.NetUtils;
import zz.guojin.hongmi.utils.SpUtils;
import zz.guojin.hongmi.utils.ToastUtils;
import zz.guojin.hongmi.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;

import com.google.gson.Gson;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.RequestQueue;
import com.yolanda.nohttp.rest.Response;

public class SplashActivity extends Activity {
	boolean isFirstInSuc = false;

	private static final int GO_HOME = 1000;
	private static final int GO_LOGIN = 1001;
	// 延迟2秒
	private static final long SPLASH_DELAY_MILLIS = 2000;

	private static final String MY_SHAREDPREFERENCES = "first_login";
	private Context ctx;
	/**
	 * Handler:跳转到不同界面
	 */
	private Handler mHandler = new Handler() {

		@Override
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case GO_HOME:
				initData();
				break;
			case GO_LOGIN:
				goLogin();
				break;
			}
			super.handleMessage(msg);
		}

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		AppManager.getInstance().addActivity(this);
		setContentView(R.layout.splash);
		ctx = this;
		un = (String) SpUtils.get(this, "USER_NAME", "");
		pwd = (String) SpUtils.get(this, "PASSWORD", "");
		init();
	}

	private void init() {
		if (!NetUtils.checkNet(ctx)) {
			ToastUtils.showTextToast(ctx, "网络不可用");
			Intent intent = new Intent(ctx, LoginActivity.class);
			startActivity(intent);
			SplashActivity.this.finish();
			return;
		}
		// 读取SharedPreferences中需要的数据
		// 使用SharedPreferences来记录程序的使用次数

		// 取得相应的值，如果没有该值，说明还未写入，用true作为默认值
		isFirstInSuc = (Boolean) SpUtils.get(this, "IS_LOGIN", false);
		if (!un.isEmpty() && !pwd.isEmpty()) {
			// mHandler.sendEmptyMessageDelayed(GO_LOGIN, SPLASH_DELAY_MILLIS);
			// 判断程序与第几次运行，如果是第一次登陆则跳转到登陆，否则跳转到主界面
			if (isFirstInSuc) {
				// 使用Handler的postDelayed方法，3秒后执行跳转到MainActivity
				mHandler.sendEmptyMessageDelayed(GO_HOME, SPLASH_DELAY_MILLIS);
			} else {
				mHandler.sendEmptyMessageDelayed(GO_LOGIN, SPLASH_DELAY_MILLIS);
			}
		} else {
			mHandler.sendEmptyMessageDelayed(GO_LOGIN, SPLASH_DELAY_MILLIS);
		}

	}

	private void goHome() {
		Intent intent = new Intent(SplashActivity.this, MainActivity.class);
		SplashActivity.this.startActivity(intent);
		SplashActivity.this.finish();
	}

	private void goLogin() {
		Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
		SplashActivity.this.startActivity(intent);
		SplashActivity.this.finish();
	}

	private void initData() {
		// TODO Auto-generated method stub
		RequestQueue queue = NoHttp.newRequestQueue();
		Request<String> request = NoHttp.createStringRequest(MUrlUtil.BASE_URL
				+ MUrlUtil.LOGIN_URL, RequestMethod.GET);
		request.add("username", un);
		request.add("password", pwd);
		queue.add(555, request, responseListener);
	}

	OnResponseListener<String> responseListener = new OnResponseListener<String>() {

		@Override
		public void onStart(int what) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onSucceed(int what, Response<String> response) {
			// TODO Auto-generated method stub
			if (what == 555) {
				Gson gson = new Gson();
				String info = response.get();
				RuquestBean bean = gson.fromJson(info, RuquestBean.class);
				if ("1".equals(bean.getError())) {
					ToastUtils.showTextToast(ctx, bean.getMsg());
					goHome();
				} else {
					ToastUtils.showTextToast(ctx, bean.getMsg());
					goLogin();
				}
			}
		}

		@Override
		public void onFinish(int what) {
			// TODO Auto-generated method stub
		}

		@Override
		public void onFailed(int what, Response<String> response) {
			// TODO Auto-generated method stub
			ToastUtils.showTextToast(ctx, "服务器异常,请稍后再试");
			goLogin();
		}
	};

	private String un;

	private String pwd;
}
