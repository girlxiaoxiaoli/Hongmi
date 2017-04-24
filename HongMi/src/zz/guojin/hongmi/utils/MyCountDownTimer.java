package zz.guojin.hongmi.utils;

import zz.guojin.hongmi.R;
import android.R.integer;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.widget.TextView;

public class MyCountDownTimer extends CountDownTimer {
	private TextView mTextView;
	private int type;

	public MyCountDownTimer(TextView textView, long millisInFuture,
			long countDownInterval, int type) {
		super(millisInFuture, countDownInterval);
		this.mTextView = textView;
		this.type = type;
	}

	@Override
	public void onFinish() {
		mTextView.setText("重新获取");
		mTextView.setClickable(true);// 按钮可点击
		mTextView.setBackgroundResource(R.drawable.bg_identify_code_normal);

	}

	@Override
	public void onTick(long millisUntilFinished) {
		mTextView.setClickable(false); // 不可点击
		ForegroundColorSpan span;
		if (type == 1) {
			long day = millisUntilFinished / 86400000;
			long hour = (millisUntilFinished - day * 86400000) / 3600000;
			long sed = (millisUntilFinished - day * 86400000 - hour * 3600000) / 60000;
			long mill = (millisUntilFinished - day * 86400000 - hour * 3600000 - sed * 60000) / 1000;
			mTextView.setText(day + "天" + hour + "时" + sed + "分" + mill + "秒");
			span = new ForegroundColorSpan(Color.WHITE);
		} else {
			mTextView.setText(millisUntilFinished / 1000 + "s可获取");
			mTextView.setBackgroundResource(R.drawable.bg_identify_code_press);

			span = new ForegroundColorSpan(Color.RED);
		}

		// 获取按钮上的文字
		SpannableString spannableString = new SpannableString(mTextView
				.getText().toString());

		/**
		 * public void setSpan(Object what, int start, int end, int flags) {
		 * 主要是start跟end，start是起始位置,无论中英文，都算一个。
		 * 从0开始计算起。end是结束位置，所以处理的文字，包含开始位置，但不包含结束位置。
		 */
		spannableString.setSpan(span, 0, 2, Spannable.SPAN_INCLUSIVE_EXCLUSIVE);
		mTextView.setText(spannableString);
	}

}
