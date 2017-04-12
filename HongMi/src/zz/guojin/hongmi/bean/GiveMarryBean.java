package zz.guojin.hongmi.bean;

import java.util.List;

public class GiveMarryBean {
	
	private int error;
	private List<GiveMarry> data;
	
	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

	public List<GiveMarry> getData() {
		return data;
	}

	public void setData(List<GiveMarry> data) {
		this.data = data;
	}
		
	
	@Override
	public String toString() {
		return "MarryBean [error=" + error + ", data=" + data + "]";
	}


	public static class GiveMarry{
//		":[{"id":"354"," +
//				""user":"admin@qq.com","jb":"4000","date":"2017-04-01 16:55:58","zt":"已匹配"},{"
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
			return "GiveMarry [id=" + id + ", user=" + user + ", jb=" + jb
					+ ", date=" + date + ", zt=" + zt + "]";
		}
		
		
		
		
	}
}
