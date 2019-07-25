/**
 * 
 */
package Beans;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author utkarsh.mishra1
 *
 */
public class SetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Set<String> s1=new TreeSet<>();
		s1.add("Sweta");
		s1.add("Manisa");
		s1.add("Sweta");
		s1.add("Gowtami");
		s1.add("Geeta");
		s1.add("Smita");
		
		System.out.println(s1);
		
		Set<Employee> employees= new TreeSet<>();
		
		employees.add(new Employee(12, "Komal", "MP"));
		employees.add(new Employee(12, "Komal", "MP"));
		employees.add(new Employee(12, "Mohan", "MP"));
		for(Employee e:employees) {
			System.out.println(e.getEmpid()+" "+e.getEname());
		}
		
	}

}