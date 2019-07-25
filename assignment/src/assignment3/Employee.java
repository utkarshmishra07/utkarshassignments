package assignment3;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Employee {
private int empId;
private String firstName;
private String lastName;
private String email;
private long phoneNum;
private LocalDate doj;
private String  designation;
private double salary;
private int managerId;
private Department department;
//private String date;
//private String departmentId;
public Employee(int empId, String firstName, String lastName, String email, long phoneNum, LocalDate doj, String designation,
		double salary,int managerId, Department department) {

	this.empId = empId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.phoneNum = phoneNum;
	this.doj = doj;
	this.designation = designation;
	this.salary = salary;
	this.managerId = managerId;
	this.department=department;
}
public int getEmpId() {
	return empId;
}
public String getFirstName() {
	return firstName;
}
public String getLastName() {
	return lastName;
}
public String getEmail() {
	return email;
}
public long getPhoneNum() {
	return phoneNum;
}
public LocalDate getDoj() {
	return doj;
}
@Override
public String toString() {
	return "Employee:\nEmpId: " + empId + ",FirstName: " + firstName + ", LastName: " + lastName + ", Email: " + email
			+ ", PhoneNum: " + phoneNum + ", Doj:" + doj + ", Designation: " + designation + ", Salary:" + salary
			+ ", ManagerId: " + managerId;
}
public String getDesignation() {
	return designation;
}
public double getSalary() {
	return salary;
}
public int getManagerId() {
	return managerId;
}



}
