package zz.guojin.hongmi.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import zz.guojin.hongmi.activity.LoginActivity;

public class ReLoginUtil {
	//退回到登陆界面
	
	public static void LoginAgain(Context context,Class<?> cls){
		new Thread() {
			public void run() {
				SystemClock.sleep(2000);
			};
		}.start();
		Intent logoutIntent = new Intent(context,
				LoginActivity.class);
		logoutIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK
				| Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(logoutIntent);
	}
	}

