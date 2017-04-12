package zz.guojin.hongmi.activity;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;

import butterknife.Bind;
import butterknife.OnClick;
import zz.guojin.hongmi.bean.QiangIdBean;
import zz.guojin.hongmi.utils.AppManager;
import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.R;

import android.content.Context;
import android.content.Intent;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class QiangOrderActivity extends BaseActivity {
	@Bind(R.id.img_back)
	ImageView img_back;
	@Bind(R.id.title_main)
	TextView title;
	@Bind(R.id.tong_layout)
	RelativeLayout tong_layout;
	@Bind(R.id.yin_layout)
	RelativeLayout yin_layout;
	@Bind(R.id.jin_layout)
	RelativeLayout jin_layout;
	@Bind(R.id.zuan_layout)
	RelativeLayout zuan_layout;
	@Bind(R.id.money_tong)
	TextView money_tong;
	@Bind(R.id.money_yin)
	TextView money_yin;
	@Bind(R.id.money_jin)
	TextView money_jin;
	@Bind(R.id.money_zuan)
	TextView money_zuan;
	private Context ctx;
	private Request<String> request;

	@Override
	public int getLayoutResId() {
		// TODO Auto-generated method stub
		return R.layout.activity_qiang_order;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		AppManager.getInstance().addActivity(this);
		ctx = this;
	}

	@Override
	public void initView() {
		 title.setText("抢单中心");
	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		ToRequestUrl(request, TAG, MUrlUtil.BASE_URL+MUrlUtil.QIANG_ID, null, -1, -1, 222);
	}

	@Override
	public void toStartProgressDialog() {
		// TODO Auto-generated method stub
		toStartProgressDialg(true);
	}
	


	@OnClick({R.id.tong_layout,R.id.yin_layout,R.id.jin_layout,R.id.zuan_layout,R.id.img_back})
	public void onClick(View view){
		int id ;
		Intent intent = new Intent(this,QiangActivity.class);
		switch (view.getId()) {
		
		case R.id.tong_layout:
			id = 1;
			intent.putExtra("id", id);
			startActivity(intent);
			break;
		case R.id.yin_layout:
			id=2;
			intent.putExtra("id", id);
			startActivity(intent);
			break;
		case R.id.jin_layout:
			id =3;
			intent.putExtra("id", id);
			startActivity(intent);
			break;
		case R.id.zuan_layout:
			id = 4;
			intent.putExtra("id", id);
			startActivity(intent);
			break;
		case R.id.img_back:
			finish();
			break;

		default:
			break;
		}
	}

	@Override
	public void doWhatForRequest(int what, String info) {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		Logger.d(info);
		if(what==222){
			QiangIdBean qiangIdBean = gson.fromJson(info, QiangIdBean.class);
			
			money_tong.setText(qiangIdBean.getDataBean().getQt_lower_money()
					+"-"+qiangIdBean.getDataBean().getQt_upper_money());
			money_yin.setText(qiangIdBean.getDataBean().getBy_lower_money()
					+"-"+qiangIdBean.getDataBean().getBy_upper_money());
			money_jin.setText(qiangIdBean.getDataBean().getHj_lower_money()
					+"-"+qiangIdBean.getDataBean().getHj_upper_money());
			money_zuan.setText(qiangIdBean.getDataBean().getZs_lower_money()
					+"-"+qiangIdBean.getDataBean().getZs_upper_money());
		}
	}
	
	

}
