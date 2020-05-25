package pojo;

public class login {
	private int id;//id
	private int userid;//用户id
	private int openid;//
	private int unionid;//
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
	public int getOpenid() {
		return openid;
	}
	public void setOpenid(int openid) {
		this.openid = openid;
	}
	public int getUnionid() {
		return unionid;
	}
	public void setUnionid(int unionid) {
		this.unionid = unionid;
	}
	@Override
	public String toString() {
		return "login [id=" + id + ", userid=" + userid + ", openid=" + openid + ", unionid=" + unionid + "]";
	}
	
	
}
