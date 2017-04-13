package zz.guojin.hongmi.bean;

import java.io.Serializable;
import java.util.List;

import android.widget.ListView;

public class AwardRecodeBean implements Serializable{
	/**
	 * data : [{"addtime":"1970-01-01 08-00-00","consume":"100","id":"427","reward_id":"6","reward_num":"2","uid":"61451"}]
	 * error : 1
	 */

	private int error;
	/**
	 * addtime : 1970-01-01 08-00-00
	 * consume : 100
	 * id : 427
	 * reward_id : 6
	 * reward_num : 2
	 * uid : 61451
	 */

	private List<DataBean> data;

	public int getError() {
		return error;
	}

	public void setError(int error) {
		this.error = error;
	}

	public List<DataBean> getData() {
		return data;
	}

	public void setData(List<DataBean> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "AwardRecode [error=" + error + ", data=" + data + "]";
	}

	public static class DataBean {
		private String time;
		private String consume;

		private String reward_id;
		private String reward_num;


	
		@Override
		public String toString() {
			return "DataBean [time=" + time + ", consume=" + consume
					+ ", reward_id=" + reward_id + ", reward_num=" + reward_num
					+ "]";
		}

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

		public String getConsume() {
			return consume;
		}

		public void setConsume(String consume) {
			this.consume = consume;
		}

		

		public String getReward_id() {
			return reward_id;
		}

		public void setReward_id(String reward_id) {
			this.reward_id = reward_id;
		}

		public String getReward_num() {
			return reward_num;
		}

		public void setReward_num(String reward_num) {
			this.reward_num = reward_num;
		}

		
	}
}
