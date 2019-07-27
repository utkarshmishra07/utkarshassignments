package com.mphasis.training.Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mphasis.training.entities.Products;
@Repository
@Transactional

public class ProductDaoImpl implements ProductsDao{

	@Autowired
	SessionFactory sessionFactory;
	
	
	public void addProducts(Products p) {
		// TODO Auto-generated method stub
		try {
			Session session=sessionFactory.getCurrentSession();
			
			session.save(p);

			
		}catch(Exception e) {
			e.printStackTrace();
		}

		
	}

	public void deleteProducts(int pid) {
		// TODO Auto-generated method stub
		try {
			Session session=sessionFactory.getCurrentSession();
		
			Products p=(Products) session.get(Products.class, pid);
			session.delete(p);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void updateProducts(Products p) {
		// TODO Auto-generated method stub
		try {
			Session session=sessionFactory.getCurrentSession();
			
			session.update(p);

			
		}catch(Exception e) {
			System.out.println("Id does not exist");
			
/*			e.printStackTrace();*/
		}

	}
          
}
