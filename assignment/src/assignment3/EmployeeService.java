/**
 * 
 */
package assignment3;


import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import assignment3.Employee;

import java.security.KeyStore.Entry;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.*;


/**
 * @author guvvala.sagar
 *
 */
public class EmployeeService {
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		EmployeeRepository repository=new EmployeeRepository();
		System.out.println("Welcome to company portal");

		do{
			
			
			 System.out.println("1. Add employee \n 2. Remove \n  3. ViewEmployee \n  4. ViewAll  \n 5. sum of salaries of all emplpoyess \n  6. emp duration  \n 7.nameofemployee,hiredate and dayofweek \n  8.employeename-service in months and days \n 9. Employee name who starts on froday \n 10.Employee salary increment by 15% \n11.Friday joinees  \n 12.Exit");
			 int choice=sc.nextInt();
			 switch(choice)
			 {
			 
			 case 1:
				 System.out.println("Enter department details");
				 Department d=(new Department(sc.nextInt(),sc.next(),sc.nextInt())); 
				 System.out.println("Enter employeeId\nfirstNamr\nlastName\nemail\nphoneNum\ndoj\ndesignation\nsalary\nmanagerId ");
			 

		        repository.addEmployee(new Employee(sc.nextInt(),sc.next(),sc.next(),sc.next(),sc.nextLong(),LocalDate.of(sc.nextInt(), sc.nextInt(), sc.nextInt()),sc.next(),sc.nextDouble(),sc.nextInt(),d));
			        
				    break;
			
			 case 2:  System.out.println("enter the index");
			         repository.deleteEmployee(sc.nextInt());
			         System.out.println("The employee deleted successfully");
				 
				    break;
				    
			 case 3: System.out.println("Enter the index");
			         Employee cl=repository.getEmployee(sc.nextInt());
			         System.out.println(cl.getEmpId()+ " "+cl.getFirstName()+" "+cl.getLastName()+" "+cl.getEmail()+" "+cl.getPhoneNum()+" "+cl.getDoj()+" "+cl.getDesignation()+" "+cl.getSalary()+" "+cl.getManagerId());
			         
				     break;
			 case 4:  System.out.println("List of employees");
			         List<Employee> cans=repository.getAllEmployees();
			         cans.forEach((c)->System.out.println(c));
			         
				    break;
			 
			 case 5: System.out.println("Sum of all salaries of all emplpoyess");
		        List<Employee> emps  =repository.getAllEmployees();
		        Double total = emps.stream().collect(Collectors.summingDouble(Employee::getSalary));
		        System.out.println("Total Employees Salary : " + total);
		            break;
			
			 case 6: System.out.println("Get empployee by duration");
			      
			       List<String> emps2 =repository.getEmpDuration();
			         
			        	  System.out.println(emps2);
			          break;
			 
			 
			 case 7: System.out.println("nameofemployee,hiredate and dayofweek");
                 List<Employee> employees =repository.getAllEmployees();
			 for(Employee c:employees)
             {
                      LocalDate today = c.getDoj();

                      DayOfWeek day = today.getDayOfWeek();
	              System.out.println("Name of Employee" +" -"+"Hiredate"+" -"+"DayofWeek");
	              System.out.println(c.getFirstName()+" "+c.getLastName()+"-"+c.getDoj()+"-"+day);
             }
			 
			  case 8:System.out.println("employeename-service in months and days");
			  List<Employee> employees1 =repository.getAllEmployees();  
			             for(Employee c:employees1)
			                 {
			             LocalDate doj= c.getDoj();
			               LocalDate now = LocalDate.now();
			               Period diff = Period.between(doj, now);
			             System.out.print(c.getLastName()+c.getLastName()+"-");
			             System.out.printf("%d months and %d days\n",diff.getMonths(), diff.getDays());
			                 } 
				    
			   
			  case 9:System.out.println("Employeename-who starts on friday");
			  List<Employee> employees2 =repository.getAllEmployees();   
			   for(Employee c:employees2)
			    {
			    	LocalDate today=c.getDoj();
			    	 DayOfWeek day = today.getDayOfWeek();
			    	String day1=day.name();
			    	if(day1=="FRIDAY" || day1=="friday")
			    	{
			    		System.out.println(c.getFirstName()+c.getLastName()+"-"+day1);
			    	}
			    }
			    break;
			 
			  case 10: System.out.println("Employeename-salary-salaryincrementby15%");
			  List<Employee> employees3 =repository.getAllEmployees();   
			  for(Employee c:employees3)
				{
					double sal=c.getSalary();
					sal=sal+sal*0.15;	
					System.out.println(c.getFirstName()+c.getLastName()+"-"+c.getSalary()+" increment to"+" "+sal);
				}
				  
				  break;
			  case 11: System.out.println("Employeename-doj-doj day");
			  List<Employee> employees4 =repository.getAllEmployees(); 
			  
			  for(Employee c:employees4)
				{

					if(c.getDoj().getDayOfWeek().name().equalsIgnoreCase("friday")) {	
					System.out.println(c.getFirstName()+" "+c.getLastName()+"   "+c.getDoj()+"   "+c.getDoj().getDayOfWeek());
					
				}
			}
				  
				  break;
				 /* Revise exercise 10.13 to list employee name, hire date and day of week for employee started on Friday.
				  (Hint: Accept the day name for e.g. FRIDAY and list all employees joined on Friday)*/
			
				  
			  case 12:  System.out.println("Thank you, you can leave for today ");
		         System.exit(0);
			    break;
				    
			 default :  System.out.println("invalid");
			 	      
				 
			 }
		}while(true);
	}
}

	