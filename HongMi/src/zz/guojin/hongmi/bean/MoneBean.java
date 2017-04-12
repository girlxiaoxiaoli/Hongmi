package zz.guojin.hongmi.bean;


public class MoneBean {

	public String error;
	public Data data;
	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}
	
	public class Data {
		

		 String	tj_he;
		 String	ue_pdb;
		 String  coun;
		 String	ue_money;
		 String chuju ;
		 String glj ;
		 String gpb;
		 String laomi;
		 String lixi;
		 String xnb;
		 String yunbi;
		public String getTj_he() {
			return tj_he;
		}
		public void setTj_he(String tj_he) {
			this.tj_he = tj_he;
		}
		public String getUe_pdb() {
			return ue_pdb;
		}
		public void setUe_pdb(String ue_pdb) {
			this.ue_pdb = ue_pdb;
		}
		public String getCoun() {
			return coun;
		}
		public void setCoun(String coun) {
			this.coun = coun;
		}
		public String getUe_money() {
			return ue_money;
		}
		public void setUe_money(String ue_money) {
			this.ue_money = ue_money;
		}
		public String getChuju() {
			return chuju;
		}
		public void setChuju(String chuju) {
			this.chuju = chuju;
		}
		public String getGlj() {
			return glj;
		}
		public void setGlj(String glj) {
			this.glj = glj;
		}
		public String getGpb() {
			return gpb;
		}
		public void setGpb(String gpb) {
			this.gpb = gpb;
		}
		public String getLaomi() {
			return laomi;
		}
		public void setLaomi(String laomi) {
			this.laomi = laomi;
		}
		public String getLixi() {
			return lixi;
		}
		public void setLixi(String lixi) {
			this.lixi = lixi;
		}
		public String getXnb() {
			return xnb;
		}
		public void setXnb(String xnb) {
			this.xnb = xnb;
		}
		public String getYunbi() {
			return yunbi;
		}
		public void setYunbi(String yunbi) {
			this.yunbi = yunbi;
		}
		@Override
		public String toString() {
			return "Data [tj_he=" + tj_he + ", ue_pdb=" + ue_pdb + ", coun="
					+ coun + ", ue_money=" + ue_money + ", chuju=" + chuju
					+ ", glj=" + glj + ", gpd=" + gpb + ", laomi=" + laomi
					+ ", lixi=" + lixi + ", xnb=" + xnb + ", yunbi=" + yunbi
					+ "]";
		}
		
		
	}
	
}
