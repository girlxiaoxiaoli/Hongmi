package zz.guojin.hongmi.activity;
import java.util.ArrayList;

import android.support.v4.app.Fragment;

import zz.guojin.hongmi.fragment.QiangCodeOutingFrafment;


//激活吗转账记录
public class QiangNotesActivity extends BaseFragmentActivity{
	
	private QiangCodeOutingFrafment acceptFragment;

	@Override
	public void initView() {
		// TODO Auto-generated method stub
		setTitle("抢单币转出记录");
		setRadioText("抢单币转出",null,null);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		fragments.clear();
	}

	@Override
	public void initFragments(ArrayList<Fragment> fragments) {
		// TODO Auto-generated method stub
		acceptFragment = new QiangCodeOutingFrafment();
		fragments.add(acceptFragment);
	}

}
