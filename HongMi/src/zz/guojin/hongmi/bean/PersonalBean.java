package zz.guojin.hongmi.bean;

import java.io.Serializable;


public class PersonalBean implements Serializable {
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


	String error;
	public Data data;
	
	
	@Override
	public String toString() {
		return "Personal [error=" + error + ", data=" + data + "]";
	}


	public class Data  implements Serializable{
		String  ue_accname; //上级账号
		String  ue_account;//账号
		String  ue_truename;//真实姓名
		String yhmc;//银行名称
		String  weixin;//微信
		String  zfb;//支付宝
		String  ue_qq; //qq
		String  ue_phone;//手机号
		String yhzh;//银行账号
		String zhxm;//开户人
		public String getUe_qq() {
			return ue_qq;
		}
		public void setUe_qq(String ue_qq) {
			this.ue_qq = ue_qq;
		}
		
		public String getZhxm() {
			return zhxm;
		}
		public void setZhxm(String zhxm) {
			this.zhxm = zhxm;
		}
		public String getYhzh() {
			return yhzh;
		}
		public void setYhzh(String yhzh) {
			this.yhzh = yhzh;
		}
		public String getUe_accname() {
			return ue_accname;
		}
		public void setUe_accname(String ue_accname) {
			this.ue_accname = ue_accname;
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
		
		public String getYhmc() {
			return yhmc;
		}
		public void setYhmc(String yhmc) {
			this.yhmc = yhmc;
		}
		public String getWeixin() {
			return weixin;
		}
		public void setWeixin(String weixin) {
			this.weixin = weixin;
		}
		public String getZfb() {
			return zfb;
		}
		public void setZfb(String zfb) {
			this.zfb = zfb;
		}
	
		public String getUe_phone() {
			return ue_phone;
		}
		public void setUe_phone(String ue_phone) {
			this.ue_phone = ue_phone;
		}
		@Override
		public String toString() {
			return "Data [ue_accname=" + ue_accname + ", ue_account="
					+ ue_account + ", ue_truename=" + ue_truename + ", yhmc="
					+ yhmc + ", weixin=" + weixin + ", zfb=" + zfb + ", ue_qq="
					+ ue_qq + ", ue_phone=" + ue_phone + ", yhzh=" + yhzh
					+ ", zhxm=" + zhxm + "]";
		}
		
	}
	
}
