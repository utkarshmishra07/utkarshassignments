package com.mphasis.cart.dao;

import java.util.List;

import com.mphasis.cart.beans.Product;

public interface ProductDao {
	
	public default int addProduct(Product p) {
		// TODO Auto-generated method stub
		return 0;
	}
	public int updateProduct(int pid,String name,double cost, int qty);
	public int deleteProduct(int pid);
	public Product getById(int pid);
	public List<Product> getProductByName(String pname);
	public  List<Product> getAll();
	

}