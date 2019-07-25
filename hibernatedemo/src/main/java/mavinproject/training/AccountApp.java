/**
 * 
 */
package mavinproject.training;

import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import mavinproject.training.beans.Account;
import mavinproject.training.beans.CurrentAccount;
import mavinproject.training.beans.Employee;
import mavinproject.training.beans.SavingsAccount;
import mavinproject.training.conf.HibernateUtil;


/**
 * @author utkarsh.mishra1
 *
 */

public class AccountApp {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Criteria cr=session.createCriteria(SavingsAccount.class);
		cr.add(Restrictions.gt("balance", 2000));
		List<SavingsAccount> res=cr.list();
		res.forEach(new Consumer<SavingsAccount>() {
			public void accept(SavingsAccount e1) {
				System.out.println(e1);
			}
		});
		
		Query q=session.createQuery("from SavingsAccount where balance>2000");
		List<SavingsAccount> res1=q.list();
		res1.forEach(new Consumer<SavingsAccount>() {
			public void accept(SavingsAccount e1) {
				System.out.println(e1);
			}
		});
		
		Query q1=session.createSQLQuery("select * from savingsaccount where balance>2000");
		List<SavingsAccount> res2=q1.list();
		res2.forEach(new Consumer<SavingsAccount>() {
			public void accept(SavingsAccount e1) {
				System.out.println(e1);
			}
		});
		
/*		Account a1=new Account();
		a1.setName("name1");
		a1.setAcc_date(new Date());
		
		SavingsAccount a2=new SavingsAccount();
		a2.setAcc_date(new Date());
		a2.setBalance(342423);

				
		
		CurrentAccount a3=new CurrentAccount();
		a3.setType("CA");
		a3.setName("Name3");
		
		session.save(a1);
		session.save(a2);
		session.save(a3);
		*/
		
	
		tr.commit();
		session.close();
		
	}

}
