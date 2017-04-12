package zz.guojin.hongmi.activity;

import com.google.gson.Gson;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.RequestQueue;
import com.yolanda.nohttp.rest.Response;
import com.yolanda.nohttp.rest.SimpleResponseListener;

import zz.guojin.hongmi.bean.SheDetailsBean;
import zz.guojin.hongmi.bean.SheDetailsBean.Data;
import zz.guojin.hongmi.utils.AppManager;
import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.R;


import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class DeDetailsActivity extends Activity {
	@Bind(R.id.de_id)TextView sid;
	@Bind(R.id.de_jb)TextView sjb;
	@Bind(R.id.de_phone)TextView sphone;
	@Bind(R.id.de_ue_accname)TextView sue_accname;
	@Bind(R.id.de_ue_account)TextView sue_account;
	@Bind(R.id.de_ue_truename)TextView sue_truename;
	@Bind(R.id.de_data)TextView sdata;
	@Bind(R.id.de_weixin)TextView sweixin;
	@Bind(R.id.de_yhmc)TextView syhmc;
	@Bind(R.id.de_zfb)TextView szfb;
	@Bind(R.id.de_yhzh)TextView syhzh;
//	@Bind(R.id.de_ue_phone)TextView sue_phone;
	@Bind(R.id.iv_goback)ImageView iv_goback;
	@Bind(R.id.bu_load)
	Button pic_load;
	@Bind(R.id.shoukuan_layout) LinearLayout dakuan_layout;

	private RequestQueue queue;
	private String load = "Uploads";
	private String IMG_URL =MUrlUtil.BASE_URL;
	String img_info;
	ImageView img;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		AppManager.getInstance().addActivity(this);
		setContentView(R.layout.activity_de_details);
		ButterKnife.bind(this);
		Intent intent = getIntent();
		extra = intent.getStringExtra("did");
		queue = NoHttp.newRequestQueue();
		initData();
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		ButterKnife.unbind(this);
	}
	private void initData() {
		// TODO Auto-generated method stub
		Request<String> request = NoHttp.createStringRequest(MUrlUtil.BASE_URL+MUrlUtil.DE_DET, RequestMethod.GET);
		request.add("id", extra );	

		queue.add(501, request, responseListener);	
	}

	OnResponseListener<String> responseListener =new OnResponseListener<String>() {
		
		@Override
		public void onSucceed(int what, Response<String> response) {
			// TODO Auto-generated method stub
			
			if (what==501) {
				String infos = response.get();
				System.out.println(infos+"----------");
				Gson gson = new Gson();
				SheDetailsBean bean = gson.fromJson(infos, SheDetailsBean.class);
				Data data = bean.getData();
				sid.setText(data.getId());
				sjb.setText(data.getJb());
				sphone.setText(data.getPhone());
				sue_accname.setText(data.getUe_accname());
				sue_account.setText(data.getUe_account());
				sdata.setText(data.getDate());
				sweixin.setText(data.getWeixin());
				syhmc.setText(data.getYhmc());
				szfb.setText(data.getZfb());
				syhzh.setText(data.getYhzh());
//				sue_phone.setText(data.getUe_phone());
				sue_truename.setText(data.getUe_truename());
//				System.out.println("aa"+data.getPicc().substring(0, 7));
				if(data.getPic()!=null  && data.getPic().length()>1 && data.getPic().substring(0, 7).equals(load)){
					IMG_URL = IMG_URL;
				}else{
					IMG_URL = IMG_URL+load;
				}
				img_info =IMG_URL+data.getPic();
				System.out.println(img_info+"----------");
				System.out.println("--"+img_info+"---"+sid.getText());
				if((data.getPic()!=null  && !data.getPic().equals("0") ) &&  !img_info.equals(IMG_URL)){
					dakuan_layout.setVisibility(View.VISIBLE);
					pic_load.setVisibility(View.VISIBLE);
				}else{
					dakuan_layout.setVisibility(View.INVISIBLE);
					pic_load.setVisibility(View.INVISIBLE);
				}
				
			}
			
		}
		
		@Override
		public void onStart(int what) {
			// TODO Auto-generated method stub
			System.out.println("111111111.........");
			
		}
		
		@Override
		public void onFinish(int what) {
			// TODO Auto-generated method stub
			
		}
		
		
		@Override
		public void onFailed(int what, Response<String> response) {
			// TODO Auto-generated method stub
			
		}
	};
	
	private String extra;
	
	@OnClick(R.id.iv_goback)
	public void goBack(ImageView iv){
		finish();
		
	}
	@OnClick(R.id.bu_load)
	public void onClick(View v) {
		if(!zz.guojin.hongmi.utils.NetUtils.checkNet(getApplicationContext())){
			zz.guojin.hongmi.utils.ToastUtils.showTextToast(getApplicationContext(), "网络未连接");
		}else{
		      System.out.println("------------下载图片");
			noHttpLoadImag(img_info);
		}
		
	}
	
	/**
	 * 点击图片放大查看
	 * 
	 */
	private void getBigPicture(final Bitmap b) {
		LayoutInflater inflater = LayoutInflater.from(this);
		View imgEntryView = inflater.inflate(R.layout.dialog_photo_entry, null); // 加载自定义的布局文件
		final AlertDialog dialog = new AlertDialog.Builder(this).create();
		img = (ImageView) imgEntryView.findViewById(R.id.large_image);
		if (b != null) {
			Display display = DeDetailsActivity.this.getWindowManager()
					.getDefaultDisplay();
			int scaleWidth = display.getWidth();
			int height = b.getHeight();// 图片的真实高度
			int width = b.getWidth();// 图片的真实宽度
			LayoutParams lp = (LayoutParams) img.getLayoutParams();
			lp.width = scaleWidth;// 调整宽度
			lp.height = (height * scaleWidth) / width;// 调整高度
			img.setLayoutParams(lp);
			img.setImageBitmap(b);
			dialog.setView(imgEntryView); // 自定义dialog
			dialog.show();
		}
		// 点击布局文件（也可以理解为点击大图）后关闭dialog，这里的dialog不需要按钮
		imgEntryView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View paramView) {
				if (dialog.isShowing()) {
					img.setImageBitmap(null);
					b.recycle();
					dialog.cancel();
					
					
					
				}
			}
		});
	}
	/*
	 * 下载图片
	 */

	public void noHttpLoadImag(String url) {
		
		queue = NoHttp.newRequestQueue();
		    
		final Request<Bitmap> imageRequest = NoHttp.createImageRequest(url);
		
	queue.add(22, imageRequest, new OnResponseListener<Bitmap>() {

		@Override
		public void onStart(int what) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onSucceed(int what, Response<Bitmap> response) {
			// TODO Auto-generated method stub
			getBigPicture(response.get());
		}


		@Override
		public void onFinish(int what) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onFailed(int what, Response<Bitmap> response) {
			// TODO Auto-generated method stub
			
		}
	});

}
}
