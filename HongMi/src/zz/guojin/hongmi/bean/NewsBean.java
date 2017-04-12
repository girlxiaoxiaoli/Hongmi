package zz.guojin.hongmi.bean;

import java.util.List;

public class NewsBean {
	// if_theme： 新闻标题
	// if_time： 时间
	// if_content： 内容

	private int error;
	private List<NewsDataBean> data;

	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

	public List<NewsDataBean> getData() {
		return data;
	}

	public void setData(List<NewsDataBean> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Newbean [error=" + error + ", data=" + data + "]";
	}

	public static class NewsDataBean {
		String if_theme;
		String if_time;
		String if_content;
		public String getIf_theme() {
			return if_theme;
		}
		public void setIf_theme(String if_theme) {
			this.if_theme = if_theme;
		}
		public String getIf_time() {
			return if_time;
		}
		public void setIf_time(String if_time) {
			this.if_time = if_time;
		}
		public String getIf_content() {
			return if_content;
		}
		public void setIf_content(String if_content) {
			this.if_content = if_content;
		}
		@Override
		public String toString() {
			return "NewsDataBean [if_theme=" + if_theme + ", if_time="
					+ if_time + ", if_content=" + if_content + "]";
		}
		
	}

}
