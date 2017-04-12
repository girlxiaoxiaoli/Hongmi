package zz.guojin.hongmi.activity;

import java.io.Flushable;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.yolanda.nohttp.Logger;
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
import zz.guojin.hongmi.utils.JumpUtil;
import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.utils.NetUtils;
import zz.guojin.hongmi.utils.ReLoginUtil;
import zz.guojin.hongmi.utils.ToastUtils;
import zz.guojin.hongmi.utils.UiUtils;
import zz.guojin.hongmi.R;
import android.R.integer;
import android.R.raw;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
/**
 *抢单币管理
 * @author Administrator
 *
 */
public class QiangCodeActivity extends BaseActivity {
	@Bind(R.id.img_back)
	ImageView goback;
	@Bind(R.id.title_main)
	TextView title;
	@Bind(R.id.et_code_account_qiang)
	EditText account;
	@Bind(R.id.et_user_qiang)
	EditText user;
	@Bind(R.id.et_code_second_pwd_qiang)
	EditText sdpwd;
	@Bind(R.id.tv_count_qiang)
	TextView tv_count;
	@Bind(R.id.btn_notes_qiang)
	Button btn_notes;
	@Bind(R.id.btn_ok_qiang)
	Button btn_ok;
	
	private Context ctx;
	private String trim1;// 输入的激活码数量
	private String jhmCount;// 原始可用激活码数量字符串
	private int jhmCountInt;
	protected static final int FLSH_UI = 100;
	private Request<String> request;

	// gridview激活码管理界面

	// 确认转账
	@OnClick(R.id.btn_ok_qiang)
	public void btnConfirm(Button btn) {
		
		trim1 = account.getText().toString().trim();
		String trim2 = user.getText().toString().trim();
		String trim3 = sdpwd.getText().toString().trim();
		if (TextUtils.isEmpty(trim1) && TextUtils.isEmpty(trim2)
				&& TextUtils.isEmpty(trim3)) {
			ToastUtils.showTextToast(ctx, "内容不能为空");
		}
		Map<String, Object> params = new HashMap<String, Object>();
		
		Request<String> request = NoHttp.createStringRequest(MUrlUtil.BASE_URL
				+ MUrlUtil.EXCHNAGE_QIANG_CODE, RequestMethod.GET);
		params.put("sh1", trim1);
		params.put("user1", trim2);
		params.put("ejmm1", trim3);
		ToRequestUrl(request, TAG,  MUrlUtil.BASE_URL
				+ MUrlUtil.EXCHNAGE_QIANG_CODE,params, -1, -1, 333);
	}


	private Handler hanlder = new Handler() {
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case FLSH_UI:
				int trim1Int = Integer.parseInt(trim1);
				jhmCountInt = Integer.valueOf(jhmCount);
				int count = jhmCountInt - trim1Int;
				tv_count.setText(Integer.toString(count));
				jhmCountInt = count;
				account.setText("");
				user.setText("");
				sdpwd.setText("");
				break;
			default:
				break;
			}
		};
	};

	// 转账记录
	@OnClick(R.id.btn_notes_qiang)
	public void getNotes(Button btn) {
		JumpUtil.JumpActivity(ctx, QiangNotesActivity.class);

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
		return R.layout.activity_code_qiang;
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
		title.setText("抢单币转让");

	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		ToRequestUrl(request, TAG, MUrlUtil.BASE_URL + MUrlUtil.QIANG_CODE,
				null, -1, -1, 33);
	}

	@Override
	public void toStartProgressDialog() {
		// TODO Auto-generated method stub
		toStartProgressDialg(true);
	}

	@Override
	public void doWhatForRequest(int what, String info) {
		// TODO Auto-generated method stub
		if (what == 33) {
			JSONObject jsonObject;
			try {
				jsonObject = new JSONObject(info);
				if (!jsonObject.isNull("data")) {
					jhmCount = jsonObject.getJSONObject("data").getString("ue_pdb");
					tv_count.setText(jhmCount);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				Logger.e(TAG + e.getMessage());
			}

		}
		if (what == 333) {
			Gson gson = new Gson();
			RuquestBean aee = gson.fromJson(info, RuquestBean.class);
			if ("1".equals(aee.getError())) {
				ToastUtils.showTextToast(ctx, aee.getMsg());

				hanlder.sendEmptyMessage(FLSH_UI);
			} else if ("0".equals(aee.getError())) {
				ToastUtils.showTextToast(ctx, aee.getMsg());
				return;
			} else if ("3".equals(aee.getError())) {
				ToastUtils.showTextToast(ctx, aee.getMsg());
				ReLoginUtil.LoginAgain(ctx, LoginActivity.class);
				return;
			}
		}
	}
}
