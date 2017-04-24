package zz.guojin.hongmi.activity;
import com.google.gson.Gson;
import com.yolanda.nohttp.NoHttp;
import com.yolanda.nohttp.RequestMethod;
import com.yolanda.nohttp.rest.OnResponseListener;
import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.RequestQueue;
import com.yolanda.nohttp.rest.Response;

import zz.guojin.hongmi.bean.RuquestBean;
import zz.guojin.hongmi.utils.AppManager;
import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
public class OutActivity extends Activity implements OnClickListener {

	private ArrayAdapter adapter; //存放数据
	//spinner当前显示的条目
	private int codePointAt;
	private String cardString;
//	@Bind(R.id.spi)
	Spinner spinnerst;
//	@Bind(R.id.et_lynr1)
	EditText ed;
	Button qunren;
	private RequestQueue queue;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		AppManager.getInstance().addActivity(this);
		setContentView(R.layout.outfragment);
		spinnerst =(Spinner)findViewById(R.id.spi);
		ed =(EditText)findViewById(R.id.et_lynr1);
		qunren =(Button) findViewById(R.id.but_qunr);
		qunren.setOnClickListener(this);
		queue = NoHttp.newRequestQueue();
		getSpinnerst();
	}

	private void getSpinnerst() {

	    //将可选内容与ArrayAdapter连接，
//	    adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, m_Countries);
	    //将adapter添加到m_Spinner中
//	    spinnerCardNumber.setAdapter(adapter);
//	    到这里，就完成了下拉框的绑定数据，下拉框中已经有我们想要选择的值了。下面获取选择的值。
	    //添加Spinner事件监听
		spinnerst.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
		@Override
	    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long arg3) {
//	    String cardNumber = m_Countries[arg2];
	    	//当前显示的条目字符串
	    cardString = getResources().getStringArray(R.array.spingarr)[position];	   
	    codePointAt = cardString.codePointAt(position);
	    System.out.println(codePointAt+" 看看点击的是条目还是下标...");
	    	 //设置显示当前选择的项
	    arg0.setVisibility(View.VISIBLE);
	    }
	   @Override
	   public void onNothingSelected(AdapterView<?> arg0) {
	    // TODO Auto-generated method stub
	    }
	    });
		
	
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub		
		String number = cardString.toString().trim();
		String trim = ed.getText().toString().trim();
		Request<String> request = NoHttp.createStringRequest(MUrlUtil.BASE_URL+MUrlUtil.TX_CODE, RequestMethod.GET);
		request.add("zhflag", codePointAt);
		request.add("PickupCount", trim);
		queue.add(188, request, rResponseListener);
		
	}
	OnResponseListener<String> rResponseListener = new OnResponseListener<String>() {
		//请求成功
		@Override
		public void onSucceed(int what, Response<String> response) {
			// TODO Auto-generated method stub
			if (what==188) {
				String infos = response.get();
				Gson gson = new Gson();
				RuquestBean fjss = gson.fromJson(infos, RuquestBean.class);
				if ("1".equals(fjss.getError())) {
					Toast.makeText(getApplicationContext(), fjss.getMsg(), 0).show();
					return;
				}else {
					Toast.makeText(getApplicationContext(), fjss.getMsg(), 0).show();
					return;
			}
		}
		}
		@Override
		public void onStart(int what) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void onFinish(int what) {
			// TODO Auto-generated method stub
			
		}
		
		
		@Override
		public void onFailed(int what, Response<String> response) {
			// TODO Auto-generated method stub
			
		}
	};

}
