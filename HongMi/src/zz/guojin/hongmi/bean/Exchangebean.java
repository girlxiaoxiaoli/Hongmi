package zz.guojin.hongmi.bean;

import java.util.List;

public class Exchangebean {

	private int error;
	private List<ExchangeDataBean> data;

	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

	public List<ExchangeDataBean> getData() {
		return data;
	}

	public void setData(List<ExchangeDataBean> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Exchangebean [error=" + error + ", data=" + data + "]";
	}

	public static class ExchangeDataBean {
	String ug_money;
	String ug_note;
	String ug_gettime;
	String ug_account;
	String ug_othraccount;
	String ug_id;
public String getUg_id() {
		return ug_id;
	}
	public void setUg_id(String ug_id) {
		this.ug_id = ug_id;
	}
	//	ug_account  转让方
//	ug_othraccount  接受方
//	ug_money  数量 
//	ug_gettime  时间 
//	ug_note  备注
	public String getUg_money() {
		return ug_money;
	}
	public void setUg_money(String ug_money) {
		this.ug_money = ug_money;
	}
	public String getUg_note() {
		return ug_note;
	}
	public void setUg_note(String ug_note) {
		this.ug_note = ug_note;
	}
	public String getUg_gettime() {
		return ug_gettime;
	}
	public void setUg_gettime(String ug_gettime) {
		this.ug_gettime = ug_gettime;
	}
	public String getUg_account() {
		return ug_account;
	}
	public void setUg_account(String ug_account) {
		this.ug_account = ug_account;
	}
	public String getUg_othraccount() {
		return ug_othraccount;
	}
	public void setUg_othraccount(String ug_othraccount) {
		this.ug_othraccount = ug_othraccount;
	}
	@Override
	public String toString() {
		return "ExchangeDataBean [ug_money=" + ug_money + ", ug_note="
				+ ug_note + ", ug_gettime=" + ug_gettime + ", ug_account="
				+ ug_account + ", ug_othraccount=" + ug_othraccount
				+ ", ug_id=" + ug_id + "]";
	}
	
}
}