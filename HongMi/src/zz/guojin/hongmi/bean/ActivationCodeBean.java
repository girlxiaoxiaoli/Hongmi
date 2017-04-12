package zz.guojin.hongmi.bean;

public class ActivationCodeBean {

	public String data;
	public String error;
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	@Override
	public String toString() {
		return "ActivationCode [data=" + data + ", error=" + error + "]";
	}
	
}
