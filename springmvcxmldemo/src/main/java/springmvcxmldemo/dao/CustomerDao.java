package springmvcxmldemo.dao;
import java.util.List;

import springmvcxmldemo.entities.Customer;
public interface CustomerDao {
	
	public Customer login(String email, String pass);
	public void addCustomer(Customer customer);
	public void updateCustomer(long phone, int cid);
	public void changePassword(String pass);
	public void deleteCustomer(int custid);
	public List<Customer> getAllCustomers();
	public Customer getById(int custid);
	
}
