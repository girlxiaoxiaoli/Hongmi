package zz.guojin.hongmi.activity;


import com.google.gson.Gson;
import com.yolanda.nohttp.rest.Request;

import zz.guojin.hongmi.bean.PersonalBean;
import zz.guojin.hongmi.utils.AppManager;
import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.R;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PersonalDataActivity extends BaseActivity {

	// //(R.id.tv_theme)EditText theme;
	//(R.id.img_back)
	ImageView goback;
	//(R.id.title_main)
	TextView title;
	//(R.id.real_name)
	TextView name;
	//(R.id.tv_supper_user)
	TextView tv_supper_user;
	//(R.id.tv_qq)
	TextView tv_qq;
	//(R.id.tv_bank_user)
	TextView tv_bank_user;
	
	//(R.id.tv_phone)
	TextView phone;
	//(R.id.tv_weixin)
	TextView weixin;
	//(R.id.tv_zhifu)
	TextView zhifu;
	//(R.id.tv_bank)
	TextView bank;
	//(R.id.tv_bank_account)
	TextView bank_account;
	//(R.id.ll_my_personal_data)
	LinearLayout ll_my_personal_data;
	private Context ctx;
	Request<String> request;



	@Override
	public int getLayoutResId() {
		// TODO Auto-generated method stub
		return R.layout.activity_personal_data;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		ctx = this;
	}

	@Override
	public void initView() {
		// TODO Auto-generated method stub
		goback=(ImageView)findViewById(R.id.img_back);
	
		title=(TextView)findViewById(R.id.title_main);
		name=(TextView)findViewById(R.id.real_name);
		tv_supper_user=(TextView)findViewById(R.id.tv_supper_user);
		tv_qq=(TextView)findViewById(R.id.tv_qq);
		tv_bank_user=(TextView)findViewById(R.id.tv_bank_user);
		phone=(TextView)findViewById(R.id.tv_phone);
		weixin=(TextView)findViewById(R.id.tv_weixin);
		zhifu=(TextView)findViewById(R.id.tv_zhifu);
		bank=(TextView)findViewById(R.id.tv_bank);
		bank_account=(TextView)findViewById(R.id.tv_bank_account);
		ll_my_personal_data=(LinearLayout)findViewById(R.id.ll_my_personal_data);
		
		title.setText("个人资料");
	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub
		goback.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AppManager.getInstance().killActivity(PersonalDataActivity.this);
			}
		});

	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		ToRequestUrl(request, TAG, MUrlUtil.BASE_URL + MUrlUtil.PERSONAL_DATA,
				null, -1, -1, 212);
	}

	@Override
	public void toStartProgressDialog() {
		// TODO Auto-generated method stub
		toStartProgressDialg(true);
	}

	@Override
	public void doWhatForRequest(int what, String info) {
		// TODO Auto-generated method stub
		if (what == 212) {
			Gson gson = new Gson();
			PersonalBean personalBean = gson.fromJson(info, PersonalBean.class);

			name.setText(personalBean.getData().getUe_truename());
			phone.setText(personalBean.getData().getUe_account());
			weixin.setText(personalBean.getData().getWeixin());
			zhifu.setText(personalBean.getData().getZfb());
			bank.setText(personalBean.getData().getYhmc());
			bank_account.setText(personalBean.getData().getYhzh());
			tv_supper_user.setText(personalBean.getData().getUe_accname());
			tv_qq.setText(personalBean.getData().getUe_qq());
			tv_bank_user.setText(personalBean.getData().getZhxm());
		}

	}
}
