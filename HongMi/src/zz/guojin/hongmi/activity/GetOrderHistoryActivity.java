package zz.guojin.hongmi.activity;

import java.util.ArrayList;
import zz.guojin.hongmi.fragment.GetPaidanFrafment;
import zz.guojin.hongmi.fragment.GetPipeiFrafment;
import zz.guojin.hongmi.utils.AppManager;
import zz.guojin.hongmi.R;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;

public class GetOrderHistoryActivity extends BaseFragmentActivity {
	// 得订单交易

	private GetPaidanFrafment getPdFrafment;
	private GetPipeiFrafment pipFrafment;

	@Override
	public void initFragments(ArrayList<Fragment> fragments) {
		// TODO Auto-generated method stub
		getPdFrafment = new GetPaidanFrafment();
		pipFrafment = new GetPipeiFrafment();
		fragments.add(getPdFrafment);
		fragments.add(pipFrafment);
	}

	@Override
	public void initView() {
		// TODO Auto-generated method stub
		setTitle("收米记录");
		setRadioText("排单信息", "匹配信息", null);
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		fragments.clear();
	}

}
