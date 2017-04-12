package zz.guojin.hongmi.bean;

import java.util.List;

public class OfferPurseBean {
//提供帮助钱包
//	编号：		id
//	日期：		date
//	说明：		note
//	金额：		jb
//	利息：		inter
//	天数：		dday
//	操作：		play
//	匹配编号：	r_id
	private int error;
	private List<PurseBean> data;
	@Override
	public String toString() {
		return "OfferPurseBean [error=" + error + ", data=" + data + "]";
	}
	public int getError() {
		return error;
	}
	public void setError(int error) {
		this.error = error;
	}
	public List<PurseBean> getData() {
		return data;
	}
	public void setData(List<PurseBean> data) {
		this.data = data;
	}
	public static class PurseBean{
//		 id  编号
//		  jb  金额
//		  dday 天数
//		  inter 利息
		private String id;
		private String jb;
		private String inter;
		private String dday;
		private String play;
		private String date;
		
		@Override
		public String toString() {
			return "PurseBean [id=" + id + ", jb=" + jb + ", inter=" + inter
					+ ", dday=" + dday + ", play=" + play + ", date=" + date
					+ "]";
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
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
		public String getInter() {
			return inter;
		}
		public void setInter(String inter) {
			this.inter = inter;
		}
		public String getDday() {
			return dday;
		}
		public void setDday(String dday) {
			this.dday = dday;
		}
		public String getPlay() {
			return play;
		}
		public void setPlay(String play) {
			this.play = play;
		}
		
	}
}
