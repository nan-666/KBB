package pojo;

import java.util.Date;

public class evaluate {
	
	private int id; //id
	private int userid;//用户id
	private int workerid;//职工id
	private int star;//评价星级
	private String content;//内容
	private Date time;//评价日期
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
	public int getWorkerid() {
		return workerid;
	}
	public void setWorkerid(int workerid) {
		this.workerid = workerid;
	}
	public int getStar() {
		return star;
	}
	public void setStar(int star) {
		this.star = star;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	@Override
	public String toString() {
		return "evaluate [id=" + id + ", userid=" + userid + ", workerid=" + workerid + ", star=" + star + ", content="
				+ content + ", time=" + time + "]";
	}
	

}
