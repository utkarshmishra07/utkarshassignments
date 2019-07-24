/**
 * 
 */
package mavinproject.bookmyshow;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import mavinproject.bookmyshow.beans.Admin;
import mavinproject.bookmyshow.beans.Hall;
import mavinproject.bookmyshow.beans.Movies;
import mavinproject.bookmyshow.beans.Theater;
import mavinproject.bookmyshow.beans.User;
import mavinproject.bookmyshow.util.HibernateUtil;

/**
 * @author utkarsh.mishra1
 *
 */

public class MovieApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Movies m=new Movies();
	    m.setMid(104);
	    m.setMname("Spiderman");
		
	    User u=new User();
		u.setUserid(100);
		u.setUname("Utkarsh");
		u.setUpassword("pass");

		
		
		Theater t=new Theater();
        t.setTid(1000);
        t.setTname("Inox");
        t.setTlocation("Bangluru");
        t.setNhall(6);
		
        Hall h=new Hall();
        h.setHid(104);
        h.setHname("nahi");
        h.setHtype("Big");
        h.setHprice(500);
        
       
        
        Admin a=new Admin();
        a.setAid(1);
        a.setApassword("admin");
        
            
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		
		session.save(u);
		session.save(t);
		session.save(h);
		session.save(m);
		session.save(a);
		
		tr.commit();
		session.close();
		System.out.println("Done");

	}

}
