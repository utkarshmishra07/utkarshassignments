package springmvcxmldemo.bo;

import java.util.List;

import springmvcxmldemo.entities.Customer;

 public interface CustomerBo {
	public Customer login(String email, String pass) throws Exception;
	public void signup(Customer customer);
	public void editCustomer(long phone, int custid);
	public void changePassword(String pass);
	public void removeCustomer(int custid);
	public List<Customer> getAllCustomers();
	public Customer getById(int custid);
}
 
 