package springmvcxmldemo.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import springmvcxmldemo.entities.Customer;


@Repository
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public Customer login(String email, String pass) {
		Session session=sessionFactory.openSession();
		Customer customer;
		Transaction tr=session.beginTransaction();
		Query query=sessionFactory.openSession().createQuery("from Customer where cemail=:cemail and cpass=:cpass");
		query.setString("cemail", email);
		query.setString("cpass", pass);
		customer=(Customer)query.uniqueResult();
		tr.commit();
		
		return customer;
	}

	public void addCustomer(Customer customer) {
		Session session=sessionFactory.openSession();
		try {
		Transaction tr=session.beginTransaction();
		session.save(customer);
		tr.commit();
		session.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	public void updateCustomer(long phone, int cid) {
		Session session=sessionFactory.openSession();
		try {
		Transaction tr=session.beginTransaction();
		Customer c=(Customer) session.get(Customer.class, cid);
		c.setPhone(phone);
		session.update(phone);
		tr.commit();
		session.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void changePassword(String pass) {
		Session session=sessionFactory.openSession();
		try {
		Transaction tr=session.beginTransaction();
		Customer c=(Customer) session.get(Customer.class, pass);
		session.update(c);
		tr.commit();
		session.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void deleteCustomer(int custid) {
		Session session=sessionFactory.openSession();
		try {
		Transaction tr=session.beginTransaction();
		Customer c=(Customer) session.get(Customer.class, custid);
		session.delete(c);
		
		tr.commit();
		session.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public List<Customer> getAllCustomers() {
		Session session=sessionFactory.openSession();
		List<Customer> cus = null;
		try {
		Transaction tr=session.beginTransaction();
		cus = session.createCriteria(Customer.class).list();
		tr.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return cus;
	}

	public Customer getById(int custid) {
		Session session=sessionFactory.openSession();
		Customer c = null;
		try {
		Transaction tr=session.beginTransaction();
		c = (Customer) session.get(Customer.class, custid);
		tr.commit();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	
}
