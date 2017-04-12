package zz.guojin.hongmi.activity;

import java.util.ArrayList;

import zz.guojin.hongmi.utils.AppManager;
import zz.guojin.hongmi.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public abstract class BaseFragmentActivity extends FragmentActivity {
	// 得订单交易
	@Bind(R.id.img_back)
	ImageView goback;
	@Bind(R.id.title_main)
	TextView title;
	@Bind(R.id.radio_group)
	RadioGroup radioGroup;
	@Bind(R.id.radio1)
	RadioButton radio1;
	@Bind(R.id.radio2)
	RadioButton radio2;
	@Bind(R.id.radio3)
	RadioButton radio3;
	@Bind(R.id.container)
	FrameLayout frameLayout;

	protected ArrayList<Fragment> fragments;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		AppManager.getInstance().addActivity(this);
		setContentView(R.layout.activity_base_frag);
		ButterKnife.bind(this);
		initView();
		fragments = new ArrayList<Fragment>();

		initFragments(fragments);
		setRadio(fragments.size());
		// 默认显示提供帮助
		switchFragments(fragments.get(0));
	}

	public abstract void initFragments(ArrayList<Fragment> fragments);

	public abstract void initView();

	public void setTitle(String text) {
		title.setText(text);
	}

	public void setRadio(int size) {
		if (size == 1) {
			radioGroup.setVisibility(View.GONE);
		} else if (size == 2) {
			radio3.setVisibility(View.GONE);

		}

	}
	public void setRadioText(String text1,String text2,String text3){
		radio1.setText(text1);
		radio2.setText(text2);
		radio3.setText(text3);
	}

	@OnClick({ R.id.radio1, R.id.radio2, R.id.radio3 })
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.radio1:
			switchFragments(fragments.get(0));
			break;
		case R.id.radio2:
			switchFragments(fragments.get(1));
			break;
		case R.id.radio3:
			switchFragments(fragments.get(2));
			break;
		default:
			break;
		}
	}

	private void switchFragments(Fragment fragment) {

		FragmentTransaction transaction = getSupportFragmentManager()
				.beginTransaction();
		// 先隐藏已显示的Fragment
		for (int i = 0; i < fragments.size(); i++) {
			if (!fragments.get(i).isHidden()) {
				transaction.hide(fragments.get(i));
			}
		}
		// 判断要显示的Fragment是否已经添加，添加过的话直接显示，否则先添加再显示
		if (!fragment.isAdded()) {
			transaction.add(R.id.container, fragment).show(fragment).commit();
		} else {
			transaction.show(fragment).commit();
		}

		// TODO Auto-generated method stub

	}

	// 点击左上角按钮返回上一个页面
	@OnClick(R.id.img_back)
	public void goBack() {
		finish();
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		ButterKnife.unbind(this);
		
	}

}
