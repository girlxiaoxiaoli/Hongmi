package zz.guojin.hongmi.activity;
import java.util.ArrayList;

import android.support.v4.app.Fragment;

import zz.guojin.hongmi.fragment.ActiveCodeIncomingFrafment;
import zz.guojin.hongmi.fragment.ActiveCodeOutingFrafment;


//激活吗转账记录
public class NotesActivity extends BaseFragmentActivity{
	
	private ActiveCodeIncomingFrafment offerFragment;
	private ActiveCodeOutingFrafment acceptFragment;

	@Override
	public void initView() {
		// TODO Auto-generated method stub
		setTitle("激活码转账记录");
		setRadioText("激活码转出", "激活码转入",null);
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
		offerFragment = new ActiveCodeIncomingFrafment();
		acceptFragment = new ActiveCodeOutingFrafment();
		fragments.add(offerFragment);
		fragments.add(acceptFragment);
	}

}
