package zz.guojin.hongmi.bean;

public class Upper {

	
	// {"little":"1000-30000","error":1}
	String little;
	String error;
	String sx;
	public String getSx() {
		return sx;
	}
	public void setSx(String sx) {
		this.sx = sx;
	}
	public String getLittle() {
		return little;
	}
	public void setLittle(String little) {
		this.little = little;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	@Override
	public String toString() {
		return "Upper [little=" + little + ", error=" + error + ", sx=" + sx
				+ "]";
	}

}
