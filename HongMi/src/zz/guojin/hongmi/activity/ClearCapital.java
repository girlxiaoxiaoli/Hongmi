package zz.guojin.hongmi.activity;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import com.yolanda.nohttp.rest.Request;

import zz.guojin.hongmi.R;
import zz.guojin.hongmi.R.id;
import zz.guojin.hongmi.R.layout;
import zz.guojin.hongmi.utils.AppManager;
import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.utils.ReLoginUtil;
import zz.guojin.hongmi.utils.SpUtils;
import zz.guojin.hongmi.utils.ToastUtils;
import android.os.Bundle;
import android.R.integer;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.text.TextUtils;
/**
 * 清算本金
 * @author Administrator
 *
 */
public class ClearCapital extends BaseActivity implements OnClickListener{
  private EditText et_clear_capital,et_secpwed;
  private TextView confirm,title;
  private ImageView goback;
  private Context context;
  private Request<String> request;
	@Override
	public int getLayoutResId() {
		// TODO Auto-generated method stub
		return R.layout.activity_clear_capital;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		context=this;
		AppManager.getInstance().addActivity(this);
	}

	@Override
	public void initView() {
		// TODO Auto-generated method stub
		et_clear_capital = (EditText) findViewById(R.id.et_clear_capital);
		
		et_secpwed = (EditText) findViewById(R.id.et_pwd_clear_capital);
		confirm = (TextView) findViewById(R.id.confirm_clear_capital);
		title = (TextView) findViewById(R.id.title_main);
		goback = (ImageView) findViewById(R.id.img_back);
		title.setText("清算本金");
		et_clear_capital.setFocusable(false);
		
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
		et_clear_capital.setText(getIntent().getStringExtra("money"));
		
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
			String error = jsonObject.getString("error");
			String msg =jsonObject.getString("msg");
			ToastUtils.showTextToast(context, msg);
			if("1".equals(error)){
				SpUtils.put(context, "IS_LOGIN", false);
				AppManager.getInstance().killAllActivity();
			ReLoginUtil.LoginAgain(context, LoginActivity.class);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id=v.getId();
		switch (id) {
		case R.id.img_back:
			AppManager.getInstance().killActivity(this);
			break;
		case R.id.confirm_clear_capital:
			//TODO 提交
			String money = et_clear_capital.getText().toString().trim();
			String pwd = et_secpwed.getText().toString().trim();
			if(TextUtils.isEmpty(money) || TextUtils.isEmpty(pwd)){
				ToastUtils.showTextToast(context, "请填写完整");
				return;
			}
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("get_amount",money);
			params.put("ejmm1",pwd);
			ToRequestUrl(request, TAG, MUrlUtil.BASE_URL+MUrlUtil.CLEAR_CAPITAL, params, -1,-1,520);
			

		default:
			break;
		}
	}

	
}
