package com.mphasis.training.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "sup")
public class Suppliers {

	@Id
	private int sid;
	private String sname;
	private String address;
	@ManyToMany(mappedBy = "suppliers", fetch = FetchType.EAGER)
	private List<Products> products;

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Products> getProducts() {
		return products;
	}

	public void setProducts(List<Products> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Suppliers [sid=" + sid + ", sname=" + sname + ", address=" + address + ", products=" + products + "]";
	}

}
