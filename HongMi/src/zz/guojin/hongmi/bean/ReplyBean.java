package zz.guojin.hongmi.bean;

import java.util.List;

public class ReplyBean {
	// if_theme： 新闻标题
	// if_time： 时间
	// if_content： 内容

	private int error;
	private List<ReplyDataBean> data;

	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

	public List<ReplyDataBean> getData() {
		return data;
	}

	public void setData(List<ReplyDataBean> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Newbean [error=" + error + ", data=" + data + "]";
	}

	public static class ReplyDataBean {
		String ma_theme;
		String ma_replytime;
		String ma_reply;
		public String getMa_theme() {
			return ma_theme;
		}
		public void setMa_theme(String ma_theme) {
			this.ma_theme = ma_theme;
		}
		public String getMa_replytime() {
			return ma_replytime;
		}
		public void setMa_replytime(String ma_replytime) {
			this.ma_replytime = ma_replytime;
		}
		public String getMa_reply() {
			return ma_reply;
		}
		public void setMa_reply(String ma_reply) {
			this.ma_reply = ma_reply;
		}
		@Override
		public String toString() {
			return "ReplyDataBean [ma_theme=" + ma_theme + ", ma_replytime="
					+ ma_replytime + ", ma_reply=" + ma_reply + "]";
		}
		
	}

}
