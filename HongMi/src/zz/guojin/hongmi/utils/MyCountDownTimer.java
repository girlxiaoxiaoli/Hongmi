package zz.guojin.hongmi.utils;

import zz.guojin.hongmi.R;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

public class MyCountDownTimer extends CountDownTimer {
	 private TextView mTextView;  
	 public MyCountDownTimer(TextView textView, long millisInFuture, long countDownInterval) {  
	        super(millisInFuture, countDownInterval);  
	        this.mTextView = textView;  
	    }  
	  
	@Override
	public void onFinish() {
		    mTextView.setText("重新获取");  
	        mTextView.setClickable(true);//按钮可点击
	        mTextView.setBackgroundResource(R.drawable.bg_identify_code_normal);
	        
	}

	@Override
	public void onTick(long millisUntilFinished) {
		    mTextView.setClickable(false); //不可点击
	        mTextView.setText(millisUntilFinished / 1000 + "s可获取");  
	        mTextView.setBackgroundResource(R.drawable.bg_identify_code_press); 
	       //获取按钮上的文字
	        SpannableString spannableString = new SpannableString(mTextView.getText().toString());
	        ForegroundColorSpan span = new ForegroundColorSpan(Color.RED);  
	        /** 
	         * public void setSpan(Object what, int start, int end, int flags) { 
	         * 主要是start跟end，start是起始位置,无论中英文，都算一个。 
	         * 从0开始计算起。end是结束位置，所以处理的文字，包含开始位置，但不包含结束位置。 
	         */  
	        spannableString.setSpan(span, 0, 2, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);//������ʱ��ʱ������Ϊ��ɫ  
	        mTextView.setText(spannableString);  
	}
	  
}
