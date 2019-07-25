/**
 * 
 */
package mavinproject.training;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import mavinproject.training.beans.Department;
import mavinproject.training.beans.Employee;
import mavinproject.training.conf.HibernateUtil;
import mavinproject.training.dao.EmployeeDaoImpl;

/**
 * @author utkarsh.mishra1
 *
 */

public class EmployeeApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		EmployeeDaoImpl e=new EmployeeDaoImpl();
		System.out.println("1 getById\n2addEmployee");
		int choice=sc.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Enter Employee ID");
			int empid=sc.nextInt();
			System.out.println(e.getEmployeeById(empid));
		
		case 2:
			
			Employee emp=new Employee();
			System.out.println("Enter Employee ID");
			emp.setEmpid(sc.nextInt());
			System.out.println("Enter Employee Name");
			emp.setEmpName(sc.next());
			System.out.println("Enter Employee Salary");
			emp.setSalary(sc.nextDouble());
			
			try{
				e.addEmployee(emp);
				System.out.println("Employee Added");
			}catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}	
		
		
		
		
		/*Department d1=new Department();
		d1.setDeptid(100);
		d1.setDname("Accounts");
		
		Employee e1=new Employee();
        e1.setEmpid(103);
        e1.setEmpName("koi");
        e1.setSalary(99349);
        e1.setDepartment(d1);
		
        Employee e2=new Employee();
        e2.setEmpid(104);
        e2.setEmpName("nahi");
        e2.setSalary(76378);
        e2.setDepartment(d1);
		
        
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		
		session.save(d1);
		session.save(e1);
		session.save(e2);
		
		tr.commit();
		session.close();*/

	}

}
