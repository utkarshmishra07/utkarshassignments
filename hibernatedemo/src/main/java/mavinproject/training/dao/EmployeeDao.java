package mavinproject.training.dao;

import java.util.List;

import mavinproject.training.beans.Employee;

public interface EmployeeDao {
	public void addEmployee(Employee e); 
	public void removeEmployee(int empid);
	public Employee getEmployeeById(int empid);
	public List<Employee> getEmployeeByName(String empname);
	public List<Employee> getEmployeeBySalary(double salary);
	public List<Employee> getAll();
	public void updateEmployee(int eid);	
	
}
