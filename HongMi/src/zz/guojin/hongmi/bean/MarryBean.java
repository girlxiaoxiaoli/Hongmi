package zz.guojin.hongmi.bean;

import java.util.List;

public class MarryBean {
	
	private int error;
	private List<Marry> data;
	
	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

	public List<Marry> getData() {
		return data;
	}

	public void setData(List<Marry> data) {
		this.data = data;
	}
		
	
	@Override
	public String toString() {
		return "MarryBean [error=" + error + ", data=" + data + "]";
	}


	public static class Marry{
//		  p_id  订单号
//		    jb  钱数
//		    p_user  帐号
//		    date   时间
//		    state  状态
		String id;
		String user;
		String jb;
		String date;
		String zt;
	
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getUser() {
			return user;
		}
		public void setUser(String user) {
			this.user = user;
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
		public String getZt() {
			return zt;
		}
		public void setZt(String zt) {
			this.zt = zt;
		}
		@Override
		public String toString() {
			return "Marry [id=" + id + ", user=" + user + ", jb=" + jb
					+ ", date=" + date + ", zt=" + zt + "]";
		}
		
		
		
		
		
	}
}
