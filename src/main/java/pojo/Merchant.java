package pojo;

import pojo.BaseDataPojo;

public class Merchant extends BaseDataPojo{
	private static final long serialVersionUID = 1L;
	
	private int id;    //商家id
	private String name;  //入驻人员姓名
	private String loginpwd;//用户登录密码
	private String phone;//用户联系电话
	private String title;//商家店名
	private String type;//类型
	private String img;//商家图片
	private String nickname;//用户昵称
	private String sex;//用户性别
	private String birthday;//用户生日
	private String address;//用户默认地址
	private String industry;//用户行业
	private float balance;//用户余额
	private float star;//商家星级
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getLoginpwd() {
		return loginpwd;
	}
	public void setLoginpwd(String loginpwd) {
		this.loginpwd = loginpwd;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	public float getStar() {
		return star;
	}
	public void setStar(float star) {
		this.star = star;
	}
	
	public String getIndustry() {
		return industry;
	}
	public void setIndustry(String industry) {
		this.industry = industry;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "merchant [id=" + id + ", name=" + name + ", loginpwd=" + loginpwd + ","
				+ "phone=" + phone + ",title=" + title + ",type=" + type + ",img=" + img + ", nickname=" + nickname + ", "
				+ "sex=" + sex + ", birthday=" + birthday +", address=" + address + ", balance=" + balance + ",star=" + star + ",]";
	}
	
	
	
	
}
