package zz.guojin.hongmi.utils;

import android.content.Context;
import android.os.IBinder;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class UiUtils {

	public Context ctx;
	public UiUtils(Context ctx){
		this.ctx = ctx;
	}
//隐藏软键盘 方法一
//	public static void hideKeyboard(View v,Context ctx) {
//		InputMethodManager imm = (InputMethodManager)v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
//		if (imm.isActive()) {
//			
//			imm.hideSoftInputFromWindow(v.getApplicationWindowToken(), 0);
//		}
//	}
	 /**
     * 多种隐藏软件盘方法的其中一种
     * 
     * @param token
     */
    public static void hideSoftInput(IBinder token, InputMethodManager im) {
        if (token != null) {
            im.hideSoftInputFromWindow(token,
                    InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
	//隐藏软键盘 方法二
	 public static boolean isShouldHideInput(View v, MotionEvent event) {
	        if (v != null && (v instanceof EditText)) {
	            int[] l = { 0, 0 };
	            v.getLocationInWindow(l);
	            int left = l[0], top = l[1], bottom = top + v.getHeight(), right = left
	                    + v.getWidth();
	            if (event.getX() > left && event.getX() < right
	                    && event.getY() > top && event.getY() < bottom) {
	                // 点击EditText的事件，忽略它。
	                return false;
	            } else {
	                // hideSoftInput(v.getWindowToken());
	                return true;
	            }
	        }
	        // 如果焦点不是EditText则忽略，这个发生在视图刚绘制完，第一个焦点不在EditView上，和用户用轨迹球选择其他的焦点
	        return false;
	    }
}
