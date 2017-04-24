package zz.guojin.hongmi.activity;

import zz.guojin.hongmi.R;
import zz.guojin.hongmi.R.layout;
import zz.guojin.hongmi.R.menu;
import zz.guojin.hongmi.utils.AppManager;
import zz.guojin.hongmi.utils.MUrlUtil;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
/**
 * 管理账号
 * @author Administrator
 *
 */
public class AdministratorAccount extends BaseActivity implements OnClickListener{
	private ImageView goback;
	private TextView title;
	private WebView webView;
	private Context context;
	

	@Override
	public int getLayoutResId() {
		// TODO Auto-generated method stub
		return R.layout.activity_administrator_account;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		context = this;
		AppManager.getInstance().addActivity(this);
	}

	@Override
	public void initView() {
		// TODO Auto-generated method stub
		goback = (ImageView) findViewById(R.id.img_back);
		title = (TextView) findViewById(R.id.title_main);
		webView = (WebView) findViewById(R.id.webview);
		title.setText("管理账户");
	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub
		goback .setOnClickListener(this);
		
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub
		webView.loadUrl(MUrlUtil.BASE_URL+MUrlUtil.ADMIN_ACCOUNT);

		WebSettings webSettings = webView.getSettings();
		webSettings.setJavaScriptEnabled(true);//支持js
		webSettings.setSupportZoom(true);//不支持缩放
		
	}

	@Override
	public void toStartProgressDialog() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doWhatForRequest(int what, String info) {
		// TODO Auto-generated method stub
		
	}
@Override
public void onDestroy() {
	// TODO Auto-generated method stub
	super.onDestroy();
	webView.destroy();
}

@Override
public void onClick(View v) {
	// TODO Auto-generated method stub
	AppManager.getInstance().killActivity(this);
}
	
}
