/**
 * 
 */
package functionalInterface;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;



/**
 * @author utkarsh.mishra1
 *
 */
public class StringJoinerDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> filist=new ArrayList<>();
		filist.add("Predicate");
		filist.add("Function");
		filist.add("BiFunction");
		filist.add("BiPredicate");
		filist.add("Consumer");
		filist.add("Supplier");
	filist.forEach(System.out::println);
	filist.forEach((a) -> System.out.println(a));
	StringJoiner st=new StringJoiner("-", "{","}");
	st.add(filist.get(4)).add(filist.get(5));
	System.out.println(st);

	StringJoiner st1=new StringJoiner("-", "#","#");
	st1.add(filist.get(0)).add(filist.get(3));
	System.out.println(st1);

	StringJoiner st2=new StringJoiner("-", "$","$");
	st2.add(filist.get(1)).add(filist.get(2));
	System.out.println(st2);
	//st.setEmptyValue("st is empty");
	st.length();
	
	;
	String[] sta=new String[] {"Pune","Mumbai","Chennai","Bangalore"};
	
	List<String> locations=Arrays.asList(sta);
	Collections.sort(locations,(s1,s2)->s1.length()-s2.length());
	System.out.println("Sorted according to length");
	locations.forEach(System.out::println);
	Collections.sort(locations);
	System.out.println("Sorted according to name");
	locations.forEach(System.out::println);
	
	List<Integer> numlist=new ArrayList<>();
	numlist.add(2);
	numlist.add(3);
	numlist.add(4);
	numlist.add(5);
	numlist.add(6);
	numlist.add(7);
	//numlist.forEach((n)->System.out.println(((n%2)==0)?n:"")); //alternate method
	List<Integer> l2=
			numlist.stream()
			.filter(i->(i%2)==0)
			.collect(Collectors.toList());
	l2.forEach(System.out::println);
	}
}