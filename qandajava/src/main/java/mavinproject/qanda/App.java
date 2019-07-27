package mavinproject.qanda;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mavinproject.config.AppConfig;
import mavinproject.qanda.beans.Answer;
import mavinproject.qanda.beans.Question;
import mavinproject.qanda.beans.Users;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc= new Scanner(System.in);
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		Question q=(Question) context.getBean("question");
		System.out.println("Enter Qid");
		q.setQid(sc.nextInt());
		System.out.println("Enter question");
		q.setQuestion(sc.next());
		List<Answer> l=new ArrayList<Answer>();
		Answer a=(Answer) context.getBean("answer");
		System.out.println("Enter answer id");
		a.setAid(sc.nextInt());
		System.out.println("Enter answer");
		a.setAnswer(sc.next());
		Set<Users> p = new HashSet<Users>();
		Users u=(Users) context.getBean("users");
		System.out.println("Enter uid");
		u.setUid(sc.nextInt());
		System.out.println("Enter uname");
		u.setUname(sc.next());
		p.add(u);
		a.setUsers(p);
		l.add(a);
		Answer a1=(Answer) context.getBean("answer");
		System.out.println("Enter answer id");
		a1.setAid(sc.nextInt());
		System.out.println("Enter answer");
		a1.setAnswer(sc.next());
		a1.setUsers(p);
		l.add(a1);
		Answer a2=(Answer) context.getBean("answer");
		System.out.println("Enter answer id");
		a2.setAid(sc.nextInt());
		System.out.println("Enter answer");
		a2.setAnswer(sc.next());
		a2.setUsers(p);
		l.add(a2);
		Answer a3=(Answer) context.getBean("answer");
		System.out.println("Enter answer id");
		a3.setAid(sc.nextInt());
		System.out.println("Enter answer");
		a3.setAnswer(sc.next());
		a3.setUsers(p);
		l.add(a3);

		q.setAnswers(l);
		
		System.out.println(q);
		
    }
}
