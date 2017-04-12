package zz.guojin.hongmi.bean;

import java.io.Serializable;

public class SheDetailsBean  implements Serializable{

	public String error;
	public Data data;
	
	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	
	@Override
	public String toString() {
		return "SheDetailsBean [error=" + error + ", data=" + data + "]";
	}


	public class Data implements Serializable {
		
		String id;
		String jb;
		String date;
		String ue_account;
		String ue_truename;
		String phone;
		String yhmc;
		String yhzh;
		String zfb;
		String weixin;
		String ue_accname;
		String ue_phone;
		String pic;
		public String getPic() {
			return pic;
		}
		public void setPic(String pic) {
			this.pic = pic;
		}
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
		public String getUe_account() {
			return ue_account;
		}
		public void setUe_account(String ue_account) {
			this.ue_account = ue_account;
		}
		public String getUe_truename() {
			return ue_truename;
		}
		public void setUe_truename(String ue_truename) {
			this.ue_truename = ue_truename;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getYhmc() {
			return yhmc;
		}
		public void setYhmc(String yhmc) {
			this.yhmc = yhmc;
		}
		public String getYhzh() {
			return yhzh;
		}
		public void setYhzh(String yhzh) {
			this.yhzh = yhzh;
		}
		public String getZfb() {
			return zfb;
		}
		public void setZfb(String zfb) {
			this.zfb = zfb;
		}

		
		public String getWeixin() {
			return weixin;
		}
		public void setWeixin(String weixin) {
			this.weixin = weixin;
		}
		public String getUe_accname() {
			return ue_accname;
		}
		public void setUe_accname(String ue_accname) {
			this.ue_accname = ue_accname;
		}
		public String getUe_phone() {
			return ue_phone;
		}
		public void setUe_phone(String ue_phone) {
			this.ue_phone = ue_phone;
		}
		@Override
		public String toString() {
			return "Data [id=" + id + ", jb=" + jb + ", date=" + date
					+ ", ue_account=" + ue_account + ", ue_truename="
					+ ue_truename + ", phone=" + phone + ", yhmc=" + yhmc
					+ ", yhzh=" + yhzh + ", zfb=" + zfb + ", weixin=" + weixin
					+ ", ue_accname=" + ue_accname + ", ue_phone=" + ue_phone
					+ ", pic=" + pic + "]";
		}
		
		
	}
	
}
