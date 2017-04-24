package zz.guojin.hongmi.fragment;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.rest.Request;

import zz.guojin.hongmi.adapter.MyOutAdapter;
import zz.guojin.hongmi.adapter.ViewHodler;
import zz.guojin.hongmi.bean.GiveOrderPdBean;
import zz.guojin.hongmi.bean.GiveOrderPdBean.PdData;
import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.utils.ToastUtils;
import zz.guojin.hongmi.view.XListView;
import zz.guojin.hongmi.view.XListView.IXListViewListener;
import zz.guojin.hongmi.R;

//舍记录 排单信息     和得记录javabean参数一样，在此就公用一个javaBean 对象
public class GivePaiDanMessFragment extends BaseListFragment implements
IXListViewListener {
	
	private ArrayList<PdData> dataList = new ArrayList<GiveOrderPdBean.PdData>();
	private MyOutAdapter adapter;
	private Request<String> request;
	@Override
	public void initData() {
		// TODO Auto-generated method stub
		if (ISFIRST) {
			currIndex = 0;
		}

	ToRequestUrl(request, TAG, MUrlUtil.BASE_URL+ MUrlUtil.GIVE_PD,
			null, number, currIndex, 372);
       
	}
	
	

	

	@Override
	public void initAdapter(XListView xListView) {
		// TODO Auto-generated method stub
		adapter = new MyOutAdapter(getActivity(),R.layout.give_order_single_list_item, dataList) {

			@Override
			public void covert(int position, ViewHodler hodler) {
				hodler.setText(R.id.tv_give_id, dataList.get(position).getId());
				hodler.setText(R.id.tv_give_actor, dataList.get(position).getUser());
				hodler.setText(R.id.tv_give_accout, dataList.get(position).getJb());
				hodler.setText(R.id.tv_give_date, dataList.get(position).getDate());
				hodler.setText(R.id.tv_give2_state, dataList.get(position).getZt());

			}
		};
		xListView.setAdapter(adapter);
		
	}

	@Override
	public void doWhatForRequest(int what, String info) {
		// TODO Auto-generated method stub
		if (what == 372) {
			try {
				JSONObject jsonObject = new JSONObject(info);
				if(jsonObject.getJSONArray("data").length()<=0){
					ToastUtils.showTextToast(getActivity(), "没有更多数据");
					return;
				}
			} catch (JSONException e) {
				// TODO Auto-generated catch block
			Logger.e(TAG+e.getMessage());
			}
			Logger.i(TAG+"response.get()="+info);
			Gson gson = new Gson();
			GiveOrderPdBean giveBean = gson.fromJson(info,
					GiveOrderPdBean.class);
			
			if (REFRESH) {
				adapter.refreshItem(giveBean.getData());
				REFRESH = false;
			}else{
				adapter.addItemLast(giveBean.getData());

			}
			// 如果第一次加载的条目比较，就隐藏加载更多
			if (ISFIRST) {
				if (dataList.size() < number) {
				xlistview.hideFootView();
			}
		}
		}
	}
	
}
