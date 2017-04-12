package zz.guojin.hongmi.gridview;

import zz.guojin.hongmi.adapter.ViewHodler;
import zz.guojin.hongmi.R;
import android.R.integer;
import android.content.Context;
import android.graphics.Color;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * @Description:gridview的Adapter
 * 
 */
public class MyGridAdapter extends BaseAdapter {
	private Context mContext;

	public String[] img_text = { "打米记录", "收米记录", "激活码", "管理账号", "奖金总额", "实时奖金",
			"二维码", "解冻记录", "清算本金" };
	public int[] imgs = { R.drawable.item1, R.drawable.item2, 
			R.drawable.item4,R.drawable.item3, R.drawable.item5, R.drawable.item6,
			R.drawable.item7, R.drawable.item8, R.drawable.item9 };

	// private int[] bgs = { R.color.blue, R.color.orange, R.color.green,
	// R.color.red2, R.color.orange2, R.color.green3,
	// R.color.grey2,R.color.yellow, R.color.pink };

	public MyGridAdapter(Context mContext) {
		super();
		this.mContext = mContext;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return img_text.length;
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHodler hodler = ViewHodler.get(mContext, convertView, parent,
				R.layout.frag_grid_item, position);// Color.parseColor("#3579f4")
		hodler.setText(R.id.tv_item, img_text[position]);
		hodler.setImageBackgroundResource(R.id.iv_item, imgs[position]);// 没事
																		// 就当没发生

		if (position == 0) {
			hodler.setViewBackgroundColor(R.id.item_gridview,
					Color.parseColor("#3579f4"));
		} else if (position == 1) {
			hodler.setViewBackgroundColor(R.id.item_gridview,
					Color.parseColor("#d4762c"));
		} else if (position == 2) {
			hodler.setViewBackgroundColor(R.id.item_gridview,
					Color.parseColor("#8fbe3a"));
		} else if (position == 3) {
			hodler.setViewBackgroundColor(R.id.item_gridview,
					Color.parseColor("#e13d5d"));
		} else if (position == 4) {
			hodler.setViewBackgroundColor(R.id.item_gridview,
					Color.parseColor("#c5c5c5"));
			
		} else if (position == 5) {
			hodler.setViewBackgroundColor(R.id.item_gridview,
					Color.parseColor("#48f2a9"));
		} else if (position == 6) {
			hodler.setViewBackgroundColor(R.id.item_gridview,
					Color.parseColor("#dc7f38"));
		} else if (position == 7) {
			hodler.setViewBackgroundColor(R.id.item_gridview,
					Color.parseColor("#e2b73d"));
		} else if (position == 8) {
			hodler.setViewBackgroundColor(R.id.item_gridview,
					Color.parseColor("#c5c5f3"));
		}
		/*
		 * for(int i = 0 ;i<9;i++){//你先那样做吧 这个问题有待 研究 if(position==i){
		 * hodler.setViewBackgroundColor(R.id.item_gridview, bgs1[i]); }
		 * 
		 * }
		 */

		return hodler.getConvertView();
	}

}
