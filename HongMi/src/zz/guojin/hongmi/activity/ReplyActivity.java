package zz.guojin.hongmi.activity;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;

import zz.guojin.hongmi.adapter.MyOutAdapter;
import zz.guojin.hongmi.adapter.ViewHodler;
import zz.guojin.hongmi.bean.ReplyBean;
import zz.guojin.hongmi.bean.ReplyBean.ReplyDataBean;
import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.utils.ToastUtils;
import zz.guojin.hongmi.view.XListView;
import zz.guojin.hongmi.R;


public class ReplyActivity extends BaseListActivity {
	
	private ArrayList<ReplyDataBean> replybeanList = new ArrayList<ReplyDataBean>();
	private Request<String> request;
	private MyOutAdapter adapter;
	
	
@Override
public void initTitle() {
	// TODO Auto-generated method stub
	title.setText("留言回复");
}


@Override
public void initData() {
	// TODO Auto-generated method stub
	if (ISFIRST) {
		currIndex = 0;
	}

	ToRequestUrl(request, TAG, MUrlUtil.BASE_URL+MUrlUtil.REPLY, null,
			number, currIndex, 360);

}




@Override
public void initAdapter(XListView xListView) {
	// TODO Auto-generated method stub
	adapter = new MyOutAdapter(ReplyActivity.this,R.layout.news_list_item, replybeanList) {

		@Override
		public void covert(int position, ViewHodler hodler) {
			 
			hodler.setText(R.id.tv_content, "标题:");
			hodler.setText(R.id.tv_a, "回复内容:");
			hodler.setText(R.id.sendtime,replybeanList.get(position).getMa_replytime());
			hodler.setText(R.id.cont, replybeanList.get(position).getMa_theme());
			hodler.setText(R.id.address,replybeanList.get(position).getMa_reply());

		}
	};
	xListView.setAdapter(adapter);
	
}

@Override
public void doWhatForRequest(int what, String info) {
	// TODO Auto-generated method stub
	if (what == 360) {
		
		Logger.i(TAG + "response.get()=" + info);
		JSONObject jsonObject;
		try {
			jsonObject = new JSONObject(info);
			JSONArray jsonArray=jsonObject.getJSONArray("data");
			if(jsonArray.length()<=0){
				ToastUtils.showTextToast(context, "没有更多数据");
			}

		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		Gson gson = new Gson();
		ReplyBean news = gson.fromJson(info, ReplyBean.class);
		if (REFRESH) {
			adapter.refreshItem(news.getData());
			REFRESH = false;
		} else {
			adapter.addItemLast(news.getData());
		}
		// 如果第一次加载的条目比较，就隐藏加载更多
		if (ISFIRST) {
			if (news.getData().size() < number) {
				xListView.hideFootView();
			}
		}
	}
}

}
