package zz.guojin.hongmi.activity;

import java.util.ArrayList;

import zz.guojin.hongmi.adapter.FragmentAdapter;
import zz.guojin.hongmi.utils.AppManager;
import zz.guojin.hongmi.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class MainActivity extends FragmentActivity {
	private RadioGroup radioGroup;
	private FragmentAdapter fragmentAdapter;
	private FrameLayout frameLayout;
	public static MainActivity instance;
	private TextView titleTextView;
	private ImageView goback;
	private RelativeLayout titleBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		AppManager.getInstance().addActivity(this);
		setContentView(R.layout.activity_main);
		initView();
		addListener();
	}

	public void initView() {
		titleBar = (RelativeLayout) findViewById(R.id.title_bar);
		titleBar.setVisibility(View.GONE);
		goback = (ImageView) findViewById(R.id.img_back);
		goback.setVisibility(View.INVISIBLE);
		titleTextView = (TextView) findViewById(R.id.title_main);
		titleTextView.setText("红米商城");
		radioGroup = (RadioGroup) findViewById(R.id.main_radio);
		frameLayout = (FrameLayout) findViewById(R.id.layout_content);
		// 获取Fragmentadapte对象
		fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());
		// 默认选择第一个界面，将frameLayout替换成第一个Fragment
		Fragment fragment = (Fragment) fragmentAdapter.instantiateItem(
				frameLayout, 0);
		// 将第一个界面替换成fragment
		fragmentAdapter.setPrimaryItem(frameLayout, 0, fragment);
		// 提交
		fragmentAdapter.finishUpdate(frameLayout);
	}

	public void addListener() {
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				int index = 0;
				switch (checkedId) {
				case R.id.rb_first_pager:
					index = 0;
					titleTextView.setText("红米商城");
					titleBar.setVisibility(View.GONE);
					break;
				case R.id.rb_news:
					index = 1;
					titleBar.setVisibility(View.VISIBLE);
					titleTextView.setText("管理");
					break;
				case R.id.rb_contact:
					index = 2;
					titleBar.setVisibility(View.VISIBLE);
					titleTextView.setText("留言板");
					break;
				case R.id.rb_personal:
					index = 3;
					titleBar.setVisibility(View.VISIBLE);
					titleTextView.setText("个人中心");
					break;
				}
				// 将frameLayout替换成第index个Fragment
				Fragment fragment = (Fragment) fragmentAdapter.instantiateItem(
						frameLayout, index);
				// 将第index个界面替换成fragment
				fragmentAdapter.setPrimaryItem(frameLayout, index, fragment);
				fragmentAdapter.finishUpdate(frameLayout);
			}
		});
	}

	/**
	 * 回调接口
	 * 
	 * @author zhaoxin5
	 * 
	 */
	public interface MyTouchListener {
		public void onTouchEvent(MotionEvent event);
	}

	/*
	 * 保存MyTouchListener接口的列表
	 */
	private ArrayList<MyTouchListener> myTouchListeners = new ArrayList<MainActivity.MyTouchListener>();

	/**
	 * 提供给Fragment通过getActivity()方法来注册自己的触摸事件的方法
	 * 
	 * @param listener
	 */
	public void registerMyTouchListener(MyTouchListener listener) {
		myTouchListeners.add(listener);
	}

	/**
	 * 提供给Fragment通过getActivity()方法来取消注册自己的触摸事件的方法
	 * 
	 * @param listener
	 */
	public void unRegisterMyTouchListener(MyTouchListener listener) {
		myTouchListeners.remove(listener);
	}

	/**
	 * 分发触摸事件给所有注册了MyTouchListener的接口
	 */
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		// TODO Auto-generated method stub
		for (MyTouchListener listener : myTouchListeners) {
			listener.onTouchEvent(ev);
		}
		return super.dispatchTouchEvent(ev);
	}

	// 双击退出程序
	private long exitTime = 0;

	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK
				&& event.getAction() == KeyEvent.ACTION_DOWN) {
			if ((System.currentTimeMillis() - exitTime) > 2000) {
				Toast.makeText(getApplicationContext(), "再按一次退出程序",
						Toast.LENGTH_SHORT).show();
				exitTime = System.currentTimeMillis();
			} else {
				AppManager.getInstance().killAllActivity();
				System.exit(0);
			}
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}

}
