package pojo;

public class OrderState {
	private int id;//订单状态id
	private String state;//订单状态
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	@Override
	public String toString() {
		return "orderState [id=" + id + ", state="
				+ state + "]";
	}
}
