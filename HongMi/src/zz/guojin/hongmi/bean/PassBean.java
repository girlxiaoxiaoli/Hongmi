package zz.guojin.hongmi.bean;

import java.util.List;



public class PassBean {

	private int error;
	private List<Passed> data;
	
	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

	public List<Passed> getData() {
		return data;
	}

	public void setData(List<Passed> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "PassBean [error=" + error + ", data=" + data + "]";
	}

	public static class Passed{
		
		String ue_account;
		String ue_id;
		String ue_phone;
		String ue_regtime;
		String ue_truename;
		String ue_status;
		
		public String getUe_status() {
			return ue_status;
		}
		public void setUe_status(String ue_status) {
			this.ue_status = ue_status;
		}
		public String getUe_account() {
			return ue_account;
		}
		public void setUe_account(String ue_account) {
			this.ue_account = ue_account;
		}
		public String getUe_id() {
			return ue_id;
		}
		public void setUe_id(String ue_id) {
			this.ue_id = ue_id;
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
		public void setUe_regtime(String ue_regtim) {
			this.ue_regtime = ue_regtime;
		}
		
		public String getUe_truename() {
			return ue_truename;
		}
		public void setUe_truename(String ue_truename) {
			this.ue_truename = ue_truename;
		}
		@Override
		public String toString() {
			return "Passed [ue_account=" + ue_account + ", ue_id=" + ue_id
					+ ", ue_phone=" + ue_phone + ", ue_regtime=" + ue_regtime
					+ ", ue_truename=" + ue_truename + ", ue_status="
					+ ue_status + "]";
		}
		
		

		
		
	}
}
