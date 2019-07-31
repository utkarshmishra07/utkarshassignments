package springmvcxmldemo.bo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import springmvcxmldemo.dao.CustomerDao;
import springmvcxmldemo.entities.Customer;

@Service
public class CustomerBoImpl implements CustomerBo {
	@Autowired
	CustomerDao customerDao;

	public Customer login(String email, String pass) throws Exception {
		Customer customer;
		if (email.matches("([a-zA-Z/.&%-_]{5,})@gmail.com") && pass.matches("[a-zA-Z]{5,}")) {
			customer = customerDao.login(email, pass);

		} else {
			throw new Exception("invalid pattern");
		}
		return customer;
	}

	public void signup(Customer customer) {
		customerDao.addCustomer(customer);
	}

	

	public void changePassword(String pass) {
		customerDao.changePassword(pass);

	}

	public void removeCustomer(int custid) {
		customerDao.deleteCustomer(custid);

	}

	public List<Customer> getAllCustomers() {
		
		return customerDao.getAllCustomers();
		
	}

	public Customer getById(int custid) {
		
		return customerDao.getById(custid);
	}

	public void editCustomer(long phone, int custid) {
		customerDao.updateCustomer(phone, custid);
		
	}

}
