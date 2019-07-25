/**
 * 
 */
package collectionprograms;
import java.util.*;
import Beans.Employee;
/**
 * @author utkarsh.mishra1
 *
 */
public class ListDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List <Integer> l1=new ArrayList<>();
		l1.add(123);
		l1.add(654);
		l1.add(345);
		l1.add(2321);
		List <Integer> l2=new ArrayList<>();
		l2.add(123);
		l2.add(654);
		l2.add(345);
		l2.add(2132);
		l2.addAll(0,l1);
		System.out.println(l2);
		l2.remove(2); //deleting element based on index
		System.out.println(l2);
		System.out.println("based on index retrieval"+l1.get(3));
		
		
		List<Employee> employees=new ArrayList<>();
		employees.add(new Employee(12,"komal","mp"));
		employees.add(new Employee(11,"kom","mp"));
		employees.add(new Employee(13,"al","mp"));
		System.out.println("----------------------");
		System.out.println(employees);
		System.out.println("----------------------");
		for(Employee e:employees) {
			System.out.println(e.getEmpid()+" "+e.getEname());
		}
		System.out.println("------------------------");
		Iterator<Employee> it=employees.iterator();
		while(it.hasNext()) {
			Employee e1=it.next();
		System.out.println(e1.getEmpid()+" "+e1.getEname());
		}
		System.out.println("------------------------");
		System.out.println("first to last");
		ListIterator<Employee> lit=employees.listIterator();
		while(lit.hasNext()) {
			Employee e1=lit.next();
			System.out.println(e1.getEmpid()+" "+e1.getEname());
		}
		System.out.println("------------------------");
		System.out.println("last to first");
		ListIterator<Employee> lit1=employees.listIterator(2);
		while(lit1.hasPrevious()) {
			Employee e1=lit1.previous();
			System.out.println(e1.getEmpid()+" "+e1.getEname());
		}
		System.out.println("---------legacy---------");
		Vector v1=new Vector();
		v1.add(new Employee(12,"venkat", "AP"));
		v1.addElement(new Employee(13, "Atul","MP"));
		Enumeration en= v1.elements();
		while(en.hasMoreElements()) {
			Employee e=(Employee)en.nextElement();
			System.out.println(e.getEname());
		}
		
	//before Java 8
	Comparator<Employee> eCom=new Comparator<Employee>() { 
	@Override
		public int compare(Employee o1, Employee o2) {
			return o1.getAddress().compareTo(o2.getAddress());
		}
	};
	
	//Java 8 using lamda
	Comparator<Employee> eCom1=(Employee o1, Employee o2) ->{
		return o1.getAddress().compareTo(o2.getAddress());
	};
	
	//in Java 8 with method reference
	Comparator<Employee> eCom2=Comparator.comparing(Employee::getEname);
	
	System.out.println("empoyee sort based on names");
	Collections.sort(employees, new NameComparator());
	for(Employee e:employees) {
		System.out.println(e.getEmpid()+" "+e.getEname());
	}
	System.out.println("----------------------");
	System.out.println("based on address");
	Collections.sort(employees,eCom);
	for (Employee e:employees) {
		System.out.println(e.getAddress()+" "+e.getEname());
	}
	System.out.println("----------------------");
	}
}


