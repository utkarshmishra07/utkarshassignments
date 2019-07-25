package com.mphasis.cart.beans;

public class Product {
	private int pid;
	private String pname;
	private double cost;
	private int quantity;
	public int getPid() {
		return pid;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int pid, String pname, double cost, int quantity) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.cost = cost;
		this.quantity = quantity;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", cost=" + cost + ", quantity=" + quantity + "]";
	}
	
}
