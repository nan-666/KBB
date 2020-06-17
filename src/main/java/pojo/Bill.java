package pojo;

import java.util.Date;

public class Bill {
	
	private int id; //id
	private int userid;//用户id
	private double numberbefore;//变化前账户余额数
	private double numberafter;//变化后账户余额数
	private Date time;//余额变动时间
	private String state;//当前状态
	private String odd;//订单号
	private String information;//交易信息
	private int balance;
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
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
	public double getNumberbefore() {
		return numberbefore;
	}
	public void setNumberbefore(double numberbefore) {
		this.numberbefore = numberbefore;
	}
	public double getNumberafter() {
		return numberafter;
	}
	public void setNumberafter(double numberafter) {
		this.numberafter = numberafter;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getOdd() {
		return odd;
	}
	public void setOdd(String odd) {
		this.odd = odd;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	
	@Override
	public String toString() {
		return "Bill [id=" + id + ", userid=" + userid + ", numberbefore=" + numberbefore + ", numberafter="
				+ numberafter + ", time=" + time + ", state=" + state + ", odd=" + odd + ", information=" + information
				+ "]";
	}
	
	
	
	
}
