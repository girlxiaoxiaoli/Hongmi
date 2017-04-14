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
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;

//得
public class GetActivity extends BaseActivity {
	@Bind(R.id.img_back)
	ImageView iv_goback;
	@Bind(R.id.title_main)
	TextView title;
	@Bind(R.id.tv_hongmi_purse)
	TextView tv_hongmi_purse;
	@Bind(R.id.tv_jingli_purse)
	TextView tv_jingli_purse;
	@Bind(R.id.tv_tuijian_purse)
	TextView tv_tuijian_purse;
	@Bind(R.id.et_money_get)
	EditText et_money_get;
	@Bind(R.id.et_pwd_get)
	EditText et_pwd_get;
	@Bind(R.id.purse)
	RadioGroup purse;
	@Bind(R.id.hongmi_purse_get)
	RadioButton hongmi_purse_get;
	@Bind(R.id.jingli_purse_get)
	RadioButton jingli_purse_get;
	@Bind(R.id.tuijian_purse_get)
	RadioButton tuijian_purse_get;

	@Bind(R.id.butt_tjbz)
	Button jsbz;

	@Bind(R.id.ll_accept_help)
	RelativeLayout ll_accept_help;

	int temp = 1;
	private Context ctx;
	Request<String> request;

	@OnClick(R.id.butt_tjbz)
	public void onClick(View v) {

		// 判断交易钱包的勾选状态
		if (temp == 0) {
			ToastUtils.showTextToast(getApplicationContext(), "请选择交易的钱包");
			return;
		}

		String amount = et_money_get.getText().toString().trim();
		String secpwd = et_pwd_get.getText().toString().trim();
		if (TextUtils.isEmpty(amount)) {
			ToastUtils.showTextToast(getApplicationContext(), "金额不能为空");
			return;
		}
		if (TextUtils.isEmpty(secpwd)) {
			ToastUtils.showTextToast(getApplicationContext(), "请输入二级密码");
			return;
		}

		// 判断 金额输入框里的金额是不是整数格式的。
		if (!TextUtils.isDigitsOnly(amount)) {
			// 判断一个字符串是不是一个数字
			ToastUtils.showTextToast(getApplicationContext(), "金额输入格式错误");
			return;// 不是数据下面就不强转了。
		}
		int i = Integer.parseInt(amount);

		if (i < 100) {
			ToastUtils.showTextToast(getApplicationContext(), "输入金额格式有误");
			return;
		}
		// 要请求的url和 请求方式
		Map<String, Object> params = new HashMap<String, Object>();
		// 把数据提交到服务器 。

		params.put("purse", temp);
		params.put("get_amount", amount);
		 params.put("pwd", secpwd);
		ToRequestUrl(request, TAG, MUrlUtil.BASE_URL + MUrlUtil.ACCEPT_URL,
				params, -1, -1, 111);

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

	// 点击左上角按钮返回上一个页面
	@OnClick(R.id.img_back)
	public void goBack() {
		finish();
	}

	@Override
	public int getLayoutResId() {
		// TODO Auto-generated method stub
		return R.layout.activity_accept_help;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		AppManager.getInstance().addActivity(this);
		ctx = this;
	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub

		purse.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				switch (checkedId) {
				case R.id.hongmi_purse_get:
					temp = 1;
					break;
				case R.id.jingli_purse_get:
					temp = 2;
					break;
				case R.id.tuijian_purse_get:
					temp = 2;
					break;

				default:
					break;
				}

			}

		});

	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub

		Intent intent = getIntent();
		String money_hongmi = intent.getStringExtra("hongmi_money");
		String money_jingli = intent.getStringExtra("jingli_money");
		String money_tuijian = intent.getStringExtra("tuijian_money");

		tv_hongmi_purse.setText("余额： "+money_hongmi);
		tv_jingli_purse.setText("余额： "+money_jingli);
		tv_tuijian_purse.setText("余额： "+money_tuijian);
	}

	@Override
	public void toStartProgressDialog() {
		// TODO Auto-generated method stub
		toStartProgressDialg(true);
	}

	@Override
	public void initView() {
		// TODO Auto-generated method stub
		title.setText("接受帮助");
	}

	@Override
	public void doWhatForRequest(int what, String info) {
		// TODO Auto-generated method stub
		if (what == 111) {

			System.out.println("接受info" + info);
			Gson gson = new Gson();
			RuquestBean qs = gson.fromJson(info, RuquestBean.class);
//			System.out.println(qs.getError() + "有没有数据呀！！！！！！！！！！！！！！！！");
			if ("1".equals(qs.getError())) {
				ToastUtils.showTextToast(ctx, qs.getMsg());
				finish();
				return;
			} else if ("0".equals(qs.getError())) {
				ToastUtils.showTextToast(ctx, qs.getMsg());
				return;
			} else if ("3".equals(qs.getError())) {
				ToastUtils.showTextToast(ctx, qs.getMsg());
				ReLoginUtil.LoginAgain(getApplicationContext(),
						LoginActivity.class);
				return;
			}
		}
	}
}
