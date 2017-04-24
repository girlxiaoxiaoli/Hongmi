package zz.guojin.hongmi.fragment;

import org.json.JSONException;
import org.json.JSONObject;

import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;
import zz.guojin.hongmi.activity.ChangeLoginPwdActivity;
import zz.guojin.hongmi.activity.ChangeSecondPwdActivity;
import zz.guojin.hongmi.activity.CheckRegistActivity;
import zz.guojin.hongmi.activity.LoginActivity;
import zz.guojin.hongmi.activity.PersonalDataActivity;
import zz.guojin.hongmi.activity.ReferenceActivity;
import zz.guojin.hongmi.activity.ReplyActivity;
import zz.guojin.hongmi.utils.AppManager;
import zz.guojin.hongmi.utils.JumpUtil;
import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.utils.SpUtils;
import zz.guojin.hongmi.utils.ToastUtils;
import zz.guojin.hongmi.R;

import android.R.raw;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class PersonalFragment extends BaseFragment2 implements OnClickListener {

	//(R.id.ll_personal_data)
	LinearLayout ll_personal_data;
	//(R.id.ll_chang_login_pwd)
	LinearLayout ll_chang_login_pwd;
	//(R.id.ll_chang_second_pwd)
	LinearLayout ll_chang_second_pwd;
	//(R.id.ll_reply)
	LinearLayout ll_reply;
	//(R.id.ll_user_group)
	LinearLayout ll_user_group;
	//(R.id.ll_tuijian_list)
	LinearLayout ll_tuijian_list;

	Request<String> request;

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.ll_personal_data:
			JumpUtil.JumpActivity(getActivity(), PersonalDataActivity.class);
			break;
		case R.id.ll_chang_login_pwd:
			JumpUtil.JumpActivity(getActivity(), ChangeLoginPwdActivity.class);
			break;
		case R.id.ll_chang_second_pwd:
			JumpUtil.JumpActivity(getActivity(), ChangeSecondPwdActivity.class);
			break;
		case R.id.ll_reply:
			JumpUtil.JumpActivity(getActivity(), ReplyActivity.class);
			break;
		case R.id.ll_user_group:
			//团队管理
			JumpUtil.JumpActivity(getActivity(), CheckRegistActivity.class);
			break;
		case R.id.ll_tuijian_list:
//			团队成员
			JumpUtil.JumpActivity(getActivity(), ReferenceActivity.class); 
			break;
		
		default:
			break;
		}
	}

	@Override
	public int getLayoutResId() {
		// TODO Auto-generated method stub
		return R.layout.frag_personal;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initView() {
		// TODO Auto-generated method stub
		ll_personal_data=(LinearLayout)rootView.findViewById(R.id.ll_personal_data);
		ll_chang_login_pwd=(LinearLayout)rootView.findViewById(R.id.ll_chang_login_pwd);
		ll_chang_second_pwd=(LinearLayout)rootView.findViewById(R.id.ll_chang_second_pwd);
		ll_reply=(LinearLayout)rootView.findViewById(R.id.ll_reply);
		ll_user_group=(LinearLayout)rootView.findViewById(R.id.ll_user_group);
		ll_tuijian_list=(LinearLayout)rootView.findViewById(R.id.ll_tuijian_list);
	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub
		ll_personal_data.setOnClickListener(this);
		ll_chang_login_pwd.setOnClickListener(this);
		ll_chang_second_pwd.setOnClickListener(this);
		ll_reply.setOnClickListener(this);
		ll_user_group.setOnClickListener(this);
		ll_tuijian_list.setOnClickListener(this);
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
