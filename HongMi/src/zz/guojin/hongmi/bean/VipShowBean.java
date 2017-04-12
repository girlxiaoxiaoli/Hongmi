package zz.guojin.hongmi.bean;

import java.io.Serializable;

public class VipShowBean implements Serializable {

	@Override
	public String toString() {
		return "VipShow [error=" + error + ", data=" + data + "]";
	}
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
	public class Data  implements Serializable{
		
		@Override
		public String toString() {
			return "Data [pin=" + pin + ", ue_account=" + ue_account
					+ ", ue_phone=" + ue_phone + "]";
		}
		public String getPin() {
			return pin;
		}
		public void setPin(String pin) {
			this.pin = pin;
		}
		public String getUe_account() {
			return ue_account;
		}
		public void setUe_account(String ue_account) {
			this.ue_account = ue_account;
		}
		public String getUe_phone() {
			return ue_phone;
		}
		public void setUe_phone(String ue_phone) {
			this.ue_phone = ue_phone;
		}
		String pin;
		String ue_account;
		String ue_phone;
		
		
	}
	
	
}
