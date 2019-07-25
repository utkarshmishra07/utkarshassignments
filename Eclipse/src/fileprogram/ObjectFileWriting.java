/**
 * 
 */
package fileprogram;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import Beans.Employee;

/**
 * @author utkarsh.mishra1
 *
 */
public class ObjectFileWriting {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws IOException, ClassNotFoundException {
		
		Scanner sc=new Scanner(System.in);
		Employee e1= new Employee();
		System.out.println("enter employee details");
		e1.setEmpid(sc.nextInt());
		e1.setEname(sc.next());
		e1.setAddress(sc.next());
		
		FileOutputStream fos=new FileOutputStream("employees.txt");
		BufferedOutputStream bos=new BufferedOutputStream(fos);
		ObjectOutputStream oos=new ObjectOutputStream(bos);
		oos.writeObject(e1);
		oos.close();
		fos.close();
		
		FileInputStream fis=new FileInputStream("employees.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Employee e12=(Employee) ois.readObject();
		System.out.println(e12/*.getEmpid()+" "+e12.getEname()+" "+e12.getAddress() //used whentoString not used*/);
		ois.close();
		fis.close();
		sc.close();
		
		
		

	}

}
