package zz.guojin.hongmi.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.Spanned;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class ViewHodler {
	private Context context;
	private SparseArray<View> mViews;
	private View mconvertView;
	private int mPosition;


	public ViewHodler(Context context, ViewGroup parent, int layoutId,
			int position) {
		this.mPosition = position;
		this.mViews = new SparseArray<View>();
		mconvertView = LayoutInflater.from(context).inflate(layoutId, parent,
				false);
		mconvertView.setTag(this);
	}

	public static ViewHodler get(Context context, View convertView,
			ViewGroup parent, int layoutId, int position) {
		if (convertView == null) {

			return new ViewHodler(context, parent, layoutId, position);
		} else {
			ViewHodler hodler = (ViewHodler) convertView.getTag();
			hodler.mPosition=position;
			return hodler;
		}
	}
/**
 * 根据viewId获取view 
 * @param ViewId
 * @return
 */
	public <T extends View> T getView(int ViewId) {
		View view = mViews.get(ViewId);
		if (view == null) {
			view = mconvertView.findViewById(ViewId);
			mViews.put(ViewId, view);
		}
		return (T) view;
	}
/**
 * 获取convertview
 * @return
 */
	public View getConvertView() {
		return mconvertView;
	}
	/**
	 * textView 填写显示内容
	 * @param viewId
	 * @param text
	 * @return
	 */
	public ViewHodler setText(int viewId,String text){
		View tView = getView(viewId);
		if(tView instanceof TextView){
			((TextView) tView).setText(text);
		}else if(tView instanceof EditText){
			((EditText) tView).setText(text);
		}else if(tView instanceof Button){
			((Button) tView).setText(text);
		}	
		return this;
	}
	/**
	 * 是否显示
	 * @param viewId
	 * @param isGone
	 * @return
	 */
	public ViewHodler setViewVisibility(int viewId,Boolean isVisible){
		View tView = getView(viewId);
		if(isVisible){
			tView.setVisibility(View.VISIBLE);
		}else{
			tView.setVisibility(View.GONE);
		}
		
		return this;
	}
	
	public ViewHodler setImageBitmap(int viewId,Bitmap bitmap){
		ImageView imageView = getView(viewId);
		imageView.setImageBitmap(bitmap);
		return this;
	}
	public ViewHodler setImageUrl(int viewId ,String url){
		ImageView imageView = getView(viewId);
		//TODO 网络加载图片
		
		return this;
	}
	public ViewHodler setImageBackgroundResource(int viewId,int imgResId){
		View view = getView(viewId);
		if(view instanceof TextView)
			((TextView) view).setBackgroundResource(imgResId);
			else if(view instanceof Button)
				((Button) view).setBackgroundResource(imgResId);
			else if(view instanceof EditText)
				((Button) view).setBackgroundResource(imgResId);
			else if(view instanceof LinearLayout)
				((LinearLayout) view).setBackgroundResource(imgResId);
			else if(view instanceof RelativeLayout)
				((RelativeLayout) view).setBackgroundResource(imgResId);
			else if(view instanceof ImageView)
				((ImageView) view).setBackgroundResource(imgResId);
			
		return this;
	}
	
	public ViewHodler setViewOnClickListener(int viewId,OnClickListener listener){
		this.getView(viewId).setOnClickListener(listener);
		return this;
	}
	//设置背景色
	public ViewHodler setViewBackgroundColor(int viewId,int color){
		View view = getView(viewId);
		if(view instanceof TextView)
			((TextView) view).setBackgroundColor(color);
			else if(view instanceof Button)
				((Button) view).setBackgroundColor(color);
			else if(view instanceof EditText)
				((Button) view).setBackgroundColor(color);
			else if(view instanceof LinearLayout)
				((LinearLayout) view).setBackgroundColor(color);
			else if(view instanceof RelativeLayout)
				((RelativeLayout) view).setBackgroundColor(color);
			else if(view instanceof ImageView)
				((ImageView) view).setBackgroundColor(color);
		
		return this;
	}
	
	public ViewHodler setTextColor(int viewId,int color){
		View tView = getView(viewId);
		if(tView instanceof TextView)
		((TextView) tView).setTextColor(color);
		else if(tView instanceof Button)
			((Button) tView).setTextColor(color);
		else if(tView instanceof EditText)
			((EditText) tView).setTextColor(color);
		return this;
	}
//填充html字段
	public ViewHodler setText(int viewId, Spanned fromHtml) {
		// TODO Auto-generated method stub
		View tView = getView(viewId);
		if(tView instanceof TextView){
			((TextView) tView).setText(fromHtml);
		}else if(tView instanceof EditText){
			((EditText) tView).setText(fromHtml);
		}else if(tView instanceof Button){
			((Button) tView).setText(fromHtml);
		}	
		return this;
	}
	
	
}
