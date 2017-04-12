package zz.guojin.hongmi.bean;

import java.io.Serializable;
import java.util.List;

public class EndSingleBean implements Serializable{
	/*"
	 *   "id": "761",
            "inter": 700,
            "jb": "2000",
            "sta": "不可提现",
            "status": "匹配成功",
            "tg_day": "0"*/
	private int error;
	@Override
	public String toString() {
		return "EndSingleBean [error=" + error + ", data=" + data + "]";
	}

	private List<EndData> data;
	public int getError() {
		return error;
	}
	public void setError(int error) {
		this.error = error;
	}
	public List<EndData> getData() {
		return data;
	}
	public void setData(List<EndData> data) {
		this.data = data;
	}

	public static class  EndData{
		private String id;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getInter() {
			return inter;
		}
		public void setInter(String inter) {
			this.inter = inter;
		}
		public String getJb() {
			return jb;
		}
		public void setJb(String jb) {
			this.jb = jb;
		}
		public String getSta() {
			return sta;
		}
		public void setSta(String sta) {
			this.sta = sta;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		private String inter;
		private String jb;
		private String sta;
		private String status;
		private String tg_day ;
		public String getTg_day() {
			return tg_day;
		}
		public void setTg_day(String tg_day) {
			this.tg_day = tg_day;
		}
		@Override
		public String toString() {
			return "EndData [id=" + id + ", inter=" + inter + ", jb=" + jb
					+ ", sta=" + sta + ", status=" + status + ", tg_day="
					+ tg_day + "]";
		}
	}
}
