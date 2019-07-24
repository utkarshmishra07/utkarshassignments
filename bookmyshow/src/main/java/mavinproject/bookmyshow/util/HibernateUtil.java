package mavinproject.bookmyshow.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import mavinproject.bookmyshow.beans.Admin;
import mavinproject.bookmyshow.beans.Hall;
import mavinproject.bookmyshow.beans.Movies;
import mavinproject.bookmyshow.beans.Theater;
import mavinproject.bookmyshow.beans.User;


public class HibernateUtil {
	
	public static SessionFactory getSessionFactory() {
		Configuration con=new Configuration();
		Properties props=new Properties();
		props.put(Environment.DRIVER, "oracle.jdbc.driver.OracleDriver");
		props.put(Environment.URL, "jdbc:oracle:thin:@localhost:1521:xe");
		props.put(Environment.USER, "nano");
		props.put(Environment.PASS, "nano");
		props.put(Environment.DIALECT, "org.hibernate.dialect.OracleDialect");
		props.put(Environment.SHOW_SQL, "true");
		props.put(Environment.HBM2DDL_AUTO, "update");
		
		con.setProperties(props);
		con.addAnnotatedClass(User.class);
		con.addAnnotatedClass(Admin.class);
		con.addAnnotatedClass(Hall.class);
		con.addAnnotatedClass(Theater.class);
		con.addAnnotatedClass(Movies.class);
		
		
		
		StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().applySettings(con.getProperties());
		SessionFactory sessionfactory=con.buildSessionFactory(builder.build());
		return sessionfactory;
	}
}
