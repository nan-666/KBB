package pojo;

public class Content {
	private double figure;
	private int members;
	private int orders;
	private int merchants;
	public double getFigure() {
		return figure;
	}
	public void setFigure(double figure) {
		this.figure = figure;
	}
	public int getMembers() {
		return members;
	}
	public void setMembers(int members) {
		this.members = members;
	}
	public int getOrders() {
		return orders;
	}
	public void setOrders(int orders) {
		this.orders = orders;
	}
	public int getMerchants() {
		return merchants;
	}
	public void setMerchants(int merchants) {
		this.merchants = merchants;
	}
	@Override
	public String toString() {
		return "Content [figure=" + figure + ", members=" + members + ", orders=" + orders + ", merchants=" + merchants
				+ "]";
	}
}
