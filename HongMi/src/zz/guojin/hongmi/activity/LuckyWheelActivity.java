package zz.guojin.hongmi.activity;

import org.json.JSONObject;

import zz.guojin.hongmi.R;
import zz.guojin.hongmi.utils.AppManager;
import zz.guojin.hongmi.utils.JumpUtil;
import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.utils.ToastUtils;
import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.rest.Request;
import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * Created by Administrator on 2016/10/17. 大转盘界面
 */

public class LuckyWheelActivity extends BaseActivity implements OnClickListener{
	//(R.id.lucky_wheel)
	LinearLayout layout;
	//(R.id.img_back)
	ImageView ivGoback;
	//(R.id.title_main)
	TextView title;
	//(R.id.title_second)
	TextView title_second;
	//(R.id.pan_wheel)
	ImageView panWheel;
	//(R.id.btn_click)
	ImageView btnClick;
	//(R.id.first_award)
	TextView firstAward;
	//(R.id.second_award)
	TextView secondAward;
	//(R.id.third_award)
	TextView thirdAward;
	//(R.id.fourth_award)
	TextView fourthAward;
	//(R.id.fifth_award)
	TextView fifthAward;
	//(R.id.sixth_award)
	TextView sixthAward;
	//(R.id.seven_award)
	TextView sevenAward;
	Request<String> request;
	
	private Integer amsg;
	private float[] angles = { 0, -52,-103,-154,-206,-257,-309 };// 7个选项的角度
//	private float[] angles = { 0,-309,-257,-206,-154,-103,-52};// 7个选项的角度
	private String[] awardStr = { "一等奖", "二等奖", "三等奖", "四等奖", "五等奖", "六等奖"
			,"七等奖" };
	private float inStartPosition; // 开始转动的角度位置
	private String turn; // 每次消费的金币
	private Context context;
	private boolean IsStartTurn=false;

	Thread thread;
	AlertDialog dialog;

	private void getNetData() {
		// TODO Auto-generated method stub
		ToRequestUrl(request, TAG, MUrlUtil.BASE_URL + MUrlUtil.AWARDS,
				null, -1, -1, 88);

	}

	
	@Override
	public void onClick(View view) {
		int id =view.getId();
		switch (id) {
		case R.id.img_back:
			AppManager.getInstance().killActivity(this);

			break;
		case R.id.title_second:
			JumpUtil.JumpActivity(context, AwardRecord.class);
			break;
		case R.id.btn_click:
			IsStartTurn = true;
			getNetData();// 网络访问

			break;

		default:
			break;
		}

	}

	// 做减速运动，指向根据一个float型数，指向一个位置
	private void toDeceleration(float angle) {
		inStartPosition = 1440 + angle;// 本次旋转的角度
//		System.out.println("go------"+"angle="+angle+"---inStartPosition="+inStartPosition);
		// 设置旋转参数
		RotateAnimation rotateAnimation = new RotateAnimation(0,
				inStartPosition, RotateAnimation.RELATIVE_TO_SELF, 0.5f,
				RotateAnimation.RELATIVE_TO_SELF, 0.5f);
		rotateAnimation.setDuration(4000);// 设置动画播放的时间
		rotateAnimation.setFillAfter(true);// 动画播放完，停留在最后一帧上
		rotateAnimation.setInterpolator(LuckyWheelActivity.this,
				android.R.anim.accelerate_decelerate_interpolator);// 设置先加速再减速
		rotateAnimation.setAnimationListener(alisen); // 开始播放动画
		panWheel.startAnimation(rotateAnimation);
	}

	// 动作监听器，转盘切换旋转和结束状态时该做什么。
	private Animation.AnimationListener alisen = new Animation.AnimationListener() {
		@Override
		public void onAnimationStart(Animation animation) {

		}

		@Override
		public void onAnimationEnd(Animation animation) {
			
			String name = awardStr[amsg-1];// 根据角度，得到指向所在位置的字符串
			String award = "恭喜获得" + name + "!";
			showAwardDialog(award);
		}

		@Override
		public void onAnimationRepeat(Animation animation) {

		}
	};

	// 弹出中奖提示的对话框
	private void showAwardDialog(String award) {
		dialog = new AlertDialog.Builder(this).create();
		dialog.show();
		dialog.setCanceledOnTouchOutside(false);
		Window window = dialog.getWindow();
		window.setContentView(R.layout.lyout_custom_dialog);
		TextView infoAward = (TextView) window.findViewById(R.id.info_award);
		infoAward.setText(award);
		TextView sureAward = (TextView) window.findViewById(R.id.sure_award);
		sureAward.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				IsStartTurn = false;
				dialog.dismiss();

			}
		});
	}

	// 弹出提示扣除金额的对话框
	private void showDialog(String info) {
		dialog = new AlertDialog.Builder(this).create();
		dialog.show();
		dialog.setCanceledOnTouchOutside(false);
		Window window = dialog.getWindow();
		window.setContentView(R.layout.lyout_custom_dialog);
		TextView infoAward = (TextView) window.findViewById(R.id.info_award);
		infoAward.setText("需要消耗"+info+"金币");
		TextView sureAward = (TextView) window.findViewById(R.id.sure_award);
		sureAward.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				dialog.dismiss();
			}
		});
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
//		btnClick.setEnabled(true);
	}

	@Override
	public int getLayoutResId() {
		// TODO Auto-generated method stub
		return R.layout.activity_lucky_wheel;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		context = this;
		AppManager.getInstance().addActivity(this);
	}

	@Override
	public void initView() {
		// TODO Auto-generated method stub
	
		layout=(LinearLayout) findViewById(R.id.lucky_wheel);
		ivGoback=(ImageView) findViewById(R.id.img_back);

		title=(TextView) findViewById(R.id.title_main);
		title_second=(TextView) findViewById(R.id.title_second);
		panWheel=(ImageView) findViewById(R.id.pan_wheel);
		btnClick=(ImageView) findViewById(R.id.btn_click);
		firstAward=(TextView) findViewById(R.id.first_award);
		secondAward=(TextView) findViewById(R.id.second_award);
		thirdAward=(TextView) findViewById(R.id.third_award);
		fourthAward=(TextView) findViewById(R.id.fourth_award);
		fifthAward=(TextView) findViewById(R.id.fifth_award);
		sixthAward=(TextView) findViewById(R.id.sixth_award);
		sevenAward=(TextView) findViewById(R.id.seven_award);

		title.setText("幸运大转盘");
		title_second.setText("中奖记录");
		

	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub
		btnClick.setOnClickListener(this);
		ivGoback.setOnClickListener(this);
		title_second.setOnClickListener(this);
		
		

	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		ToRequestUrl(request, TAG, MUrlUtil.BASE_URL + MUrlUtil.AWARD,
				null, -1, -1, 29);

	}

	@Override
	public void toStartProgressDialog() {
		// TODO Auto-generated method stub
		if(IsStartTurn){
			showDialog(turn);
		}else{
			toStartProgressDialg(true);
		}

	}

	@Override
	public void doWhatForRequest(int what, String info) {
		// TODO Auto-generated method stub
		try {
			JSONObject jsonObject = new JSONObject(info);
			String error = jsonObject.getString("error");
			if ("1".equals(error)) {
				if (what==29) {
					
				
					JSONObject datas = jsonObject.getJSONObject("data");
					firstAward.setText(datas.getString("a"));
					secondAward.setText(datas.getString("b"));
					thirdAward.setText(datas.getString("c"));
					fourthAward.setText(datas.getString("d"));
					fifthAward.setText(datas.getString("e"));
					sixthAward.setText(datas.getString("f"));
					sevenAward.setText(datas.getString("g"));
					turn = jsonObject.getString("consume");
					
				}
				else if (what==88) {
						
					String prize= jsonObject.getString("prize");
						
						amsg= Integer.valueOf(prize);
//                         System.out.println("go!!!!!!"+amsg);
						if(dialog.isShowing()){
							dialog.dismiss();	
						}
						if (1 <= amsg && amsg <= 7) { 
							float angle = angles[amsg - 1]; // 随机产生一个转动角度
							toDeceleration(angle);// 做加速再减速运动，指向一个角度
						}
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
