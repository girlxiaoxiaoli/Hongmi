package zz.guojin.hongmi.activity;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.Request;

import zz.guojin.hongmi.bean.RuquestBean;
import zz.guojin.hongmi.utils.AppManager;
import zz.guojin.hongmi.utils.JumpUtil;
import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.utils.ReLoginUtil;
import zz.guojin.hongmi.utils.ToastUtils;
import zz.guojin.hongmi.utils.UiUtils;
import zz.guojin.hongmi.R;
import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActivationCodeActivity extends BaseActivity implements OnClickListener{
	//(R.id.img_back)
	ImageView goback;
	//(R.id.title_main)
	TextView title;
	//(R.id.et_code_account)
	EditText account;
	//(R.id.et_user)
	EditText user;
	//(R.id.et_code_second_pwd)
	EditText sdpwd;
	//(R.id.tv_count)
	TextView tv_count;
	//(R.id.btn_notes)
	Button btn_notes;
	//(R.id.btn_ok)
	Button btn_ok;
	LinearLayout ll_code_exchange;
	private Context ctx;
	private String trim1;// 输入的激活码数量
	private String jhmCount;// 原始可用激活码数量字符串
	private int jhmCountInt;
	protected static final int FLSH_UI = 100;
	private Request<String> request;

	// gridview激活码管理界面

	

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
		return R.layout.activity_code;
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
		title.setText("激活码转让");
		account = (EditText) findViewById(R.id.et_code_account);
		user = (EditText) findViewById(R.id.et_user);
		sdpwd = (EditText) findViewById(R.id.et_user);
		tv_count = (TextView) findViewById(R.id.tv_count);
		btn_notes = (Button) findViewById(R.id.btn_notes);
		btn_ok = (Button) findViewById(R.id.btn_ok);
		
		ll_code_exchange = (LinearLayout) findViewById(R.id.ll_code_exchange);
		btn_ok.setOnClickListener(this);
		btn_notes.setOnClickListener(this);
		goback.setOnClickListener(this);

	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		ToRequestUrl(request, TAG, MUrlUtil.BASE_URL + MUrlUtil.ACTIVE_CODE,
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
					jhmCount = jsonObject.getString("data");
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

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		switch (id) {
		case R.id.btn_ok:
			// 确认转账
			
				trim1 = account.getText().toString().trim();
				String trim2 = user.getText().toString().trim();
				String trim3 = sdpwd.getText().toString().trim();
				if (TextUtils.isEmpty(trim1) && TextUtils.isEmpty(trim2)
						&& TextUtils.isEmpty(trim3)) {
					ToastUtils.showTextToast(ctx, "内容不能为空");
				}
				Map<String, Object> params = new HashMap<String, Object>();

				Request<String> request = NoHttp.createStringRequest(MUrlUtil.BASE_URL
						+ MUrlUtil.EXCHANGE_URL, RequestMethod.GET);
				params.put("sh1", trim1);
				params.put("user1", trim2);
				params.put("ejmm1", trim3);
				ToRequestUrl(request, TAG, MUrlUtil.BASE_URL + MUrlUtil.EXCHANGE_URL,
						params, -1, -1, 333);
		
			
			break;
		case R.id.btn_notes:
			JumpUtil.JumpActivity(ctx, NotesActivity.class);

			break;
		case R.id.img_back:
			AppManager.getInstance().killActivity(this);

			break;

		default:
			break;
		}
		

		
	}
}
