package mavinproject.SpringDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mavinproject.beans.Car;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context=new ClassPathXmlApplicationContext("application.xml");
        Car c=(Car)context.getBean("c1");
        System.out.println(c.getModel()+" "+c.getCost()+" "+c.getEngine()+" "+c.getTyre());        
    }
}
