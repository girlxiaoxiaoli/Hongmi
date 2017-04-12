package zz.guojin.hongmi.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class NetUtils {
	//判断网络可用不可用
	public static boolean checkNet(Context context) {
		if (context != null) {
            ConnectivityManager mConnectivityManager = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
           
            NetworkInfo mWiFiNetworkInfo = mConnectivityManager
                    .getActiveNetworkInfo();
            if (mWiFiNetworkInfo != null) {
            	System.out.println("网络连接——————/"+mWiFiNetworkInfo.isAvailable());
                return mWiFiNetworkInfo.isAvailable();
            }
        }
        return false;
	}
}
