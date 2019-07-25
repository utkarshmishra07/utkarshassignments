package mavinproject.SpringDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import mavinproject.beans.Car;
import mavinproject.beans.DieselEngine;
import mavinproject.beans.PetrolEngine;
import mavinproject.beans.Tyre;
import mavinproject.config.AppConfig;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

		PetrolEngine e1 = (PetrolEngine) context.getBean("petrolEngine");

		Car c = (Car) context.getBean("car");
		c.setEngine(e1);
		System.out.println(c);
		DieselEngine d1 = (DieselEngine) context.getBean("dieselEngine");
		c.setEngine(d1);
		System.out.println(c);
		Tyre t1=(Tyre)context.getBean("tyre");
		System.out.println(t1);
		
    }
}
