/**
 * 
 */
package Beans;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author utkarsh.mishra1
 *
 */
public class StudentList {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		List<Student> students=new ArrayList<>();
		students.add(new Student(12, "name2", 50, 17));
		students.add(new Student(14, "name1", 60, 16));
		students.add(new Student(13, "name5", 70, 18));
		students.add(new Student(16, "name4", 65, 20));
		students.add(new Student(15, "name3", 45, 15));
		for(Student s:students) {
			System.out.println(s.getsId()+" "+s.getsName()+" "+s.getsMarks()+" "+s.getsAge());
		}
		System.out.println("1. Students based on ID\n2. Students based on Names\n3.Students based on Marks\n4.Students based on Age\n");
		Scanner sc= new Scanner(System.in);
		int choice=sc.nextInt();
		switch(choice){
			case 1:
				Collections.sort(students);
				for(Student s:students) {
					System.out.println(s.getsId()+" "+s.getsName()+" "+s.getsMarks()+" "+s.getsAge());
				}
			break;
			case 2:
				Collections.sort(students, Comparator.comparing(Student::getsName));
				for(Student s:students) {
					System.out.println(s.getsId()+" "+s.getsName()+" "+s.getsMarks()+" "+s.getsAge());
				}
			break;
			case 3:
				Collections.sort(students, new Comparator<Student>() {
					public int compare(Student s1,Student s2) {
						if(s1.getsAge()>s2.getsAge()) return -1;
						else if(s1.getsAge()<s2.getsAge()) return 1;
						else return 0;
					}
				});		
				/*Collections.sort(students,new Comparator<Student>() {
					public int compare(Student s1, Student s2) {
						return s1.getsAge()-s2.getsAge();
					}
				});*/
				for(Student s:students) {
					System.out.println(s.getsId()+" "+s.getsName()+" "+s.getsMarks()+" "+s.getsAge());
				}
			break;
			case 4:
				Collections.sort(students,(s1,s2)-> s1.getsMarks()-s2.getsMarks());
			
				for(Student s:students) {
					System.out.println(s.getsId()+" "+s.getsName()+" "+s.getsMarks()+" "+s.getsAge());
				}
			break;
			default:
				System.out.println("Invalid case");
		}
		
		sc.close();
		
	}

}
