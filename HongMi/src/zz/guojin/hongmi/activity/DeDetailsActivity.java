package zz.guojin.hongmi.activity;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
import com.google.gson.Gson;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.Request;
import zz.guojin.hongmi.bean.SheDetailsBean;
import zz.guojin.hongmi.bean.SheDetailsBean.Data;
import zz.guojin.hongmi.utils.AppManager;
import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.utils.ToastUtils;
import zz.guojin.hongmi.R;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DeDetailsActivity extends BaseActivity implements OnClickListener{
	//(R.id.de_id)
	TextView sid;
	//(R.id.de_jb)
	TextView sjb;
	
	//(R.id.de_phone)
	TextView sphone;
	//(R.id.de_ue_accname)
	TextView sue_accname;
	//(R.id.de_ue_account)
	TextView sue_account;
	//(R.id.de_ue_truename)
	TextView sue_truename;
	//(R.id.de_data)
	TextView sdata;
	//(R.id.de_weixin)
	TextView sweixin;
	//(R.id.de_yhmc)
	TextView syhmc;
	//(R.id.title_main)
	TextView title;
	//(R.id.de_zfb)
	TextView szfb;
	//(R.id.de_yhzh)
	TextView syhzh;
	// //(R.id.de_ue_phone)TextView sue_phone;
	//(R.id.img_back)
	ImageView img_back;
	//(R.id.bu_load)
	Button pic_load;
	//(R.id.shoukuan_layout)
	LinearLayout dakuan_layout;
	private String TAG = getClassName();
	private String load = "Uploads";
	private String IMG_URL = MUrlUtil.BASE_URL;
	private Request<String> request;
	String img_info;
	ImageView img;
	private String extra;

	@Override
	public void onClick(View v) {
		int id = v.getId();
		switch (id) {
		case R.id.bu_load:
			if (!zz.guojin.hongmi.utils.NetUtils
					.checkNet(getApplicationContext())) {
				zz.guojin.hongmi.utils.ToastUtils.showTextToast(
						getApplicationContext(), "网络未连接");
			} else {
				// ToastUtils.showTextToast(this, img_info);
				getBigPicture(img_info);
			}
			break;
		case R.id.img_back:
			AppManager.getInstance().killActivity(this);
			break;

		default:
			break;
		}

	}

	/**
	 * 点击图片放大查看
	 * 
	 */
	private void getBigPicture(final String url) {
		LayoutInflater inflater = LayoutInflater.from(this);
		View imgEntryView = inflater.inflate(R.layout.dialog_photo_entry, null); // 加载自定义的布局文件
		final AlertDialog dialog = new AlertDialog.Builder(this).create();
		img = (ImageView) imgEntryView.findViewById(R.id.large_image);

		ImageLoader.getInstance().displayImage(url, img);
		dialog.setView(imgEntryView); // 自定义dialog
		dialog.show();
		// 点击布局文件（也可以理解为点击大图）后关闭dialog，这里的dialog不需要按钮
		imgEntryView.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View paramView) {
				if (dialog.isShowing()) {
					img.setImageBitmap(null);
					// b.recycle();
					dialog.cancel();
				}
			}
		});
	}

	@Override
	public int getLayoutResId() {
		// TODO Auto-generated method stub
		return R.layout.activity_de_details;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		AppManager.getInstance().addActivity(this);
		Intent intent = getIntent();
		extra = intent.getStringExtra("did");
	}

	@Override
	public void initView() {
		// TODO Auto-generated method stub
		
		sid =(TextView)findViewById(R.id.de_id);
		sjb =(TextView)findViewById(R.id.de_jb);
		sphone =(TextView)findViewById(R.id.de_phone);
		sue_accname =(TextView)findViewById(R.id.de_ue_accname);
		sue_account =(TextView)findViewById(R.id.de_ue_account);
		sue_truename =(TextView)findViewById(R.id.de_ue_truename);
		sdata =(TextView)findViewById(R.id.de_data);
		sweixin =(TextView)findViewById(R.id.de_weixin);
		syhmc =(TextView)findViewById(R.id.de_yhmc);
		title =(TextView)findViewById(R.id.title_main);
		szfb =(TextView)findViewById(R.id.de_zfb);
		syhzh =(TextView)findViewById(R.id.de_yhzh);
		img_back =(ImageView)findViewById(R.id.img_back);
		pic_load =(Button)findViewById(R.id.bu_load);
		dakuan_layout =(LinearLayout)findViewById(R.id.shoukuan_layout);
		title.setText("打款方信息");
	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub
       pic_load.setOnClickListener(this);
       img_back.setOnClickListener(this);
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", extra);
		ToRequestUrl(request, TAG, MUrlUtil.BASE_URL + MUrlUtil.DE_DET, params,
				-1, -1, 222);
		Request<String> request = NoHttp.createStringRequest(MUrlUtil.BASE_URL
				+ MUrlUtil.DE_DET, RequestMethod.GET);

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
			if ("1".equals(error)) {
				SheDetailsBean bean = new Gson().fromJson(info,
						SheDetailsBean.class);
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
				// sue_phone.setText(data.getUe_phone());
				sue_truename.setText(data.getUe_truename());
				// System.out.println("aa"+data.getPicc().substring(0, 7));
				if (data.getPic() != null && data.getPic().length() > 1
						&& data.getPic().substring(0, 7).equals(load)) {
					IMG_URL = IMG_URL;
				} else {
					IMG_URL = IMG_URL + load;
				}
				img_info = IMG_URL + data.getPic();

				if ((data.getPic() != null && !data.getPic().equals("0"))
						&& !img_info.equals(IMG_URL)) {
					dakuan_layout.setVisibility(View.VISIBLE);
					pic_load.setVisibility(View.VISIBLE);
				} else {
					dakuan_layout.setVisibility(View.INVISIBLE);
					pic_load.setVisibility(View.INVISIBLE);
				}

			} else {
				String msg = jsonObject.getString("msg");
				ToastUtils.showTextToast(context, msg);
			}
		} catch (Exception e) {
			// TODO: handle exception
			Logger.e(TAG + e.getMessage());
		}

	}



}
