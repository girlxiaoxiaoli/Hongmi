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
import android.R.raw;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ChangeSecondPwdActivity extends BaseActivity {
	@Bind(R.id.img_back)
	ImageView goback;
	@Bind(R.id.title_main)
	TextView title;
	@Bind(R.id.et_before)
	EditText before;
	@Bind(R.id.et_new)
	EditText news;
	@Bind(R.id.et_qrnew)
	EditText qrnew;
	@Bind(R.id.ll_my_second_pwd)
	LinearLayout ll_my_second_pwd;
	@Bind(R.id.bu_yes)
	Button butt;
	private RequestQueue queue;
	private Context ctx;
	private Request<String> request;

	@OnClick(R.id.bu_yes)
	public void onClick(View v) {

		String ymm1 = before.getText().toString().trim();
		String xmm1 = news.getText().toString().trim();
		String xmmqr1 = qrnew.getText().toString().trim();
		if (ymm1.isEmpty() || xmm1.isEmpty() || xmmqr1.isEmpty()) {
			ToastUtils.showTextToast(ctx, "所输入内容不能为空");
			return;
		} else if (!xmm1.equals(xmmqr1)) {
			ToastUtils.showTextToast(ctx, "两次输入的密码不一样");
			return;
		}
		Map<String, Object> params = new HashMap<String, Object>();

		params.put("ymm1", ymm1);
		params.put("xmm1", xmm1);
		params.put("xmmqr1", xmmqr1);
		ToRequestUrl(request, TAG, MUrlUtil.BASE_URL
				+ MUrlUtil.CHANGE_SECOND_PWD, params, -1, -1, 116);

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

	@OnClick(R.id.img_back)
	public void goBack() {
		finish();
	}

	@Override
	public int getLayoutResId() {
		// TODO Auto-generated method stub
		return R.layout.activity_change_second_pwd;
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
		title.setText("修改二级密码");
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
		if (what == 116) {
			Gson gson = new Gson();
			RuquestBean son = gson.fromJson(info, RuquestBean.class);
			if ("1".equals(son.getError())) {
				ToastUtils.showTextToast(ctx, son.getMsg());
				return;
			} else if ("0".equals(son.getError())) {
				ToastUtils.showTextToast(ctx, son.getMsg());
				return;
			} else if ("3".equals(son.getError())) {
				ToastUtils.showTextToast(ctx, son.getMsg());
				ReLoginUtil.LoginAgain(ctx, LoginActivity.class);
				return;
			}
		}
	}
}
