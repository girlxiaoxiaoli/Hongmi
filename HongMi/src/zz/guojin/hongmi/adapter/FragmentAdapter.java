package zz.guojin.hongmi.adapter;



import zz.guojin.hongmi.fragment.ContactFragment;
import zz.guojin.hongmi.fragment.FirstPagerFragment;
import zz.guojin.hongmi.fragment.ManagerFragment;
import zz.guojin.hongmi.fragment.NewsFragment;
import zz.guojin.hongmi.fragment.PersonalFragment;
import android.annotation.SuppressLint;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


public class FragmentAdapter extends FragmentStatePagerAdapter {

	@SuppressLint("NewApi")
	public FragmentAdapter(FragmentManager fm) {
		super(fm);
	}
	@Override
	public Fragment getItem(int arg0) {
		
		Fragment fragment = null;
		switch (arg0) {
		case 0:
			// 首页的fragment
			fragment = new FirstPagerFragment();
			break;
		case 1:
			// 公告的fragment
			fragment = new NewsFragment();
			break;
		case 2:
			// 联系的fragment
			fragment = new ContactFragment();

			break;
		case 3:
			//个人的fragment
			fragment = new PersonalFragment();
			break;
		default:
			break;
		}
		return fragment;
	}

	@Override
	public int getCount() {
		// 返回fragment的数量
		return 4;
	}	
}
