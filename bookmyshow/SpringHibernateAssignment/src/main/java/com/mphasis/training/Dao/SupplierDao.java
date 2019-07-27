package com.mphasis.training.Dao;

import com.mphasis.training.entities.Suppliers;

public interface SupplierDao {
	public void addSupplier(Suppliers s); 
	public void deleteSupplier(int sid);
	public void updateSupplier(Suppliers s);
}
