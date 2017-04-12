package zz.guojin.hongmi.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OfferHelpGroupBean implements Serializable{


	@Override
	public String toString() {
		return "OfferHelpGroupBean [error=" + error + ", data=" + data + "]";
	}

	private int error;
	private List<DataBean> data;
    public static class DataBean {
        private String pdate;
        @Override
		public String toString() {
			return "DataBean [pdate=" + pdate + ", phone=" + phone + ", pid="
					+ pid + ", pjb=" + pjb + ", puser=" + puser + ", user_tjr="
					+ user_tjr + ", zt=" + zt + "]";
		}

		private String phone;
        private String pid;
        private String pjb;
        private String puser;
        private String user_tjr;
        private String zt;

        public String getPdate() {
            return pdate;
        }

        public void setPdate(String pdate) {
            this.pdate = pdate;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public String getPjb() {
            return pjb;
        }

        public void setPjb(String pjb) {
            this.pjb = pjb;
        }

        public String getPuser() {
            return puser;
        }

        public void setPuser(String puser) {
            this.puser = puser;
        }

        public String getUser_tjr() {
            return user_tjr;
        }

        public void setUser_tjr(String user_tjr) {
            this.user_tjr = user_tjr;
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
