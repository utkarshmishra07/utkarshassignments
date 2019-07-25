package assignment3;

public class Department {
private int departmentId;
private String departmentName;
private int managerId;
public Department(int departmentId, String departmentName, int managerId) {
	this.departmentId = departmentId;
	this.departmentName = departmentName;
	this.managerId = managerId;
}
public int getDepartmentId() {
	return departmentId;
}
public String getDepartmentName() {
	return departmentName;
}
public int getManagerId() {
	return managerId;
}

}
