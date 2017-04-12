package zz.guojin.hongmi.bean;

import java.io.Serializable;
import java.util.List;

public class GiveOrderPdBean implements Serializable{

	private int error;
	public int getError() {
		return error;
	}
	public void setError(int error) {
		this.error = error;
	}
	public List<PdData> getData() {
		return data;
	}
	public void setData(List<PdData> data) {
		this.data = data;
	}
	private List<PdData> data;
	public static class PdData{
//// id  订单号
//	    jb  理财金额
//	    user  帐号
//	    date   时间  
//	    zt  状态
		private String id;
		private String jb;
		private String date;
		private String user;
		private String zt;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getJb() {
			return jb;
		}
		public void setJb(String jb) {
			this.jb = jb;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public String getUser() {
			return user;
		}
		public void setUser(String user) {
			this.user = user;
		}
		public String getZt() {
			return zt;
		}
		public void setZt(String zt) {
			this.zt = zt;
		}
		@Override
		public String toString() {
			return "PdData [id=" + id + ", jb=" + jb + ", date=" + date
					+ ", user=" + user + ", zt=" + zt + "]";
		}
		
	}
	@Override
	public String toString() {
		return "GiveOrderPdBean [error=" + error + ", data=" + data + "]";
	}
}
