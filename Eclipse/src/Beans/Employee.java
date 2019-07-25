/**
 * 
 */
package Beans;

import java.io.Serializable;

/**
 * @author utkarsh.mishra1
 *
 */
public class Employee implements Serializable, Comparable<Employee> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int empid;
	private String ename;
	transient private String address;


	Employee() {
	}
	
	public Employee(int empid, String ename, String address) {
		super();
		this.empid = empid;
		this.ename = ename;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", ename=" + ename + ", address=" + address + "]";
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public int compareTo(Employee e) {
		if(empid < e.getEmpid()) return -1;
		else if(empid > e.getEmpid()) return 1;
		else return 0;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

	}

}
