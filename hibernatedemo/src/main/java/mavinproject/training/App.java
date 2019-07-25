package mavinproject.training;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


import mavinproject.training.beans.Employee;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       /* Employee e1=new Employee();
        e1.setEmpid(102);
        e1.setEmpName("koi");
        e1.setSalary(99349);*/
    	Employee e1=null;
        
        Configuration con=new Configuration().configure().addAnnotatedClass(Employee.class);
//        ServiceRegistry reg=new ServiceRegistryBuilder().applySetting(con.getProperties(), con.);
        		SessionFactory sFactory=con.buildSessionFactory();
        		Session session=sFactory.openSession();
        		Transaction tr=session.beginTransaction();
        		//session.save(e1); //for inserting
        		e1=(Employee) session.get(Employee.class, 101);	//for retrieving
        		System.out.println(e1);
        		e1=(Employee) session.get(Employee.class, 102);	//for retrieving
        		System.out.println(e1);
/*        		List<Employee> employees=session.createCriteria(Employee.class).list();
        		employees.forEach((e)->System.out.println(e));*/
        		tr.commit();
        		session.close();
        		System.out.println("Done!");
    }
}
