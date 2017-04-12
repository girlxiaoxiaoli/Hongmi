package zz.guojin.hongmi.bean;

import java.io.Serializable;

public class RuquestBean implements Serializable{
	
	String msg;
	String error;
	@Override
	public String toString() {
		return "ruquest [msg=" + msg + ", error=" + error + "]";
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
}
