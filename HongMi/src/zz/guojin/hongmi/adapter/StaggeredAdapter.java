package zz.guojin.hongmi.adapter;

import java.util.LinkedList;
import java.util.List;

import zz.guojin.hongmi.R;
import zz.guojin.hongmi.activity.GoodsInfoActivity;
import zz.guojin.hongmi.bean.GoodBean;
import zz.guojin.hongmi.utils.ImageFetcher;
import zz.guojin.hongmi.utils.MUrlUtil;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;



public class StaggeredAdapter extends BaseAdapter {
    private LinkedList<GoodBean> mInfos;
    ImageFetcher mImageFetcher;
    Context context;

    public StaggeredAdapter(Context context, ImageFetcher f,Context cont) {
        mInfos = new LinkedList<GoodBean>();
        mImageFetcher = f;
        this.context =cont ;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        final GoodBean duitangInfo = mInfos.get(position);

        if (convertView == null) {
            LayoutInflater layoutInflator = LayoutInflater.from(parent.getContext());
            convertView = layoutInflator.inflate(R.layout.infos_list, null);
            holder = new ViewHolder();
            holder.imageView = (ImageView) convertView.findViewById(R.id.news_pic);
            holder.contentView = (TextView) convertView.findViewById(R.id.news_title);
            convertView.setTag(holder);
        }
        holder = (ViewHolder) convertView.getTag();

        
//        float iHeight = ((float) 200 / 183 * duitangInfo.getHeight());
        holder.imageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 400));

        holder.contentView.setText(duitangInfo.getName());
        mImageFetcher.loadImage(MUrlUtil.base_url+duitangInfo.getImagepath(), holder.imageView);
        holder.imageView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String img =MUrlUtil.base_url +duitangInfo.getImagepath();
				String price = duitangInfo.getPrice();
				String content = duitangInfo.getContent();
			    String  id_goods = duitangInfo.getId();
				Intent intent = new Intent(context,GoodsInfoActivity.class);
				intent.putExtra("img", img);
				intent.putExtra("id", id_goods);
				intent.putExtra("content", content);
				intent.putExtra("price",price);
				context.startActivity(intent);
				
			}
		});
        
        return convertView;
    }

    class ViewHolder {
        ImageView imageView;
        TextView contentView;
        TextView timeView;
    }

    @Override
    public int getCount() {
//    	Log.d("1", "=====response=mInfos.size="+mInfos.size());
        return mInfos.size();
    }

    @Override
    public Object getItem(int arg0) {
        return mInfos.get(arg0);
    }

    @Override
    public long getItemId(int arg0) {
        return 0;
    }

    public void addItemLast(List<GoodBean> datas) {
        mInfos.addAll(datas);
        notifyDataSetChanged();
    }

    public void addItemTop(List<GoodBean> datas) {
    	mInfos.clear();
        for (GoodBean info : datas) {
            mInfos.addFirst(info);
        }
        notifyDataSetChanged();
    }
}
