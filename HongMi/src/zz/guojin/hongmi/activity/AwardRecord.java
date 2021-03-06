package zz.guojin.hongmi.activity;

import java.util.ArrayList;

import org.json.JSONObject;

import com.google.gson.Gson;
import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.rest.Request;


import zz.guojin.hongmi.R;
import zz.guojin.hongmi.R.id;
import zz.guojin.hongmi.R.layout;
import zz.guojin.hongmi.adapter.MyOutAdapter;
import zz.guojin.hongmi.adapter.ViewHodler;
import zz.guojin.hongmi.bean.AwardRecodeBean;
import zz.guojin.hongmi.utils.AppManager;
import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.utils.ToastUtils;
import zz.guojin.hongmi.view.XListView;

import android.content.Context;

public class AwardRecord extends BaseListActivity {

	private MyOutAdapter myOutAdapter;
	private Request<String> request;
	private Context context;
	ArrayList<AwardRecodeBean.DataBean> dArrayList = new ArrayList<AwardRecodeBean.DataBean>();
	
@Override
public void initData() {
	// TODO Auto-generated method stub
	super.initData();
	if (ISFIRST) {
		currIndex = 0;
	}
   
	ToRequestUrl(request, TAG, MUrlUtil.BASE_URL + MUrlUtil.AWARD_RECORD, null,
			number, currIndex, 300);

}
	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		context = this;
		AppManager.getInstance().addActivity(this);
	}

	@Override
	public void initTitle() {
		// TODO Auto-generated method stub

		setTitle("抽奖记录");
	}

	@Override
	public void initAdapter(XListView xListView) {
		// TODO Auto-generated method stub
		myOutAdapter = new MyOutAdapter(context,R.layout.activity_award_record,dArrayList) {

			@Override
			public void covert(int position, ViewHodler hodler) {
				// TODO Auto-generated method stub
				//初始化数据
			
             hodler.setText(R.id.time_award, dArrayList.get(position).getTime());
             hodler.setText(R.id.award_award, dArrayList.get(position).getReward_id());
             hodler.setText(R.id.code_award, dArrayList.get(position).getReward_num());
             hodler.setText(R.id.money_award, dArrayList.get(position).getConsume());
			}
		};
		xListView.setAdapter(myOutAdapter);
	}

	@Override
	public void doWhatForRequest(int what, String info) {
		// TODO Auto-generated method stub
     try {
		JSONObject jsonObject = new JSONObject(info);
		String error = jsonObject.getString("error");
		if("1".equals(error)){
			if(jsonObject.getString("data").length()<=0){
				ToastUtils.showTextToast(context, "暂无数据");
				return;
			}else {
				AwardRecodeBean uBean = new Gson().fromJson(info, AwardRecodeBean.class);

				if (REFRESH) {
					myOutAdapter.refreshItem(uBean.getData());
					REFRESH = false;
				} else {
					myOutAdapter.addItemLast(uBean.getData());

				}
				// 如果第一次加载的条目比较，就隐藏加载更多
				if (ISFIRST) {
					if (uBean.getData().size() < number) {
						xListView.hideFootView();
					}
				}
			}
		}
	} catch (Exception e) {
		// TODO: handle exception
		Logger.e(TAG+e.getMessage());
	}
	}

}
