package com.mphasis.training.Dao;

import com.mphasis.training.entities.Products;

public interface ProductsDao {
	public void addProducts(Products p); 
	public void deleteProducts(int pid);
	public void updateProducts(Products p);
}
