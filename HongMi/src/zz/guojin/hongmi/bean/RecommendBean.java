package zz.guojin.hongmi.bean;

import java.io.Serializable;
import java.util.List;

public class RecommendBean implements Serializable {

	private int error;
	private String num;

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "RecommendBean [error=" + error + ", num=" + num + ", data="
				+ data + "]";
	}

	private List<RecommendData> data;

	public List<RecommendData> getData() {
		return data;
	}

	public void setData(List<RecommendData> data) {
		this.data = data;
	}

	public static class RecommendData {
		private String ue_id;
		private String ue_account;
		private String ue_accname;
		private String zcr;
		private String ue_phone;
		private String ue_regtime;
		private String ue_theme;

		// ue_id
		// ue_account 用户名
		// ue_theme 昵称
		// ue_phone 手机号
		// num 下级人数

		public String getUe_theme() {
			return ue_theme;
		}

		public void setUe_theme(String ue_theme) {
			this.ue_theme = ue_theme;
		}

		public String getUe_id() {
			return ue_id;
		}

		public void setUe_id(String ue_id) {
			this.ue_id = ue_id;
		}

		public String getUe_account() {
			return ue_account;
		}

		public void setUe_account(String ue_account) {
			this.ue_account = ue_account;
		}

		public String getUe_accname() {
			return ue_accname;
		}

		public void setUe_accname(String ue_accname) {
			this.ue_accname = ue_accname;
		}

		public String getZcr() {
			return zcr;
		}

		public void setZcr(String zcr) {
			this.zcr = zcr;
		}

		public String getUe_phone() {
			return ue_phone;
		}

		public void setUe_phone(String ue_phone) {
			this.ue_phone = ue_phone;
		}

		public String getUe_regtime() {
			return ue_regtime;
		}

		public void setUe_regtime(String ue_regtime) {
			this.ue_regtime = ue_regtime;
		}

		@Override
		public String toString() {
			return "RecommendData [ue_id=" + ue_id + ", ue_theme="
					+ ue_theme + ", ue_account=" + ue_account
					+ ", ue_accname=" + ue_accname + ", zcr=" + zcr
					+ ", ue_phone=" + ue_phone + ", ue_regtime=" + ue_regtime
					+ "]";
		}

	}
}
