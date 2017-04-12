package zz.guojin.hongmi.activity;

import java.util.ArrayList;

import zz.guojin.hongmi.fragment.AcceptGroupFragment;
import zz.guojin.hongmi.fragment.OfferGroupFragment;


import android.support.v4.app.Fragment;

public class UserGroupActivity extends BaseFragmentActivity {

	private OfferGroupFragment offerFragment;
	private AcceptGroupFragment acceptFragment;

	// gridview用户群管理界面
	@Override
	public void initFragments(ArrayList<Fragment> fragments) {
		// TODO Auto-generated method stub
		offerFragment = new OfferGroupFragment();
		acceptFragment = new AcceptGroupFragment();
		fragments.add(offerFragment);
		fragments.add(acceptFragment);
	}

	@Override
	public void initView() {
		// TODO Auto-generated method stub
		setTitle("用户群");
		setRadioText("群体贡献", "群体收益", null);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		fragments.clear();
	}

}
