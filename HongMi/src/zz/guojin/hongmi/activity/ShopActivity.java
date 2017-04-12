package zz.guojin.hongmi.activity;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import zz.guojin.hongmi.R;
import zz.guojin.hongmi.adapter.StaggeredAdapter;
import zz.guojin.hongmi.bean.GoodBean;
import zz.guojin.hongmi.library.views.StaggeredGridView;
import zz.guojin.hongmi.library.views.StaggeredGridView.OnItemClickListener;
import zz.guojin.hongmi.pinstame.view.SwipeRefreshAndLoadLayout;
import zz.guojin.hongmi.pinstame.view.SwipeRefreshAndLoadLayout.OnRefreshListener;
import zz.guojin.hongmi.utils.ImageFetcher;
import zz.guojin.hongmi.utils.MUrlUtil;

import android.R.integer;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.AsyncTask.Status;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

import android.widget.TextView;
import android.widget.Toast;




import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.RequestQueue;
import com.yolanda.nohttp.rest.Response;



/**
 * This will not work so great since the heights of the imageViews are
 * calculated on the iamgeLoader callback ruining the offsets. To fix this try
 * to get the (intrinsic) image width and height and set the views height
 * manually. I will look into a fix once I find extra time.
 * 
 * @author Maurycy Wojtowicz
 */
public class ShopActivity extends Activity implements
		OnRefreshListener {
	private TextView tvback;
	private ImageFetcher mImageFetcher;
	private StaggeredAdapter mAdapter;
	// private ContentTask task = new ContentTask(this, 2);
	private RequestQueue requestQueue;
	private int mType = 1;
	private SwipeRefreshAndLoadLayout swipeLayout;
	private Request<String> request;
	private Request<String> request1;
	StaggeredGridView gridView;
	private int number =8;
	private int index =0;
	private Handler handler;
	private Runnable refershRunnable,loadMoreRunnable;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_shop);
		requestQueue = NoHttp.newRequestQueue();
		handler = new Handler();
		tvback = (TextView) findViewById(R.id.tv_go_back);
		tvback.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
				
			}
		});

		mImageFetcher = new ImageFetcher(this, 240);
		mImageFetcher.setLoadingImage(R.drawable.empty_photo);
		 gridView= (StaggeredGridView) 
				findViewById(R.id.staggeredgridview1);          
		int margin = getResources().getDimensionPixelSize(R.dimen.margin);

		gridView.setFastScrollEnabled(true);

		mAdapter = new StaggeredAdapter(ShopActivity.this, mImageFetcher, this);
		gridView.setAdapter(mAdapter);
		mAdapter.notifyDataSetChanged();
		
		swipeLayout = (SwipeRefreshAndLoadLayout) this
				.findViewById(R.id.swipe_refresh);
		swipeLayout.setOnRefreshListener(this);
		swipeLayout.setmMode(SwipeRefreshAndLoadLayout.Mode.BOTH);

		swipeLayout.setColorScheme(android.R.color.holo_red_light,
				android.R.color.holo_green_light,
				android.R.color.holo_blue_bright,
				android.R.color.holo_orange_light);
		AddItemToContainer(index);
		swipeLayout.setRefreshing(false);
      
	}

	@Override
	public void onRefresh() {
         if(refershRunnable==null){
        	 refershRunnable = new Runnable() {
     			public void run() {
    				swipeLayout.setRefreshing(true);
    				mType = 1;
    				index=0;
    				AddItemToContainer(index);
    				swipeLayout.setRefreshing(false);

    			}
    		};
         }
		handler.postDelayed(refershRunnable, 1000);

	}

	@Override
	public void onLoadMore() {
        if(loadMoreRunnable==null){
        	loadMoreRunnable = new Runnable() {
    			public void run() {
    				swipeLayout.setRefreshing(true);
    				mType = 2;
    				index++;
    				AddItemToContainer(index);
    				swipeLayout.setRefreshing(false);

    			}
    		};
        }
        handler.postDelayed(loadMoreRunnable, 1000);

		
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		handler.removeCallbacks(loadMoreRunnable);
		handler.removeCallbacks(refershRunnable);
	}

	private void AddItemToContainer(int pageindex) {
//		System.out.println("===pageindex="+pageindex+"---number="+number);
		request = NoHttp.createStringRequest(MUrlUtil.BASE_URL+MUrlUtil.SHOP, RequestMethod.GET);
		request.add("number",number);
		request.add("start",number*pageindex);
		request.setCancelSign(this);
		requestQueue.add(372, request, responseListener);
	}

	OnResponseListener<String> responseListener = new OnResponseListener<String>() {
		@Override
		public void onStart(int what) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onSucceed(int what, Response<String> response) {

			if (what == 372) {
				String info = response.get();

				List<GoodBean> goodBeans = new ArrayList<GoodBean>();
				try {
					if (null != info) {
						JSONObject newsObject = new JSONObject(info);
						int error = newsObject.getInt("error");
						JSONArray blogsJson = newsObject.getJSONArray("data");
						if (!newsObject.isNull("data")) {

							for (int i = 0; i < blogsJson.length(); i++) {
								JSONObject newsInfoLeftObject = blogsJson
										.getJSONObject(i);
								GoodBean goodsInfo1 = new GoodBean();
								goodsInfo1.setName(newsInfoLeftObject
										.isNull("name") ? ""
										: newsInfoLeftObject.getString("name"));
								goodsInfo1.setImagepath(newsInfoLeftObject
										.isNull("imagepath") ? ""
										: newsInfoLeftObject
												.getString("imagepath"));
								goodsInfo1.setPrice(newsInfoLeftObject
										.isNull("price") ? ""
										: newsInfoLeftObject
												.getString("price"));
								goodsInfo1.setContent(newsInfoLeftObject
										.isNull("content") ? ""
										: newsInfoLeftObject
												.getString("content"));
								goodsInfo1.setId(newsInfoLeftObject
										.isNull("id") ? ""
										: newsInfoLeftObject
												.getString("id"));
								goodBeans.add(goodsInfo1);

							}
							 if (mType == 1) {

							mAdapter.addItemTop(goodBeans);
							mAdapter.notifyDataSetChanged();

							 } else if (mType == 2) {
							 mAdapter.addItemLast(goodBeans);
							 mAdapter.notifyDataSetChanged();
							 }
						} else {
							Toast.makeText(ShopActivity.this, "暂无数据", 0).show();
						}
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
			} 

		}

		@Override
		public void onFinish(int what) {
			// TODO Auto-generated method stub
		}

		@Override
		public void onFailed(int what, Response<String> response) {
			// TODO Auto-generated method stub

		}
	};
	
	protected void onDestroy() {
		super.onDestroy();
		if(requestQueue!=null){
			requestQueue.cancelBySign(this);
			requestQueue=null;
		}
	};

}
