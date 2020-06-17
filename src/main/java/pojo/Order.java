package pojo;

import java.util.Date;

public class Order {
	
	private int id; //id
	private int userid;//用户id
	private String name;//用户真实姓名
	private String phone;//用户手机号
	private String icon;//图标url
	private String time;//服务时间
	private String address;//地址
	private String title;//订单标题
	private String describe;//订单标题
	private String type;//订单分类
	private double money;//订单佣金
	private String img_1;//订单详情图片1
	private String img_2;//订单详情图片2
	private String img_3;//订单详情图片3
	private String img_4;//订单详情图片4
	private String img_5;//订单详情图片5
	private String state;//订单状态(0-已完成，1-正在进行中)
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public String getImg_1() {
		return img_1;
	}
	public void setImg_1(String img_1) {
		this.img_1 = img_1;
	}
	public String getImg_2() {
		return img_2;
	}
	public void setImg_2(String img_2) {
		this.img_2 = img_2;
	}
	public String getImg_3() {
		return img_3;
	}
	public void setImg_3(String img_3) {
		this.img_3 = img_3;
	}
	public String getImg_4() {
		return img_4;
	}
	public void setImg_4(String img_4) {
		this.img_4 = img_4;
	}
	public String getImg_5() {
		return img_5;
	}
	public void setImg_5(String img_5) {
		this.img_5 = img_5;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDescribe() {
		return describe;
	}
	public void setDescribe(String describe) {
		this.describe = describe;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", userid=" + userid + ", name=" + name + ", phone=" + phone + ", icon=" + icon
				+ ", time=" + time + ", address=" + address + ", title=" + title + ", describe=" + describe + ", type="
				+ type + ", money=" + money + ", img_1=" + img_1 + ", img_2=" + img_2 + ", img_3=" + img_3 + ", img_4="
				+ img_4 + ", img_5=" + img_5 + ", state=" + state + "]";
	}
	
	
	
	
	
}
