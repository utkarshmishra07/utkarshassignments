/**
 * 
 */
package Beans;
import java.util.Comparator;
/**
 * @author utkarsh.mishra1
 *
 */
public class NameComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee e1, Employee e2) {
		return e1.getEname().compareTo(e2.getEname());
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
