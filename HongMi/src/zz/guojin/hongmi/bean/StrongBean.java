package zz.guojin.hongmi.bean;

import java.util.List;


public class StrongBean {
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public List<Databean> getData() {
		return data;
	}

	public void setData(List<Databean> data) {
		this.data = data;
	}

	String error;
	private List<Databean> data;
	
	@Override
	public String toString() {
		return "StrongBean [error=" + error + ", data=" + data + "]";
	}

	public static class Databean{
		String id;
		String jb;
		String y_user;
		String inter;
		String status;
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
		public String getY_user() {
			return y_user;
		}
		public void setY_user(String y_user) {
			this.y_user = y_user;
		}
		public String getInter() {
			return inter;
		}
		public void setInter(String inter) {
			this.inter = inter;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		@Override
		public String toString() {
			return "Databean [id=" + id + ", jb=" + jb + ", y_user=" + y_user
					+ ", inter=" + inter + ", status=" + status + "]";
		}
			
	}
}
