package zz.guojin.hongmi.adapter;

import java.util.ArrayList;
import java.util.List;

import android.R.integer;
import android.content.Context;

public abstract class MyOutAdapter extends CommonAdapter {
	private List datas;
	private Context context;
	private int mLayoutId;

	public MyOutAdapter(Context context, int layoutId, List datas) {
		// TODO Auto-generated constructor stub
		super(context, layoutId, datas);
	}

	

}
