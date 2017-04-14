package zz.guojin.hongmi.activity;

import java.util.ArrayList;

import org.json.JSONObject;

import zz.guojin.hongmi.R;
import zz.guojin.hongmi.R.id;
import zz.guojin.hongmi.R.layout;
import zz.guojin.hongmi.adapter.MyOutAdapter;
import zz.guojin.hongmi.adapter.ViewHodler;
import zz.guojin.hongmi.bean.UnfreezeRecordBean;
import zz.guojin.hongmi.utils.AppManager;
import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.utils.ToastUtils;
import zz.guojin.hongmi.view.XListView;
import android.content.Context;

import com.google.gson.Gson;
import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.rest.Request;

public class UnFreezeRecord extends BaseListActivity {
	private MyOutAdapter myOutAdapter;
	private Request<String> request;
	private Context context;
	private ArrayList<UnfreezeRecordBean.DataBean> list = new ArrayList<UnfreezeRecordBean.DataBean>();
	
@Override
public void initData() {
	// TODO Auto-generated method stub
	super.initData();
	if (ISFIRST) {
		currIndex = 0;
	}
   
	ToRequestUrl(request, TAG, MUrlUtil.BASE_URL + MUrlUtil.UNFREEZE, null,
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

		setTitle("解冻记录");
	}

	@Override
	public void initAdapter(XListView xListView) {
		// TODO Auto-generated method stub
		myOutAdapter = new MyOutAdapter(context,R.layout.activity_un_freeze_record,list) {

			@Override
			public void covert(int position, ViewHodler hodler) {
				// TODO Auto-generated method stub
             hodler.setText(R.id.tv_unfreeze_id, list.get(position).getUg_id());
             hodler.setText(R.id.tv_freeze_account, list.get(position).getUg_account());
             hodler.setText(R.id.tv_freeze_date, list.get(position).getJd_date());
             hodler.setText(R.id.tv_unfreeze_date, list.get(position).getUg_gettime());
			}
		};
		xListView.setAdapter(myOutAdapter);
	}

	@Override
	public void doWhatForRequest(int what, String info) {
		// TODO Auto-generated method stub
     try {
    	 System.out.println("-----"+info);
		JSONObject jsonObject = new JSONObject(info);
		String error = jsonObject.getString("error");
		if("1".equals(error)){
			if(jsonObject.getJSONArray("data").length()<=0){
				ToastUtils.showTextToast(context, "暂无数据");
				return;
			}else {
				UnfreezeRecordBean uBean = new Gson().fromJson(info, UnfreezeRecordBean.class);

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
