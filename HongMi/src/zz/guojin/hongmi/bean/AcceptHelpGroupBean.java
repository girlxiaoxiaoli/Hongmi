package zz.guojin.hongmi.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AcceptHelpGroupBean implements Serializable{


	private int error;
    @Override
	public String toString() {
		return "AcceptHelpGroupBean [error=" + error + ", data=" + data + "]";
	}
	private List<DataBean> data;
    public static class DataBean {
        private String jid;
        @Override
		public String toString() {
			return "DataBean [jid=" + jid + ", jjb=" + jjb + ", jdate=" + jdate
					+ ", user_tjr=" + user_tjr + ", juser=" + juser
					+ ", jhone=" + jhone + ", zt=" + zt + "]";
		}
		private String jjb;
        private String jdate;
        private String user_tjr;
        private String juser;
        private String jhone;
        private String zt;
		public String getJid() {
			return jid;
		}
		public void setJid(String jid) {
			this.jid = jid;
		}
		public String getJjb() {
			return jjb;
		}
		public void setJjb(String jjb) {
			this.jjb = jjb;
		}
		public String getJdate() {
			return jdate;
		}
		public void setJdate(String jdate) {
			this.jdate = jdate;
		}
		public String getUser_tjr() {
			return user_tjr;
		}
		public void setUser_tjr(String user_tjr) {
			this.user_tjr = user_tjr;
		}
		public String getJuser() {
			return juser;
		}
		public void setJuser(String juser) {
			this.juser = juser;
		}
		public String getJhone() {
			return jhone;
		}
		public void setJhone(String jhone) {
			this.jhone = jhone;
		}
		public String getZt() {
			return zt;
		}
		public void setZt(String zt) {
			this.zt = zt;
		}
        
}
	public int getError() {
		return error;
	}
	public void setError(int error) {
		this.error = error;
	}
	public List<DataBean> getData() {
		return data;
	}
	public void setData(List<DataBean> data) {
		this.data = data;
	}
    
}
