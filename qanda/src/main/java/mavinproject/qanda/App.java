package mavinproject.qanda;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import mavinproject.qanda.beans.Question;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
         System.out.println((Question)context.getBean("q1"));

    }
}
