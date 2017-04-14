package zz.guojin.hongmi.activity;


import zz.guojin.hongmi.R;
import zz.guojin.hongmi.bean.ReQuestBean;
import zz.guojin.hongmi.utils.AppManager;
import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.utils.ToastUtils;

import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.RequestQueue;
import com.yolanda.nohttp.rest.Response;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GoodsInfoActivity extends Activity {

	private String TAG = "GoodsInfoActivity";
	@Bind(R.id.tv_go_back)
	TextView tvGoback;
	@Bind(R.id.img_goods)
	ImageView imgGoods;
	@Bind(R.id.info_goods)
	TextView infoGoods;
	@Bind(R.id.tv_sub)
	TextView tvSub;
	@Bind(R.id.et_number)
	TextView etNumber;
	@Bind(R.id.tv_counts)
	TextView tvCount;
	@Bind(R.id.tv_price)
	TextView tvPrice;
	@Bind(R.id.name)
	EditText name;
	@Bind(R.id.phone)
	EditText phone;

	@Bind(R.id.btn_pay)
	Button btnPay;

	@Bind(R.id.address)
	EditText et_address;
	Bitmap bitmap;
	public static String price;
	public static int shuliang; // 产品数量
	public static String count;// etNumber
	public static String id;
	RequestQueue requestQueue1;
	Handler mHandler = new Handler() {
		public void handleMessage(android.os.Message msg) {
			if (msg.what == 0) {
				etNumber.setText((int) msg.arg1 + "");

			}
		};
	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_goods_info);
		AppManager.getInstance().addActivity(this);
		ButterKnife.bind(this);
		initData();
	}

	private void initData() {
		String img = (String) getIntent().getCharSequenceExtra("img");
		String content = (String) getIntent().getCharSequenceExtra("content");
		id = (String) getIntent().getCharSequenceExtra("id");
		price = (String) getIntent().getCharSequenceExtra("price");
		tvPrice.setText("￥" + price);
		infoGoods.setText(Html.fromHtml(content));
		ImageLoader.getInstance().displayImage(img, imgGoods);
	}


	@OnClick({ R.id.tv_go_back, R.id.tv_sub, R.id.tv_counts, R.id.btn_pay })
	public void onClick(View view) {
		Message message = mHandler.obtainMessage();
		message.what = 0;

		switch (view.getId()) {
		case R.id.tv_go_back:
			AppManager.getInstance().killActivity(this);
			break;
		case R.id.tv_sub:// 减

			count = etNumber.getText().toString();
			shuliang = Integer.valueOf(count);
			if (shuliang > 1) {
				shuliang -= 1;
			} else {
				shuliang = 1;

			}

			message.arg1 = shuliang;

			mHandler.sendMessage(message);

			break;
		case R.id.tv_counts:// 加
			count = etNumber.getText().toString();
			shuliang = Integer.valueOf(count);
			shuliang += 1;

			message.arg1 = shuliang;
			mHandler.sendMessage(message);
			break;
		case R.id.btn_pay:
//			String phone_user = phone.getText().toString().trim();
//			String name_user = name.getText().toString().trim();

			getPay(id, etNumber.getText().toString(), et_address.getText()
					.toString());

			break;
		}

	}

	private void getPay(String id, String nums, String address) {

		Request<String> request = NoHttp.createStringRequest(MUrlUtil.BASE_URL
				+ MUrlUtil.PAY, RequestMethod.GET);
		request.add("id", id);
		request.add("nums", nums);
		request.add("address", address);
//		request.add("name",name);
//		request.add("phone",phone);
		request.setCancelSign(TAG);
		requestQueue1.add(22, request, responseListener2);

	}

	OnResponseListener<String> responseListener2 = new OnResponseListener<String>() {

		@Override
		public void onSucceed(int what, Response<String> response) {
			// TODO Auto-generated method stub
			if (what == 22) {
				String info = response.get();

				System.out.println("------------" + info + "----------");
				Gson gson = new Gson();
				ReQuestBean reQuestBean = gson
						.fromJson(info, ReQuestBean.class);

				Toast.makeText(GoodsInfoActivity.this, reQuestBean.getMsg(), 0)
						.show();

			}

		}

		@Override
		public void onStart(int what) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onFinish(int what) {
			// TODO Auto-generated method stub
			System.out.println("我买过东西了");

		}

		@Override
		public void onFailed(int what, Response<String> response) {
			// TODO Auto-generated method stub
			ToastUtils.showTextToast(GoodsInfoActivity.this, "购买失败。。");

		}
	};

	protected void onDestroy() {
		super.onDestroy();
		if (requestQueue1 != null) {
			requestQueue1.cancelBySign(TAG);
			requestQueue1=null;
		}
	};

}
