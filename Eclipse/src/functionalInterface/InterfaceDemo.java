/**
 * 
 */
package functionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author utkarsh.mishra1
 *
 */
@FunctionalInterface
interface Calc{
	public int add(int a, int b);
	public static void sub(int a, int b){
		System.out.println(a-b);
	}
}
public class InterfaceDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Calc c1=(a,b)->(a+b);
		System.out.println(c1.add(23,67));
		System.out.println(c1.add(3,7));
		System.out.println("----------------");
		Predicate<Integer> f1=n->(n%2)==0;
		System.out.println(f1.test(23));
		System.out.println(f1.test(56));
		System.out.println("----------------");
		Function<Integer, Integer> f2=n->n*n;
		System.out.println(f2.apply(23));
		System.out.println(f2.apply(56));
		System.out.println("----------------");
		BiFunction<Integer, Integer, Integer> f3=(n,p)->n*p;
		System.out.println(f3.apply(23,56));
		System.out.println(f3.apply(56,87));
		System.out.println("----------------");
		BiFunction<Integer, Integer, Integer> f4=(num1,num2)->(num1>num2)?num1:num2;
		System.out.println(f4.apply(23, 89));
		System.out.println("----------------");
	}

}
