package zz.guojin.hongmi.activity;

import com.yolanda.nohttp.Logger;
import zz.guojin.hongmi.utils.AppManager;
import zz.guojin.hongmi.view.XListView;
import zz.guojin.hongmi.view.XListView.IXListViewListener;
import zz.guojin.hongmi.R;

import android.os.Handler;

import android.content.Context;

import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public abstract class BaseListActivity extends BaseActivity implements
		IXListViewListener, OnClickListener {
	// @Bind(R.id.img_back)
	ImageView goback;
	// @Bind(R.id.title_main)
	TextView title;
	// @Bind(R.id.title_second)
	TextView title_second;
	// @Bind(R.id.list_activity)
	protected XListView xListView;
	protected Context context;
	protected Runnable refreshRunnable, loadMoreRunnable;
	protected Handler handler;
	protected int number = 10;// 每页加载
	protected int currIndex;// 页数下标
	protected boolean REFRESH = false;
	protected boolean ISFIRST = true;

	@Override
	public int getLayoutResId() {
		// TODO Auto-generated method stub
		return R.layout.activity_base_list;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		context = this;
		AppManager.getInstance().addActivity(this);
		handler = new Handler();

	}

	@Override
	public void initView() {
		// TODO Auto-generated method stub
		goback = (ImageView) findViewById(R.id.img_back);
		title = (TextView) findViewById(R.id.title_main);
		title_second = (TextView) findViewById(R.id.title_second);
		xListView = (XListView) findViewById(R.id.list_activity);

		initTitle();
		xListView.setPullRefreshEnable(true);
		xListView.setPullLoadEnable(true);
		xListView.hideFootView();
		initAdapter(xListView);

	}

	public abstract void initTitle();

	public void setTitle(String title) {
		this.title.setText(title);
	}

	public void setSecondTitle(String title) {
		this.title_second.setText(title);
	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub
		xListView.setXListViewListener(this);
		goback.setOnClickListener(this);

	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(android.view.View v) {
		AppManager.getInstance().killActivity(getClass());
	}

	@Override
	public void toStartProgressDialog() {
		// TODO Auto-generated method stub
		toStartProgressDialg(ISFIRST);
		ISFIRST = false;
	}

	@Override
	public void onRefresh() {
		// TODO Auto-generated method stub
		if (refreshRunnable == null) {
			refreshRunnable = new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					REFRESH = true;
					currIndex = 0;
					initData();
					stopLoad();
				}
			};
		}
		handler.postDelayed(refreshRunnable, 2000);
	}

	@Override
	public void onLoadMore() {
		// TODO Auto-generated method stub
		if (loadMoreRunnable == null) {
			loadMoreRunnable = new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					ISFIRST = false;
					currIndex++;
					Logger.d(TAG + "onLoadMore" + currIndex);
					initData();
					stopLoad();
				}
			};
		}
		handler.postDelayed(loadMoreRunnable, 2000);

	}

	private void stopLoad() {
		xListView.stopLoadMore();
		xListView.stopRefresh();
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		handler.removeCallbacks(loadMoreRunnable);
		handler.removeCallbacks(refreshRunnable);
	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();

	}

	/**
	 * 初始化adapter
	 * 
	 * @param xListView
	 */
	public abstract void initAdapter(XListView xListView);
}
