package zz.guojin.hongmi.bean;

import java.util.List;

/**
 * Created by Administrator on 2017/4/1.
 */

public class QiangdanBean {
private String error;
private List<QiangBean> data;

public String getError() {
	return error;
}

public void setError(String error) {
	this.error = error;
}

public List<QiangBean> getData() {
	return data;
}

public void setData(List<QiangBean> data) {
	this.data = data;
}

@Override
public String toString() {
	return "QiangdanBean [error=" + error + ", data=" + data + "]";
}

public static class QiangBean{
//	"id": "356",
//    "user": "13100337098",
//    "date": "2017-04-01 13:29:55",
//    "jb": "1200",
//    "type": "银行卡 支付宝 微信"
	private String id;
	private String user;
	private String date;
	private String jb;
	private String type;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getJb() {
		return jb;
	}
	public void setJb(String jb) {
		this.jb = jb;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "QiangBean [id=" + id + ", user=" + user + ", date=" + date
				+ ", jb=" + jb + ", type=" + type + "]";
	}
	
}
}
