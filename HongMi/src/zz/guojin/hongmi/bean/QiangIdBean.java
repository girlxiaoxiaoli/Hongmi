package zz.guojin.hongmi.bean;

public class QiangIdBean {
	// {
	// "data": {
	// "qt_lower_money": "1000",
	// "qt_upper_money": "5000",
	// "by_lower_money": "5000",
	// "by_upper_money": "10000",
	// "hj_lower_money": "10000",
	// "hj_upper_money": "15000",
	// "zs_lower_money": "15000",
	// "zs_upper_money": "20000"
	// },
	// "error": 1
	// }
	private String error;
	private DataBean data;

	@Override
	public String toString() {
		return "QiangIdBean [error=" + error + ", dataBean=" + data + "]";
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public DataBean getDataBean() {
		return data;
	}

	public void setDataBean(DataBean data) {
		this.data = data;
	}

	public static class DataBean {
		private String qt_lower_money;
		private String qt_upper_money;
		private String by_lower_money;
		private String by_upper_money;
		private String hj_lower_money;
		private String hj_upper_money;
		private String zs_lower_money;
		private String zs_upper_money;

		public String getQt_lower_money() {
			return qt_lower_money;
		}

		public void setQt_lower_money(String qt_lower_money) {
			this.qt_lower_money = qt_lower_money;
		}

		public String getQt_upper_money() {
			return qt_upper_money;
		}

		public void setQt_upper_money(String qt_upper_money) {
			this.qt_upper_money = qt_upper_money;
		}

		public String getBy_lower_money() {
			return by_lower_money;
		}

		public void setBy_lower_money(String by_lower_money) {
			this.by_lower_money = by_lower_money;
		}

		public String getBy_upper_money() {
			return by_upper_money;
		}

		public void setBy_upper_money(String by_upper_money) {
			this.by_upper_money = by_upper_money;
		}

		public String getHj_lower_money() {
			return hj_lower_money;
		}

		public void setHj_lower_money(String hj_lower_money) {
			this.hj_lower_money = hj_lower_money;
		}

		public String getHj_upper_money() {
			return hj_upper_money;
		}

		public void setHj_upper_money(String hj_upper_money) {
			this.hj_upper_money = hj_upper_money;
		}

		public String getZs_lower_money() {
			return zs_lower_money;
		}

		public void setZs_lower_money(String zs_lower_money) {
			this.zs_lower_money = zs_lower_money;
		}

		public String getZs_upper_money() {
			return zs_upper_money;
		}

		public void setZs_upper_money(String zs_upper_money) {
			this.zs_upper_money = zs_upper_money;
		}

		@Override
		public String toString() {
			return "DataBean [qt_lower_money=" + qt_lower_money
					+ ", qt_upper_money=" + qt_upper_money
					+ ", by_lower_money=" + by_lower_money
					+ ", by_upper_money=" + by_upper_money
					+ ", hj_lower_money=" + hj_lower_money
					+ ", hj_upper_money=" + hj_upper_money
					+ ", zs_lower_money=" + zs_lower_money
					+ ", zs_upper_money=" + zs_upper_money + "]";
		}

	}
}
