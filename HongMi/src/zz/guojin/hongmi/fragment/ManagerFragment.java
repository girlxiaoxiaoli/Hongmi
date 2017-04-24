package zz.guojin.hongmi.fragment;

import zz.guojin.hongmi.activity.ActivationCodeActivity;
import zz.guojin.hongmi.activity.CheckRegistActivity;
import zz.guojin.hongmi.activity.FinanceActivity;
import zz.guojin.hongmi.utils.JumpUtil;
import zz.guojin.hongmi.R;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class ManagerFragment extends BaseFragment2 implements OnClickListener {
	private TextView activeCode, team, finance,qiang;

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.active_manager:
			JumpUtil.JumpActivity(getActivity(), ActivationCodeActivity.class);
			break;
		case R.id.team_manager:

			JumpUtil.JumpActivity(getActivity(), CheckRegistActivity.class);

			break;
		case R.id.finace_manager:
			JumpUtil.JumpActivity(getActivity(), FinanceActivity.class);
		case R.id.qiang_manager:
//			JumpUtil.JumpActivity(getActivity(), QiangCodeActivity.class);

			break;

		default:
			break;
		}
	}

	@Override
	public int getLayoutResId() {
		// TODO Auto-generated method stub
		return R.layout.frag_manager;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initView() {
		// TODO Auto-generated method stub
		activeCode = (TextView) rootView.findViewById(R.id.active_manager);
		team = (TextView) rootView.findViewById(R.id.team_manager);
		finance = (TextView) rootView.findViewById(R.id.finace_manager);
		qiang = (TextView) rootView.findViewById(R.id.qiang_manager);

	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub
		activeCode.setOnClickListener(this);
		team.setOnClickListener(this);
		finance.setOnClickListener(this);
		qiang.setOnClickListener(this);
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void toStartProgressDialog() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doWhatForRequest(int what, String info) {
		// TODO Auto-generated method stub

	}

}
