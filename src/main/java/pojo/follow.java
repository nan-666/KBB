package pojo;

public class follow {
	private int id;//id
	private int from_user_id;//关注的人/即粉丝
	private int to_user_id;//被关注的人
	private String both_status;//互粉状态
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getFrom_user_id() {
		return from_user_id;
	}
	public void setFrom_user_id(int from_user_id) {
		this.from_user_id = from_user_id;
	}
	public int getTo_user_id() {
		return to_user_id;
	}
	public void setTo_user_id(int to_user_id) {
		this.to_user_id = to_user_id;
	}
	public String getBoth_status() {
		return both_status;
	}
	public void setBoth_status(String both_status) {
		this.both_status = both_status;
	}
	
	@Override
	public String toString() {
		return "follow [id=" + id + ", from_user_id=" + from_user_id + ", to_user_id=" + to_user_id + ", both_status="
				+ both_status + "]";
	}
	
}
