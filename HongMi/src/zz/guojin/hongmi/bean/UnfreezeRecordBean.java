package zz.guojin.hongmi.bean;

import java.util.List;

public class UnfreezeRecordBean {
	String error;
	List<DataBean> data;
	public static class DataBean{
//		   ug_id  编号
//		   ug_account  帐号
//		   ug_gettime 冻结时间
//		   jd_date  解冻时间
		private String ug_id;
		   private String ug_account;
		   private String ug_gettime;
		   private String jd_date;
		public String getUg_id() {
			return ug_id;
		}
		public void setUg_id(String ug_id) {
			this.ug_id = ug_id;
		}
		public String getUg_account() {
			return ug_account;
		}
		public void setUg_account(String ug_account) {
			this.ug_account = ug_account;
		}
		public String getUg_gettime() {
			return ug_gettime;
		}
		public void setUg_gettime(String ug_gettime) {
			this.ug_gettime = ug_gettime;
		}
		public String getJd_date() {
			return jd_date;
		}
		public void setJd_date(String jd_date) {
			this.jd_date = jd_date;
		}
		@Override
		public String toString() {
			return "DataBean [ug_id=" + ug_id + ", ug_account=" + ug_account
					+ ", ug_gettime=" + ug_gettime + ", jd_date=" + jd_date
					+ "]";
		}
		   
		   
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public List<DataBean> getData() {
		return data;
	}
	public void setData(List<DataBean> data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return "UnfreezeRecordBean [error=" + error + ", data=" + data + "]";
	}
	

}
