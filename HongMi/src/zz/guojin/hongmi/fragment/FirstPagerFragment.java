package zz.guojin.hongmi.fragment;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshBase.OnRefreshListener;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;

import com.yolanda.nohttp.Logger;

import com.yolanda.nohttp.rest.Request;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import zz.guojin.hongmi.activity.ActivationCodeActivity;
import zz.guojin.hongmi.activity.AdministratorAccount;
import zz.guojin.hongmi.activity.ClearCapital;
import zz.guojin.hongmi.activity.DaMiActivity;
import zz.guojin.hongmi.activity.FinanceActivity;
import zz.guojin.hongmi.activity.GetActivity;
import zz.guojin.hongmi.activity.GetOrderHistoryActivity;
import zz.guojin.hongmi.activity.GiveOrderHistoryActivity;
import zz.guojin.hongmi.activity.LianjieActivity;
import zz.guojin.hongmi.activity.LoginActivity;
import zz.guojin.hongmi.activity.LuckyWheelActivity;
import zz.guojin.hongmi.activity.MemberreRegistActivity;
import zz.guojin.hongmi.activity.QiangOrderActivity;
import zz.guojin.hongmi.activity.ReferenceActivity;
import zz.guojin.hongmi.activity.ShopActivity;
import zz.guojin.hongmi.activity.UnFreezeRecord;
import zz.guojin.hongmi.activity.UserGroupActivity;
import zz.guojin.hongmi.gridview.MyGridAdapter;
import zz.guojin.hongmi.gridview.MyGridView;
import zz.guojin.hongmi.utils.AppManager;
import zz.guojin.hongmi.utils.JumpUtil;
import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.utils.SpUtils;
import zz.guojin.hongmi.utils.ToastUtils;
import zz.guojin.hongmi.R;

import android.R.integer;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

public class FirstPagerFragment extends BaseFragment2 implements
		OnItemClickListener {
	@Bind(R.id.tv_dami)
	TextView tv_dami; // 打米
	@Bind(R.id.tv_shoumi)
	TextView tv_shoumi;// 收米
	@Bind(R.id.gridview)
	MyGridView gridview;
	@Bind(R.id.tv_money1)
	TextView tv_money1;// 红米钱包
	@Bind(R.id.tv_money2)
	TextView tv_money2;// 经理钱包
	@Bind(R.id.tv_money3)
	TextView tv_money3;// 推荐钱包
	@Bind(R.id.tv_name_user)
	TextView tv_name_user;// 会员账号
	@Bind(R.id.tv_id_user)
	TextView tv_id_user; // 会员id
	@Bind(R.id.tv_grade_user)
	TextView tv_grade_user;// 会员等级
	@Bind(R.id.tv_exit)
	TextView tv_exit;// 退出
	@Bind(R.id.shopping)
	TextView shopping;// 商城
	@Bind(R.id.luck_wheel)
	TextView luck_wheel;// 转盘
	private String TAG = getClassName();

	String ue_money;//红米钱包
	String jl_he;//经理钱包
	String tj_he;//推荐钱包
	private PullToRefreshScrollView mPullRefreshScrollView;
	private ScrollView mScrollView;
	Request<String> request;
	private boolean ISFIRST = true;

	private class GetDataTask extends AsyncTask<Void, Void, String[]> {

		@Override
		protected String[] doInBackground(Void... params) {
			// Simulates a background job.
			initData();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
			}
			return null;
		}

		@Override
		protected void onPostExecute(String[] result) {
			// Do some stuff here

			// Call onRefreshComplete when the list has been refreshed.
			mPullRefreshScrollView.onRefreshComplete();

			super.onPostExecute(result);
		}
	}

	@OnClick({ R.id.tv_shoumi, R.id.tv_dami, R.id.shopping, R.id.luck_wheel,
			R.id.tv_exit })
	public void onClick(View view) {
		int id = view.getId();
		switch (id) {
		case R.id.tv_shoumi:
			//收米
			Intent intent = new Intent();
			intent.putExtra("hongmi_money", ue_money);
			intent.putExtra("jingli_money", jl_he);
			intent.putExtra("tuijian_money", tj_he);
			intent.setClass(getActivity(), GetActivity.class);
			startActivity(intent);
			break;
		case R.id.tv_dami:
			//打米
			JumpUtil.JumpActivity(getActivity(), DaMiActivity.class);

			break;
		case R.id.shopping:
			//商城
			JumpUtil.JumpActivity(getActivity(), ShopActivity.class);

//			ToastUtils.showTextToast(getActivity(), "商城");

			break;
		case R.id.luck_wheel:
//			转盘
			JumpUtil.JumpActivity(getActivity(), LuckyWheelActivity.class);

			break;
		case R.id.tv_exit:
			//退出
			SpUtils.put(getActivity(), "IS_LOGIN", false);
			JumpUtil.JumpActivity(getActivity(), LoginActivity.class);
			AppManager.getInstance().killActivity(getActivity());
			break;

		default:
			break;
		}

	}

	// gridview条目点击
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		switch (position) {
		case 0:
			//打米记录
			JumpUtil.JumpActivity(getActivity(), GiveOrderHistoryActivity.class);

//			JumpUtil.JumpActivity(getActivity(), UserGroupActivity.class);我的用户群
			break;
		case 1:
			//收米记录
			JumpUtil.JumpActivity(getActivity(), GetOrderHistoryActivity.class);

//			JumpUtil.JumpActivity(getActivity(), MemberreRegistActivity.class); 注册会员
			break;
		case 2:
			//激活码
			JumpUtil.JumpActivity(getActivity(), ActivationCodeActivity.class); 
			
			break;
		case 3:
			//管理账号
//			ToastUtils.showTextToast(getActivity(), "管理账户");
			JumpUtil.JumpActivity(getActivity(), AdministratorAccount.class);

			break;
		case 4:
			//奖金总额
//			ToastUtils.showTextToast(getActivity(), "奖金总额");
			Bundle bundle = new Bundle();
			bundle.putInt("id", 3);
			JumpUtil.jumpToActivity(getActivity(), FinanceActivity.class, bundle);
			
			break;
		case 5:
			Bundle bundle1 = new Bundle();
			bundle1.putInt("id", 1);
			JumpUtil.jumpToActivity(getActivity(), FinanceActivity.class, bundle1);

			break;
		case 6:
//			ToastUtils.showTextToast(getActivity(), "二维码");
			JumpUtil.JumpActivity(getActivity(), LianjieActivity.class);
			break;
		case 7:
//			ToastUtils.showTextToast(getActivity(), "冻结记录");
			JumpUtil.JumpActivity(getActivity(), UnFreezeRecord.class);
			break;
		case 8:
			Bundle bundle2 = new Bundle();
			bundle2.putString("money",ue_money);
			JumpUtil.jumpToActivity(getActivity(), ClearCapital.class, bundle2);

			break;
		default:
			break;
		}

}

	@Override
	public int getLayoutResId() {
		// TODO Auto-generated method stub
		return R.layout.frag_firstpager;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		ButterKnife.bind(this, rootView);
	}

	@Override
	public void initView() {
		// TODO Auto-generated method stub
		// 进入页面，总是显示最顶端，让gridview失去焦点即可
		gridview.setFocusable(false);
		mPullRefreshScrollView = (PullToRefreshScrollView) rootView
				.findViewById(R.id.scrollview);
		mScrollView = mPullRefreshScrollView.getRefreshableView();
		gridview.setAdapter(new MyGridAdapter(getActivity()));
		

	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub
		mPullRefreshScrollView
				.setOnRefreshListener(new OnRefreshListener<ScrollView>() {

					@Override
					public void onRefresh(
							PullToRefreshBase<ScrollView> refreshView) {
						// TODO Auto-generated method stub
						new GetDataTask().execute();
					}
				});
		gridview.setOnItemClickListener(this);
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		ToRequestUrl(request, TAG, MUrlUtil.BASE_URL + MUrlUtil.HOME, null, -1,
				-1, 300);
	}

	@Override
	public void toStartProgressDialog() {
		// TODO Auto-generated method stub
		toStartProgressDialg(ISFIRST);
		ISFIRST = false;
	}

	@Override
	public void doWhatForRequest(int what, String info) {
		// TODO Auto-generated method stub
		if (what == 300) {
			try {
				JSONObject jsonObject = new JSONObject(info);

				JSONObject data = jsonObject.getJSONObject("data");

				if (data.length() <= 0) {
					ToastUtils.showTextToast(getActivity(), "没有更多数据");
					return;
				}

				if (data.has("ue_money")) {
					//红米钱包

					ue_money = "".equals(data.getString("ue_money")) ? "0"
							: data.getString("ue_money");
					tv_money1.setText("".equals(ue_money) ? "0" : ue_money);
				}
				if (data.has("jl_he")) {
					// 经理钱包
					jl_he = "".equals(data.getString("jl_he")) ? "0" : data
							.getString("jl_he");
					tv_money2.setText("".equals(jl_he) ? "0" : jl_he);
				}
				if (data.has("tj_he")) {
					// 推荐钱包
					tj_he = "".equals(data.getString("tj_he")) ? "0"
							: data.getString("tj_he");
					tv_money3.setText("".equals(tj_he) ? "0" : tj_he);
				}
				if (data.has("ue_account")) {
					// 会员账号
					String ue_account = "".equals(data.getString("ue_account")) ? "0"
							: data.getString("ue_account");
					tv_name_user.setText("".equals(ue_account) ? "0"
							: ue_account);
				}
				if (data.has("ue_id")) {
					// 编号
					String ue_id = "".equals(data.getString("ue_id")) ? "0"
							: data.getString("ue_id");
					tv_id_user.setText("".equals(ue_id) ? "0" : ue_id);
				}
				if (data.has("level")) {
					// 会员等级
					String level = "".equals(data.getString("level")) ? "0"
							: data.getString("level");
					tv_grade_user.setText("".equals(level) ? "0" : level);
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				Logger.e(TAG + "首页" + e.getMessage());
			}
		}
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		ButterKnife.unbind(this);
	}

}
