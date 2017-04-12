package zz.guojin.hongmi.bean;

import java.io.Serializable;
import java.util.List;

public class HelpWalletBean implements Serializable{

	@Override
	public String toString() {
		return "HelpWalletBean [error=" + error + ", data=" + data + "]";
	}
	private int error;
	private List<WalletData> data;
	public int getError() {
		return error;
	}
	public void setError(int error) {
		this.error = error;
	}
	public List<WalletData> getData() {
		return data;
	}
	public void setData(List<WalletData> data) {
		this.data = data;
	}
	public static class WalletData{
		private String ug_id;
		@Override
		public String toString() {
			return "WalletData [ug_id=" + ug_id + ", ug_gettime=" + ug_gettime + ", ug_note=" + ug_note + ", ug_allget=" + ug_allget + ", ug_money=" + ug_money + ", ug_balance=" + ug_balance + "]";
		}
		private String ug_gettime;
		private String ug_note;
		private String ug_allget;
		private String ug_money;
		private String ug_balance;
		public String getUg_id() {
			return ug_id;
		}
		public void setUg_id(String ug_id) {
			this.ug_id = ug_id;
		}
		public String getUg_gettime() {
			return ug_gettime;
		}
		public void setUg_gettime(String ug_gettime) {
			this.ug_gettime = ug_gettime;
		}
		public String getUg_note() {
			return ug_note;
		}
		public void setUg_note(String ug_note) {
			this.ug_note = ug_note;
		}
		public String getUg_allget() {
			return ug_allget;
		}
		public void setUg_allget(String ug_allget) {
			this.ug_allget = ug_allget;
		}
		public String getUg_money() {
			return ug_money;
		}
		public void setUg_money(String ug_money) {
			this.ug_money = ug_money;
		}
		public String getUg_balance() {
			return ug_balance;
		}
		public void setUg_balance(String ug_balance) {
			this.ug_balance = ug_balance;
		}

	}
}
