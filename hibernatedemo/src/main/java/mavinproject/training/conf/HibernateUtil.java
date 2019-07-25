package mavinproject.training.conf;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

import mavinproject.training.beans.Account;
import mavinproject.training.beans.CurrentAccount;
import mavinproject.training.beans.SavingsAccount;

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
		props.put(Environment.USE_SECOND_LEVEL_CACHE, "true");
		props.put(Environment.CACHE_REGION_FACTORY, "org.hibernate.cache.ehcache.EhCacheRegionFactory");

		con.setProperties(props);
		/*con.addAnnotatedClass(Employee.class);
		con.addAnnotatedClass(Department.class);*/
		con.addAnnotatedClass(SavingsAccount.class);
		con.addAnnotatedClass(CurrentAccount.class);
		con.addAnnotatedClass(Account.class);
		
		
		StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().applySettings(con.getProperties());
		SessionFactory sessionfactory=con.buildSessionFactory(builder.build());
		return sessionfactory;
	}
}
