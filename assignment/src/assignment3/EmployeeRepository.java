package assignment3;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;



public class EmployeeRepository {
	


	
	
	
	List<Employee> employees=null;
	List<Department> departments= null;
	  public EmployeeRepository()
	  {   
		   departments=new ArrayList<>();
		   employees=new ArrayList<>();
		  
		    Department d;
		    departments.add( d=new Department(1,"IT",236546));
		    employees.add(new Employee(1,"Bhuma","Pravallika","bhuma.pravallika@mphasis.com",987654321L,LocalDate.of(2015,1,9),"BussinessAssociate",20000,236546,d)) ;
		    employees.add(new Employee(2,"Guvvala","sagar","sagar@mphasis.com",9876353561L,LocalDate.of(2019,1,20),"System admin",20000,236526,d)) ;   
            
            departments.add( d=new Department(2,"APPS",236569));
            employees.add(new Employee(3,"Utkarsh","mishra","mishra@mphasis.com",9874563561L,LocalDate.of(2015,1,2),"CEO",10000,236569,d)) ;
           
            departments.add( d=new Department(3,"HR",236542));
            employees.add(new Employee(4,"Riya","bisen","riya@mphasis.com",98732523451L,LocalDate.of(2018,5,12),"Manager",40000,236542,d)) ;
            employees.add(new Employee(5,"Hari","priya","hpriya@mphasis.com",98214235343L,LocalDate.of(2017,3,23),"Manager",34000,236542,d)) ;
	  }
	  
	 
	 /*public new Department("Account", 75); 
      Department hr = new Department("HR", 50);
      Department ops = new Department("OP", 25);
      Department tech = new Department("Tech", 150);*/         
	 
	  
		  
		   
	  
	  
	  public List<Employee> getAllEmployees()
	  {
		   return employees;
	  }
	  
	  public void addEmployee(Employee c)
	  {
		   employees.add(c);
	  }
	  public Employee getEmployee(int index)
	  {
		  Employee c=employees.get(index);
		  return c;
		  
	  }
	  public void deleteEmployee(int index)
	  {
		  employees.remove(index);
		  
	  }
	  public List<String> getEmpDuration() { // 14.9
			List<String> emp = new ArrayList<>();
				
			for (Employee e :employees ) {
				LocalDate ld = e.getDoj();
				LocalDate now = LocalDate.now();
				String name = e.getFirstName() + " " + e.getLastName();

				Period p = Period.between(ld, now);
				int month = p.getMonths() + (p.getYears() * 12);
				int days = p.getDays();
				String dur = "Name: " + name + "Months: " + month + " Days: " + days + "\n";
				emp.add(dur);
			}
			return emp;
		}
	  
	 /* public List<String> sortByDeptId() {
			List<String> emp = new ArrayList<>();

			Comparator<Employee> ecom1 = (Employee o1, Employee o2) -> {
				if (o1.getDepartment().getDepId() > o2.getDepartment().getDepId())
					return 1;
				else if (o1.getDepartmentName().getDepId() < o2.getDepartment().getDepId())
					return -1;
				else
					return 0;
			}*/;

	  
	
}	
	
	

	


