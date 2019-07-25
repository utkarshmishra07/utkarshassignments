/**
 * 
 */
package Beans;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author utkarsh.mishra1
 *
 */
public class MapDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<Integer, Employee> m1=new TreeMap<>();
		m1.put(120,  new Employee(12,"XCV", "bb"));
		m1.put(220,  new Employee(12,"XCV", "bb"));
		m1.put(320,  new Employee(12,"XCV", "bb"));
		m1.put(420,  new Employee(12,"XCV", "bb"));
		for(Map.Entry<Integer, Employee> entry:m1.entrySet()) {
			int key=entry.getKey();
			Employee value=entry.getValue();
			System.out.println(key+" "+value.getEmpid()+" "+value.getEname());
		}
	}
    Map<Question, List<Answer>> map = new TreeMap<>();
}
