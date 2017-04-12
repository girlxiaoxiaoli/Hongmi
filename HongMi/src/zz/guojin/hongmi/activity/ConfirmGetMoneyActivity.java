package zz.guojin.hongmi.activity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import com.yolanda.nohttp.FileBinary;
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
import zz.guojin.hongmi.uppictures.RequestUrl;
import zz.guojin.hongmi.uppictures.UploadFileUtil;
import zz.guojin.hongmi.utils.AppManager;
import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.utils.NetUtils;
import zz.guojin.hongmi.utils.ToastUtils;
import zz.guojin.hongmi.R;
import android.R.integer;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class ConfirmGetMoneyActivity extends Activity implements OnClickListener {
	private ImageView imageView1;
	String picturePath = null;
	File outFile = null;
	final Map<String, String> params_image = new HashMap<String, String>();
	@Bind(R.id.sex)
	RadioGroup sex;
	@Bind(R.id.rb_male)
	RadioButton male;
	@Bind(R.id.rb_male1)
	RadioButton male1;
	@Bind(R.id.img_back) ImageView goback;
	@Bind(R.id.title_main) TextView title;
	Button refer;
	int temp;
	ProgressDialog pd;
	private RequestQueue queue;
	private String extra;
	private Context ctx;
    
   @OnClick(R.id.img_back)
   public void img_back(View view){
	   finish();
   }
	// 得记录 匹配 确认收款
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		AppManager.getInstance().addActivity(this);
		setContentView(R.layout.activity_deconfirm);
		ButterKnife.bind(this);
		ctx = this;
		
		imageView1 = (ImageView) findViewById(R.id.imageView1);
		refer = (Button) findViewById(R.id.refer);
		refer.setOnClickListener(this);
		queue = NoHttp.newRequestQueue();
		title.setText("确认收款");
		sex.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub

				if (male.getId() == checkedId) {
					temp = 1;
				} else if (male1.getId() == checkedId) {
					temp = 2;
				}
				{

				}

			}

		});

		Intent intent = getIntent();
		extra = intent.getStringExtra("did");

	}

	/**
	 * 拍照按钮，点击事件
	 * 
	 */
	public void btn_onclick_camera(View v) {
		setView();
	}

	/**
	 * 拍照或从相册拿照片
	 */
	public void setView() {
		final AlertDialog.Builder builder = new AlertDialog.Builder(ConfirmGetMoneyActivity.this);
		String[] strs = { "拍照上传", "相册选取", "取消" };
		builder.setItems(strs, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				switch (which) {
				case 0:
					Intent camera = new Intent("android.media.action.IMAGE_CAPTURE");
					startActivityForResult(camera, 1);
					break;
				case 1:
					Intent picture = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
					startActivityForResult(picture, 2);
					break;
				case 2:
					Toast.makeText(ConfirmGetMoneyActivity.this, "关闭对话框", 10).show();
					break;
				}
			}
		});
		builder.setCancelable(false);
		builder.create().show();

	}

	/**
	 * 1取出拍照的结果存储到手机内存则pictures文件夹， 再从文件加下取出展示到界面，并且点击放大
	 * 2从相册中取出图片，压缩，放到dialog中，然后去出展示到界面 点击放大。
	 */

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		Bitmap bitmap = null;
		File outDir = null;
		String state = Environment.getExternalStorageState();
		if (state.equals(Environment.MEDIA_MOUNTED)) {
			// 这个路径，在手机内存下创建一个pictures的文件夹，把图片存在其中。
			outDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
		} else {
			if (ConfirmGetMoneyActivity.this != null) {
				outDir = this.getFilesDir();
			}
		}
		if (!outDir.exists()) {
			outDir.mkdirs();
		}

		if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
			if (data != null) {
				// 直接获取照片，data是系统默认的（在系统中已经压缩过图片取出来就行了）；
				bitmap = (Bitmap) data.getExtras().get("data");
				if (bitmap != null) {
					showImageDialog(bitmap, "1", "");
				} else {

					Toast.makeText(ConfirmGetMoneyActivity.this, "图片获取失败，请重新选择", 10).show();
				}
				// 保存图片
				try {
					outFile = new File(outDir, System.currentTimeMillis() + ".jpg");
					FileOutputStream fos = new FileOutputStream(outFile);

					boolean flag = bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);// 把数据写入文件
					Log.i("1", "flag=" + flag);
					if (flag) {
						Toast.makeText(ConfirmGetMoneyActivity.this, "图片已保存至:" + outFile.getAbsolutePath(), 10).show();

						// 展示图片，点击放大
						String pathname = outFile.getAbsolutePath();// 绝对路径
						final Bitmap myBitmap = BitmapFactory.decodeFile(pathname);
						imageView1.setImageBitmap(bitmap);
						imageView1.setOnClickListener(new OnClickListener() {
							@Override
							public void onClick(View v) {
								getBigPicture(myBitmap);// 点击放大

							}
						});

					} else {

						Toast.makeText(ConfirmGetMoneyActivity.this, "图片保存失败!", 10).show();

					}
				} catch (FileNotFoundException e) {
					throw new RuntimeException(e);
				}
			}
		}// 相册显示界面
		else if (requestCode == 2 && data != null && resultCode == Activity.RESULT_OK) {
			try {
				Uri selectedImage = data.getData();
				String[] filePathColumns = { MediaStore.Images.Media.DATA };
				Cursor c = ConfirmGetMoneyActivity.this.getContentResolver().query(selectedImage, filePathColumns, null, null, null);
				c.moveToFirst();
				int columnIndex = c.getColumnIndex(filePathColumns[0]);
				picturePath = c.getString(columnIndex);// 取出图片路径
				Log.e("1", "图片路径" + picturePath);
				c.close();

				// 调用压缩方法压缩图片
				bitmap = createThumbnail(picturePath, 1);
				// 保存图片到pictures文件夹下,上传的时候还要上传outFile
				outFile = new File(outDir, System.currentTimeMillis() + ".jpg");
				FileOutputStream fos = new FileOutputStream(outFile);
				boolean flag = bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);// 把数据写入文件

				if (bitmap != null) {
					// 选择图片后显示在对话框内
					showImageDialog(bitmap, "1", "");
				}
				// 展示图片并点击放大
				String pathname = outFile.getAbsolutePath();// 绝对路径
				final Bitmap myBitmap = BitmapFactory.decodeFile(pathname);
				imageView1.setImageBitmap(myBitmap);
				imageView1.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						getBigPicture(myBitmap);

					}
				});

			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		}
	}

	/**
	 * 
	 * 展示图片的dialog
	 */
	private void showImageDialog(Bitmap b, final String orderNo, final String chepaihao) {
		AlertDialog.Builder builder = new AlertDialog.Builder(ConfirmGetMoneyActivity.this);

		builder.setTitle("请上传包含交易信息的照片");
		View imgEntryView = View.inflate(ConfirmGetMoneyActivity.this, R.layout.dialog_photo_entry, null); // 加载自定义的布局文件
		ImageView img = (ImageView) imgEntryView.findViewById(R.id.large_image);
		if (b != null) {
			Display display = ConfirmGetMoneyActivity.this.getWindowManager().getDefaultDisplay();
			int scaleWidth = display.getWidth();
			int scaleHeight = display.getHeight();
			int height = b.getHeight();// 图片的真实高度
			int width = b.getWidth();// 图片的真实宽度
			LayoutParams lp = (LayoutParams) img.getLayoutParams();
//			lp.width = scaleWidth;// 调整宽度
//			lp.height = (height * scaleWidth) / width;// 调整高度
			lp.width = scaleWidth/10*8;// 调整宽度
			lp.height = scaleHeight/10*8;// 调整高度
			img.setLayoutParams(lp);
			img.setImageBitmap(b);
		} else {

			Toast.makeText(ConfirmGetMoneyActivity.this, "获取照片失败", 10).show();
			img.setVisibility(View.GONE);
		}
		builder.setView(imgEntryView); // 自定义dialog
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				if (ConfirmGetMoneyActivity.this != null) {
					// 判断网络
					if (isNetworkConnected(ConfirmGetMoneyActivity.this)) {
						try {
							/**
							 * 上传照片，没有正确的参数不能正确上传
							 * 
							 */
							String str_uploadImage = UploadFileUtil.uploadImage(ConfirmGetMoneyActivity.this, RequestUrl.upload, params_image, outFile);

						} catch (Exception e) {
							e.printStackTrace();
						}

					} else {
						Toast.makeText(ConfirmGetMoneyActivity.this, "网络异常，请检查网络!", 10).show();
					}
				}
			}
		});
		builder.setNegativeButton("取消", null);
		builder.create().show();
	}

	/**
	 * 压缩图片
	 * 
	 * 
	 */
	private Bitmap createThumbnail(String filepath, int i) {
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inSampleSize = i;
		return BitmapFactory.decodeFile(filepath, options);
	}

	/**
	 * 判断网络是否正常
	 * 
	 * 
	 */
	public boolean isNetworkConnected(Context context) {
		if (context == null) {
			return false;
		}
		ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
		NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
		if (networkInfo == null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 点击图片放大查看
	 * 
	 */
	private void getBigPicture(Bitmap b) {
		LayoutInflater inflater = LayoutInflater.from(this);
		View imgEntryView = inflater.inflate(R.layout.dialog_photo_entry, null); // 加载自定义的布局文件
		final AlertDialog dialog = new AlertDialog.Builder(this).create();
		ImageView img = (ImageView) imgEntryView.findViewById(R.id.large_image);
		if (b != null) {
			Display display = ConfirmGetMoneyActivity.this.getWindowManager().getDefaultDisplay();
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
					dialog.cancel();
				}
			}
		});
	}

	@Override
	public void onClick(View v) {
		if (!NetUtils.checkNet(ctx)) {
			ToastUtils.showTextToast(ctx, "网络连接不可用");
			return;
		}
		if ("0".equals(temp)) {
			ToastUtils.showTextToast(getApplicationContext(), "请勾选确认");
			return;
		}
//		if (outFile == null) {
//			ToastUtils.showTextToast(getApplicationContext(), "请上传图片");
//			return;
//		}

		Request<String> request = NoHttp.createStringRequest(MUrlUtil.BASE_URL + MUrlUtil.DE_TO, RequestMethod.POST);
		if (outFile==null) {
			request.add("comfir2", temp);
			request.add("id", extra);
			
		}else{
			binary = new FileBinary(outFile);
			request.add("comfir2", temp);
			request.add("id", extra);
			System.out.println(binary);
			request.add("image",binary);
		}
		
		queue.add(390, request, responseListener);
	}

	OnResponseListener<String> responseListener = new OnResponseListener<String>() {

		@Override
		public void onStart(int what) {
			// TODO Auto-generated method stub
           if(outFile!=null){
        	   pd = ProgressDialog.show(ConfirmGetMoneyActivity.this, "上传图片中", "Please wait...");
           }else{
        	   pd = ProgressDialog.show(ConfirmGetMoneyActivity.this, "正在提交中", "Please wait...");
           }
		}

		@Override
		public void onSucceed(int what, Response<String> response) {
			// TODO Auto-generated method stub
			if (what == 390) {
				String info = response.get();
				pd.dismiss();
				Gson gson = new Gson();
				System.out.println("上传图片info===" + info);
				RuquestBean json = gson.fromJson(info, RuquestBean.class);
				String string = json.toString();
				if ("1".equals(json.getError())) {
					ToastUtils.showTextToast(ctx, json.getMsg());
					Intent intent = new Intent();
					
					setResult(2);
					AppManager.getInstance().killActivity(ConfirmGetMoneyActivity.class);

				} else {
					ToastUtils.showTextToast(ctx, json.getMsg());

				}
			}

		}

	

		@Override
		public void onFinish(int what) {
			// TODO Auto-generated method stub
       
		}

		

		
		@Override
		public void onFailed(int what, Response<String> response) {
			// TODO Auto-generated method stub
			pd.dismiss();
			ToastUtils.showTextToast(ctx, "提交失败");

		}

	};
	private FileBinary binary;

}
