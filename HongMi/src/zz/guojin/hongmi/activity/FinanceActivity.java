package zz.guojin.hongmi.activity;

import java.util.ArrayList;
import zz.guojin.hongmi.fragment.HelpWalletFragment;
import zz.guojin.hongmi.fragment.OfferHelpPurseFragment;
import zz.guojin.hongmi.fragment.PrizePurseFragment;
import zz.guojin.hongmi.utils.AppManager;
import zz.guojin.hongmi.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

public class FinanceActivity extends BaseFragmentActivity{
	

	private OfferHelpPurseFragment helpPurseFragment;//实时奖金
	private PrizePurseFragment prizeFragment; 
	private HelpWalletFragment helpWalletFragment;//奖金总额
	private int id;
	@Override
	public void initFragments(ArrayList<Fragment> fragments) {
		// TODO Auto-generated method stub
		id=getIntent().getIntExtra("id", -1);
		helpPurseFragment = new OfferHelpPurseFragment();
		prizeFragment = new PrizePurseFragment();
		helpWalletFragment = new HelpWalletFragment();
		switch (id) {
		case 1:
			fragments.add(helpPurseFragment);
			setTitle("实时奖金");
			
			break;
		case 2:
//			fragments.add(prizeFragment);
			break;
		case 3:
			fragments.add(helpWalletFragment);
			setTitle("奖金总额");
			break;

		default:
			break;
		}
		
		
		
	}
	@Override
	public void initView() {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		fragments.clear();
	}

	

	
}
