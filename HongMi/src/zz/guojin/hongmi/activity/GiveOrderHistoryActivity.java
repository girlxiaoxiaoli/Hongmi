package zz.guojin.hongmi.activity;

import java.util.ArrayList;
import zz.guojin.hongmi.fragment.GivePaiDanMessFragment;
import zz.guojin.hongmi.fragment.GivePiPeiMessFragment;
import zz.guojin.hongmi.utils.AppManager;
import zz.guojin.hongmi.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class GiveOrderHistoryActivity extends BaseFragmentActivity{

	
	private GivePaiDanMessFragment givePaiDanMess;
	private GivePiPeiMessFragment givePiPeiMess;
	@Override
	public void initFragments(ArrayList<Fragment> fragments) {
		// TODO Auto-generated method stub
		givePaiDanMess = new GivePaiDanMessFragment();
		givePiPeiMess = new GivePiPeiMessFragment();
		fragments.add(givePaiDanMess);
		fragments.add(givePiPeiMess);
	}
	@Override
	public void initView() {
		// TODO Auto-generated method stub
		setTitle("打米记录");
		setRadioText( "排单信息", "匹配信息",null);
	}
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		fragments.clear();
	}
	
	
}
