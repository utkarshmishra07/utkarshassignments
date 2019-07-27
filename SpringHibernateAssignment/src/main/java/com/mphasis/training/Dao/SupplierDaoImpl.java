package com.mphasis.training.Dao;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mphasis.training.entities.Products;
import com.mphasis.training.entities.Suppliers;
@Repository
@Transactional
public class SupplierDaoImpl implements SupplierDao {
       
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void addSupplier(Suppliers s) {
		// TODO Auto-generated method stub
		try {
			Session session=sessionFactory.getCurrentSession();
			
			session.save(s);
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

	public void deleteSupplier(int sid) {
		// TODO Auto-generated method stub
		try {
			Session session=sessionFactory.getCurrentSession();
		
			Suppliers s=(Suppliers) session.get(Suppliers.class, sid);
			session.delete(s);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void updateSupplier(Suppliers s) {
		// TODO Auto-generated method stub
		try {
			Session session=sessionFactory.getCurrentSession();
			
			session.update(s);
			
		}catch(Exception e) {
			System.out.println("Id does not exist");
			/*e.printStackTrace();*/
		}
	}

}
