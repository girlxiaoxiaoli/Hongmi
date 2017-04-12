package zz.guojin.hongmi.fragment;

import com.yolanda.nohttp.Logger;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.Response;

import android.os.Handler;
import butterknife.Bind;
import zz.guojin.hongmi.view.XListView;
import zz.guojin.hongmi.view.XListView.IXListViewListener;
import zz.guojin.hongmi.R;

public abstract class BaseListFragment extends BaseFragment2 implements
		IXListViewListener {
	@Bind(R.id.xlistview)
	XListView xlistview;
	protected Runnable refreshRunnable, loadMoreRunnable;
	protected Handler handler;
	protected int number = 4;// 每页加载
	protected int currIndex;// 页数下标
	protected boolean REFRESH = false;
	protected boolean ISFIRST = true;

	@Override
	public int getLayoutResId() {
		// TODO Auto-generated method stub
		return R.layout.frag_base_list;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		handler = new Handler();
	}

	@Override
	public void initView() {
		// TODO Auto-generated method stub
		xlistview.setPullRefreshEnable(true);
		xlistview.setPullLoadEnable(true);
		xlistview.hideFootView();
		initAdapter(xlistview);
	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub
		xlistview.setXListViewListener(this);

	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
       
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
					currIndex=0;
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
					Logger.d(TAG+"onLoadMore"+currIndex);
					initData();
					stopLoad();
				}
			};
		}
		handler.postDelayed(loadMoreRunnable, 2000);

	}

	private void stopLoad() {
		xlistview.stopLoadMore();
		xlistview.stopRefresh();
	}

	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		handler.removeCallbacks(loadMoreRunnable);
		handler.removeCallbacks(refreshRunnable);
	}

	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();

	}

	/**
	 * 初始化adapter
	 * 
	 * @param xListView
	 */
	public abstract void initAdapter(XListView xListView);
}
