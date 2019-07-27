package com.mphasis.training.SpringHibernateAssignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mphasis.training.Config.ApplicationConfig;
import com.mphasis.training.Dao.ProductDaoImpl;
import com.mphasis.training.Dao.ProductsDao;
import com.mphasis.training.Dao.SupplierDao;
import com.mphasis.training.Dao.SupplierDaoImpl;
import com.mphasis.training.entities.Products;
import com.mphasis.training.entities.Suppliers;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Scanner sc=new Scanner(System.in);
    	ApplicationContext context=new AnnotationConfigApplicationContext(ApplicationConfig.class);
    	
    
    	ProductsDao pro = (ProductsDao) context.getBean("productDaoImpl");
    	SupplierDao sup =  (SupplierDao) context.getBean("supplierDaoImpl");
    	do {
    	System.out.println("1.add supplier\n2.add products\n3.delete product\n4.update product\n5.delete supplier\n6.update supplier");
    	int choose=sc.nextInt();
    	
    	switch(choose) {
		case 1:
			Suppliers ss = new Suppliers();
			System.out.println("Enter Supplier ID");
			ss.setSid(sc.nextInt());
			System.out.println("Enter Supplier name");
			ss.setSname(sc.next());
			System.out.println("Enter Supplier Address");
			ss.setAddress(sc.next());	
			sup.addSupplier(ss);
			
			System.out.println("Supplier added");
		break;
		case 2:
			Products pp = new Products();
			System.out.println("Enter Product ID");
			pp.setPid(sc.nextInt());
			System.out.println("Enter Product name");
			pp.setPname(sc.next());
			System.out.println("Enter Product cost");
			pp.setCost(sc.nextDouble());
			System.out.println("Enter Product brand");
			pp.setBrand(sc.next());
			System.out.println("Enter Product quantity");
			pp.setQuantity(sc.nextInt());
			pro.addProducts(pp);
			System.out.println("Product added");
			List<Products> l=new ArrayList<Products>();
			
		break;
    	case 3:
    		Products pp1=new Products();
    		System.out.println("Enter Product ID");
        	int pid= sc.nextInt();
        	pro.deleteProducts(pid);
        	System.out.println("Product Deleted");
        break;
    	case 4:
    		Products pp2=new Products();
    		System.out.println("Enter Product ID");
    		pp2.setPid(sc.nextInt());
    		System.out.println("Enter Product name");
    		pp2.setPname(sc.next());
    		System.out.println("Enter Product cost");
    		pp2.setCost(sc.nextDouble());
    		System.out.println("Enter Product Brand");
    		pp2.setBrand(sc.next());
    		System.out.println("Enter Prodduct quantity");
    		pp2.setQuantity(sc.nextInt());
    		pro.updateProducts(pp2);
    		System.out.println("Product Updated");
        break;
    	case 5:
    		Suppliers ss2=new Suppliers();
    		System.out.println("Enter Supplier ID");
        	sup.deleteSupplier(sc.nextInt());
        	System.out.println("Supplier Deleted");
        break;
    	case 6:
    		Suppliers ss1 = new Suppliers();
    		System.out.println("Enter Supplier ID");
    		
    		ss1.setSid(sc.nextInt());
    		System.out.println("Enter Supplier name");
    		ss1.setSname(sc.next());
    		System.out.println("Enter Supplier address");
    		ss1.setAddress(sc.next());
    		sup.updateSupplier(ss1);
        	System.out.println("supplier update");
        	
    	
        break;
    	
    	default:
    		System.out.println("Choose a valid option!");
    	}
    	}while(true);
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	 /* ProductDao pdao=(ProductDao) context.getBean("productDaoImpl");
        Product p=new Product();
        p.setPid(22);
        p.setPname("Pen");
        pdao.addProduct(p);
       
       
       EmployeeDao edao=(EmployeeDao) context.getBean("employeeDaoImpl");
        Employee e=new Employee();
        e.setEmpid(79);
        e.setEmpName("knrrrrr");
        e.setSalary(859987856);
        
        Department d1=ddao.getDepartmentById(21);
        e.setDepartment(d1);
        edao.addEmployee(e);*/
    }
}
