package zz.guojin.hongmi.fragment;

import java.util.HashMap;
import java.util.Map;

import zz.guojin.hongmi.activity.LoginActivity;
import zz.guojin.hongmi.bean.RuquestBean;
import zz.guojin.hongmi.utils.MUrlUtil;
import zz.guojin.hongmi.utils.NetUtils;
import zz.guojin.hongmi.utils.ReLoginUtil;
import zz.guojin.hongmi.utils.ToastUtils;
import zz.guojin.hongmi.R;
import android.app.ProgressDialog;

import android.text.TextUtils;

import android.view.View;
import android.view.View.OnClickListener;

import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.gson.Gson;

import com.yolanda.nohttp.rest.Request;
import com.yolanda.nohttp.rest.RequestQueue;
import com.yolanda.nohttp.rest.Response;

public class ContactFragment extends BaseFragment2 implements OnClickListener {

	private ArrayAdapter adapter; // 存放数据
	// spinner当前显示的条目
	private String cardString;
	// private Spinner spinnerCardNumber;
	Spinner spinnerCardNumber;
	EditText lybt1;
	EditText lynr1;
	LinearLayout ll_my_contact;
	Button but_tij;
	private RequestQueue queue;
	private ProgressDialog pd;
	private String lybt;
	private String lynr;
	private Request<String> request;

	private void getSpinnerCardNumber() {
		// 将可选内容与ArrayAdapter连接，
		// adapter = new ArrayAdapter<String>(getActivity(),
		// android.R.layout.simple_spinner_item, m_Countries);
		// 将adapter添加到m_Spinner中
		// spinnerCardNumber.setAdapter(adapter);
		// 到这里，就完成了下拉框的绑定数据，下拉框中已经有我们想要选择的值了。下面获取选择的值。
		// 添加Spinner事件监听
		spinnerCardNumber
				.setOnItemSelectedListener(new Spinner.OnItemSelectedListener() {
					@Override
					public void onItemSelected(AdapterView<?> arg0, View arg1,
							int position, long arg3) {
						// String cardNumber = m_Countries[arg2];
						// 当前显示的条目字符串
						cardString = getActivity().getResources()
								.getStringArray(R.array.spingarr)[position];
						// 设置显示当前选择的项
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
		if (!NetUtils.checkNet(getActivity())) {
			ToastUtils.showTextToast(getActivity(), "网络连接不可用");
			return;
		}
		String otlylx = cardString.toString().trim();
		lybt = lybt1.getText().toString().trim();
		lynr = lynr1.getText().toString().trim();
		if (TextUtils.isEmpty(lybt) || TextUtils.isEmpty(lynr)) {
			ToastUtils.showTextToast(getActivity(), "内容不能为空");
			return;
		}
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("otlylx", otlylx);
		params.put("lybt", lybt);
		params.put("lynr", lynr);

		ToRequestUrl(request, TAG, MUrlUtil.BASE_URL + MUrlUtil.TOUCH, params,
				-1, -1, 300);

	}

	@Override
	public int getLayoutResId() {
		// TODO Auto-generated method stub
		return R.layout.frag_contact_us;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
	}

	@Override
	public void initView() {
		// TODO Auto-generated method stub

		spinnerCardNumber = (Spinner) rootView.findViewById(R.id.spi);

		lybt1 = (EditText) rootView.findViewById(R.id.et_lybt1);
		lynr1 = (EditText) rootView.findViewById(R.id.et_lynr1);
		ll_my_contact = (LinearLayout) rootView
				.findViewById(R.id.ll_my_contact);
		but_tij = (Button) rootView.findViewById(R.id.but_tij);
	}

	@Override
	public void initListener() {
		// TODO Auto-generated method stub
		but_tij.setOnClickListener(this);
		getSpinnerCardNumber();
	
	}

	@Override
	public void initData() {
		// TODO Auto-generated method stub

	}

	@Override
	public void toStartProgressDialog() {
		// TODO Auto-generated method stub
		toStartProgressDialg(true);

	}

	@Override
	public void doWhatForRequest(int what, String info) {
		// TODO Auto-generated method stub
		if (what == 300) {
			Gson gson = new Gson();
			RuquestBean rqt = gson.fromJson(info, RuquestBean.class);
			ToastUtils.showTextToast(getActivity(), rqt.getMsg());
			if ("1".equals(rqt.getError())) {

				lybt1.setText("");
				lynr1.setText("");
				return;
			} else if ("0".equals(rqt.getError())) {
				return;
			} else if ("3".equals(rqt.getError())) {
				ReLoginUtil.LoginAgain(getActivity(), LoginActivity.class);
				return;
			}
		}
	}

}
