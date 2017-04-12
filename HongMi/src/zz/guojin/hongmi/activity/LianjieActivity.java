package zz.guojin.hongmi.activity;

import org.json.JSONException;
import org.json.JSONObject;

import zz.guojin.hongmi.R;
import zz.guojin.hongmi.utils.AppManager;
import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.utils.ToastUtils;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.RequestQueue;
import com.yolanda.nohttp.rest.Response;


import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 推荐链接
 * 
 * @author Administrator
 * 
 */
public class LianjieActivity extends BaseActivity implements OnClickListener{
private ImageView goback,lianjie;
private TextView title,tv_lianjie;
private Context context;
private Request<String> request;
	@Override
	public int getLayoutResId() {
		// TODO Auto-generated method stub
		return R.layout.activity_lianjie;
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
		lianjie = (ImageView) findViewById(R.id.iv_lianjie);
		tv_lianjie =(TextView) findViewById(R.id.tv_lianjie);
	
		title = (TextView)findViewById(R.id.title_main);
		title.setText("二维码");
	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub
		goback.setOnClickListener(this);
		
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		ToRequestUrl(request, TAG, MUrlUtil.BASE_URL+MUrlUtil.LIANJIE, null,-1,-1,900);
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
				JSONObject jb = new JSONObject(info);
				String error = jb.getString("error");{
					if("1".equals(error)){
						JSONObject data = jb.getJSONObject("data");
						String url = data.getString("url");
						tv_lianjie.setText(url);
						String qrcode=data.getString("qrcode");
						ImageLoader.getInstance().displayImage(qrcode, lianjie);
						}else{
							String msg = jb.getString("msg");
							ToastUtils.showTextToast(context, msg);
						}
				}
				
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				Logger.e(TAG+e.getMessage());
			}

	}
//	ImageView iv_go,img_lianjie;
//	TextView tv_lianjie;
//	private Request<String> request;
//	private Request<Bitmap> request2;
//	private RequestQueue queue;
//	private String TAG ="LianjieActivity";
//	private String ewm ;
//	private ProgressDialog pDialog;
//
//	@Override
//	protected void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		requestWindowFeature(Window.FEATURE_NO_TITLE);
//		setContentView(R.layout.activity_lianjie);
//		initView();
//		queue = NoHttp.newRequestQueue();
//		pDialog = ProgressDialog.show(this, null,"Loading...");
//		initData();
//	}
//
//	private void initData() {
//		// TODO Auto-generated method stub
//		request = NoHttp.createStringRequest(MUrlUtil.BASE_URL+MUrlUtil.LIANJIE,
//				RequestMethod.POST);
//		request.cancelBySign(TAG);
//		queue.add(180, request, responseListener);
//	
//		
//	}
//	OnResponseListener<Bitmap> responseListener2 = new OnResponseListener<Bitmap>() {
//
//		@Override
//		public void onStart(int what) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void onSucceed(int what, Response<Bitmap> response) {
//			// TODO Auto-generated method stub
//			img_lianjie.setImageBitmap(response.get());
//			
//		}
//
//		@Override
//		public void onFailed(int what, Response<Bitmap> response) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void onFinish(int what) {
//			// TODO Auto-generated method stub
//			if(pDialog!=null && pDialog.isShowing()){
//				pDialog.dismiss();
//			}
//		}
//
//		};
//	OnResponseListener<String> responseListener = new OnResponseListener<String>() {
//
//		@Override
//		public void onStart(int what) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void onSucceed(int what, Response<String> response) {
//			// TODO Auto-generated method stub
//			
//			
//		}
//
//		@Override
//		public void onFailed(int what, Response<String> response) {
//			// TODO Auto-generated method stub
//			System.out.println(response.get()+"+==========");
//			
//		}
//
//		@Override
//		public void onFinish(int what) {
//			// TODO Auto-generated method stub
//			
//		}};
//	
//
//	private void initView() {
//		// TODO Auto-generated method stub
//		iv_go =  (ImageView) findViewById(R.id.img_back);
//		img_lianjie = (ImageView)findViewById(R.id.iv_lianjie);
//		tv_lianjie = (TextView)findViewById(R.id.tv_lianjie);
//		iv_go.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				finish();
//				
//			}
//		});
//		
//		
//	}
//	
//	@Override
//	protected void onDestroy() {
//		// TODO Auto-generated method stub
//		super.onDestroy();
//		if(queue!=null){
//			queue.cancelBySign(TAG);
//		}
//		if(pDialog!=null&& pDialog.isShowing()){
//			pDialog.cancel();
//			pDialog=null;
//		}
//	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		finish();
	}

}
