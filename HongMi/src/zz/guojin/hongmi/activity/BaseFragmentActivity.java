package zz.guojin.hongmi.activity;

import java.util.ArrayList;

import zz.guojin.hongmi.utils.AppManager;
import zz.guojin.hongmi.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;

public abstract class BaseFragmentActivity extends FragmentActivity {
	// 得订单交易
	//(R.id.img_back)
	ImageView goback;
	//(R.id.title_main)
	TextView title;
	//(R.id.radio_group)
	RadioGroup radioGroup;
	//(R.id.radio1)
	RadioButton radio1;
	//(R.id.radio2)
	RadioButton radio2;
	//(R.id.radio3)
	RadioButton radio3;
	//(R.id.container)
	FrameLayout frameLayout;

	protected ArrayList<Fragment> fragments;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		AppManager.getInstance().addActivity(this);
		setContentView(R.layout.activity_base_frag);
		goback = (ImageView)findViewById(R.id.img_back);
		title=(TextView)findViewById(R.id.title_main);
		radioGroup=(RadioGroup)findViewById(R.id.radio_group);
		radio1 =(RadioButton)findViewById(R.id.radio1);
		radio2=(RadioButton)findViewById(R.id.radio2);
		radio3=(RadioButton)findViewById(R.id.radio3);
		frameLayout = (FrameLayout)findViewById(R.id.container);
		goback.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				AppManager.getInstance().killActivity(BaseFragmentActivity.this);
				
			}
		});
		radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				// TODO Auto-generated method stub
				checkedId = group.getCheckedRadioButtonId();
				switch (checkedId) {
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
		});
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


	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		
	}

}
