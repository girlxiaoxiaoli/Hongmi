package zz.guojin.hongmi.adapter;

import java.util.ArrayList;
import java.util.List;

import zz.guojin.hongmi.bean.AcceptHelpGroupBean.DataBean;
import zz.guojin.hongmi.R;

import android.R.integer;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
/**
 * 公用adapter
 * @author Administrator
 *
 * @param <T>
 */
public abstract class CommonAdapter extends BaseAdapter {
	protected List datas;
	protected Context context;
	protected LayoutInflater inflater;
	protected int mlayoutId;

	public CommonAdapter(Context context, int layoutId, List list) {
		super();
		this.datas = list == null ? new ArrayList() : list;
		this.context = context;
		inflater = LayoutInflater.from(context);
		this.mlayoutId = layoutId;

	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return datas == null ? 0 : datas.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return datas.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHodler viewHodler = ViewHodler.get(context, convertView, parent,
				mlayoutId, position);
		covert(position, viewHodler);
		return viewHodler.getConvertView();
	}
    /**
     * 给List 添加数据
     * @param mDatas
     */
	public void addItemLast(List mDatas) {
		datas.addAll(mDatas);
		System.out.println("addItemLast--------"+mDatas.size());
		notifyDataSetChanged();
	}
	/**
	 * 刷新 添加数据 刷新adapter
	 * @param list
	 */
	public void refreshItem(List list) {
		datas.clear();
		datas.addAll(list);
		System.out.println("refreshItem--------"+list.size());
		notifyDataSetChanged();
	}
	
	public void removeDate(int position){
		datas.remove(position);
		notifyDataSetChanged();
	}
/**
 * 
 * @param position
 * @param hodler
 */
	public abstract void covert(int position, ViewHodler hodler);

}
