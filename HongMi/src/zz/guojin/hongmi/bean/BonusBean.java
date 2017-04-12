package zz.guojin.hongmi.bean;

import java.io.Serializable;
import java.util.List;

public class BonusBean implements Serializable{
//    "dtzt": "0",										是否放入
//    "ug_account": "admin@qq.com",
//    "ug_allget": "0",
//    "ug_balance": "0",
//    "ug_gettime": "2016-12-15 10:20:31",			        日期
//    "ug_id": "5385",                                 编号
//    "ug_money": "1",									收入/支出
//    "ug_note": "管理薪酬0.05%",							说明
//    "ug_qrtime": "2017-01-14 10:20:31"               放入时间
	private int error;
	private List<BeanData> data;
	
	@Override
	public String toString() {
		return "BonusBean [error=" + error + ", data=" + data + "]";
	}

	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

	public List<BeanData> getData() {
		return data;
	}

	public void setData(List<BeanData> data) {
		this.data = data;
	}

	public static class BeanData{
//		  UG_ID,  编号
//		   UG_money,  金额
//		   UG_getTime, 日期
//		  
//		   UG_note  说明
		private String  ug_id;
		private String dtzt;
		private String ug_gettime;
		private String ug_note;
		private String ug_money;
		private String ug_qrtime;
		public String getUg_id() {
			return ug_id;
		}
		public void setUg_id(String ug_id) {
			this.ug_id = ug_id;
		}
		public String getDtzt() {
			return dtzt;
		}
		public void setDtzt(String dtzt) {
			this.dtzt = dtzt;
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
		public String getUg_money() {
			return ug_money;
		}
		public void setUg_money(String ug_money) {
			this.ug_money = ug_money;
		}
		public String getUg_qrtime() {
			return ug_qrtime;
		}
		public void setUg_qrtime(String ug_qrtime) {
			this.ug_qrtime = ug_qrtime;
		}
		@Override
		public String toString() {
			return "BeanData [ug_id=" + ug_id + ", dtzt=" + dtzt
					+ ", ug_gettime=" + ug_gettime + ", ug_note=" + ug_note
					+ ", ug_money=" + ug_money + ", ug_qrtime=" + ug_qrtime
					+ "]";
		}
		
		
	}
}
