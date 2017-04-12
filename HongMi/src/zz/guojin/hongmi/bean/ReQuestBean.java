package zz.guojin.hongmi.bean;

import java.io.Serializable;

public class ReQuestBean implements Serializable{
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "ReQuestBean [msg=" + msg + "]";
	}

	

	
	

}
