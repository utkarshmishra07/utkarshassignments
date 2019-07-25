package mavinproject.training.dao;

import java.util.List;
import java.util.function.Consumer;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import mavinproject.training.beans.Employee;
import mavinproject.training.beans.SavingsAccount;
import mavinproject.training.conf.HibernateUtil;
public class EmployeeDaoImpl implements EmployeeDao {


	SessionFactory sf=HibernateUtil.getSessionFactory();
	Session session=sf.openSession();
	Transaction tr=session.beginTransaction();
       public Employee getEmployeeById(int empid) {
              Employee e=null;
        try {


               e=(Employee)session.createCriteria(Employee.class).add(Restrictions.eq("empid",empid)).list();
               tr.commit();         
        }
        catch(Exception e1) {}
               
        return e;
       }

       public void addEmployee(Employee e) {
              
        try {
               session=sf.openSession();
               tr=session.beginTransaction();
               session.save(e);
               tr.commit();
               session.close();
               
        }
        catch(Exception e1) {}
       }
       
       

       public void updateEmployee(Employee e) {
              try {
             session=sf.openSession();
             tr=session.beginTransaction();
             session.update(e);
             tr.commit();
             session.close();
             
      }
      catch(Exception e1) {
         
      }
       }
       

       public void removeEmployee(int empid) {
        try {
               session=sf.openSession();
               tr=session.beginTransaction();
session.delete(session.get(Employee.class,empid));
               
               tr.commit();
        
               
        }
        catch(Exception e1) {
             
        }
       }
       
       
  
       public List<Employee> getBySalary(int salary) {
              Session session=sf.openSession();
         Transaction tr=session.beginTransaction();
         List<Employee> employees=session.createCriteria(Employee.class).add(Restrictions.eq("salary",salary)).list();
         tr.commit();
         return employees;
       }
       
       

       public List<Employee> getAll() {
                Session session=sf.openSession();
          Transaction tr=session.beginTransaction();           
          List<Employee> employees=session.createCriteria(Employee.class).list();
          tr.commit();
          
          session.close();
          return employees;
       }

	public List<Employee> getEmployeeByName(String empname) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Employee> getEmployeeBySalary(double salary) {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateEmployee(int eid) {
		// TODO Auto-generated method stub
		
	}

	
	
}

/*public class EmployeeDaoImpl implements EmployeeDao {
	
	public void addEmployee(Employee e) {
		try {
			SessionFactory sf=HibernateUtil.getSessionFactory();
			Session session=sf.openSession();
			Transaction tr=session.beginTransaction();
			tr.commit();
			session.close();
			
		}catch(Exception d) {
			d.printStackTrace();
		}
		int i = 0;
		try {
			String sql="insert into product values(pseq.nextval,?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			//pst.setInt(1, p.getPid());
			pst.setString(1, p.getPname());
			pst.setInt(2, p.getQuantity());
			pst.setDouble(3, p.getCost());
	
			i=pst.executeUpdate();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return i;
	
	}

	public void removeEmployee(int empid) {
		// TODO Auto-generated method stub
		
	}

	public Employee getEmployeeById(int empid) {
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session session=sf.openSession();
		Transaction tr=session.beginTransaction();
		Criteria cr=session.createCriteria(Employee.class);
		Employee e=new Employee();
		e=(Employee)cr.add(Restrictions.idEq(empid));
		tr.commit();
		session.close();
		return e;
	}

	public List<Employee> getEmployeeByName(String empname) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Employee> getEmployeeBySalary(double salary) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void updateEmployee(int eid) {
		// TODO Auto-generated method stub
		
	}
}
*/