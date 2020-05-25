package pojo;

public class Card {

	private int id; //id
	private int userid;//用户id
	private String cardnumber;//银行卡号
	private String type;//银行卡类型
	private String last_four;//银行卡后四位
	private String state;//银行卡状态，是否实名认证
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLast_four() {
		return last_four;
	}
	public void setLast_four(String last_four) {
		this.last_four = last_four;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return "Card [id=" + id + ", userid=" + userid + ", cardnumber=" + cardnumber + ", type=" + type
				+ ", last_four=" + last_four + ", state=" + state + "]";
	}
	
	
	
}
