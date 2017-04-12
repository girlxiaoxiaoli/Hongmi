package zz.guojin.hongmi.activity;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.rest.Request;

import zz.guojin.hongmi.R;
import zz.guojin.hongmi.R.layout;
import zz.guojin.hongmi.R.menu;
import zz.guojin.hongmi.utils.AppManager;
import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.utils.ReLoginUtil;
import zz.guojin.hongmi.utils.ToastUtils;
import android.os.Bundle;
import android.R.integer;
import android.app.Activity;
import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class DaMiActivity extends BaseActivity implements OnClickListener {
	private ImageView goback;
	private TextView title, confirm;
	private EditText limit_offer, money_offer, secpwd_offer;
	private Context context;
	private Request<String> request;

	@Override
	public int getLayoutResId() {
		// TODO Auto-generated method stub
		return R.layout.activity_da_mi;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		AppManager.getInstance().addActivity(this);
		context = this;
	}

	@Override
	public void initView() {
		// TODO Auto-generated method stub
		goback = (ImageView) findViewById(R.id.img_back);
		title = (TextView) findViewById(R.id.title_main);
		limit_offer = (EditText) findViewById(R.id.et_limit_offer);
		money_offer = (EditText) findViewById(R.id.et_money_offer);
		secpwd_offer = (EditText) findViewById(R.id.et_pwd_offer);
		confirm = (TextView) findViewById(R.id.confirm_offer);
		title.setText("打米");

	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub
		goback.setOnClickListener(this);
		confirm.setOnClickListener(this);

	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		ToRequestUrl(request, TAG, MUrlUtil.BASE_URL + MUrlUtil.LIMIT_OFFER,
				null, -1, -1, 320);

	}

	@Override
	public void toStartProgressDialog() {
		// TODO Auto-generated method stub
		toStartProgressDialg(true);
	}

	@Override
	public void doWhatForRequest(int what, String info) {
		// TODO Auto-generated method stub
		JSONObject jsonObject;
		try {

			jsonObject = new JSONObject(info);
			String error = jsonObject.getString("error");
			if ("1".equals(error)) {
				switch (what) {
				case 320:

					JSONObject jObject = jsonObject.getJSONObject("data");
					String tlower = jObject.getString("tlower"); // 提供帮助最低额度
					String tupper = jObject.getString("tupper");// 提供帮助最高额度
					limit_offer.setText(tlower + "-" + tupper);
					break;
				case 30:
					String msg = jsonObject.getString("msg");
					ToastUtils.showTextToast(context, msg);

					break;

				default:
					break;
				}
			} else {
				String msg = jsonObject.getString("msg");
				ToastUtils.showTextToast(context, msg);
				if ("3".equals(error)) {
					ReLoginUtil.LoginAgain(context, LoginActivity.class);
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			Logger.e(TAG + e.getMessage());
		}

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		switch (id) {
		case R.id.img_back:
			finish();

			break;
		case R.id.confirm_offer:
			String money = money_offer.getText().toString().trim();
			String secpwd = secpwd_offer.getText().toString().trim();
			if (TextUtils.isEmpty(money) || TextUtils.isEmpty(secpwd)) {
				ToastUtils.showTextToast(context, "请填写完整");
			}
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("amount", money);
			params.put("password", secpwd);
			ToRequestUrl(request, TAG, MUrlUtil.BASE_URL
					+ MUrlUtil.CONFIRM_OFFER, params, -1, -1, 30);

			break;

		default:
			break;
		}
	}

}
