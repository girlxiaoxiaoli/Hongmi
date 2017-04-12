package zz.guojin.hongmi.utils;

import java.util.Map;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

public class JumpUtil {

	private Context context;
	public JumpUtil(Context context){
		this.context = context;
	}
	//在非activity页面中跳转页面的方法   传入上下文和要跳进的activity的class
		public static void JumpActivity(Context context,Class<?> cls){
			Intent intent = new Intent(context,cls);
			context.startActivity(intent); 
		}
		public static void jumpToActivity(Context context, Class<? > cls, Bundle bundle) {
	        Intent intent = new Intent(context, cls);
	        if (bundle != null)
	            intent.putExtras(bundle);
	        context.startActivity(intent);
	    }
}
