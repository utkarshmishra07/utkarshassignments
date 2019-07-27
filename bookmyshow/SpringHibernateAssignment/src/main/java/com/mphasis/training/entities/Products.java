package com.mphasis.training.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
@Entity
/*@Table(name="pro")*/
public class Products {
	
	@Id
      private int pid;
     
	private String pname;
      private double cost;
      private String brand;
      private int quantity;
      @ManyToMany
      private List<Suppliers> suppliers;
      
      
	public int getPid() {
		return pid;
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
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
      
	@Override
	public String toString() {
		return "Products [pid=" + pid + ", pname=" + pname + ", cost=" + cost + ", brand=" + brand + ", quantity="
				+ quantity + ", suppliers=" + suppliers + "]";
	}
}
