/**
 * 
 */
package shoppingcart;

import java.util.List;
import java.util.Scanner;

import shoppingcart.CartAUser;
import shoppingcart.Product;
import shoppingcart.CartAUserDao;
import shoppingcart.CartAUserDaoImpl;
import shoppingcart.ProductDao;
import shoppingcart.ProductDaoImpl;

public class ShoppingCart {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws BusinessException{
		/*System.out.println("Welcome to CartA\nIndia's no.1 shopping market\n\n"
						+"1.Register\n"
						+"2.Login\n"
						+"3.retrive prod, retrive prod by id, pord by name, add prod, update, delete, exit");
	Scanner sc=new Scanner(System.in);
	int option=sc.nextInt();
	CartAUserDao cdao=new CartAUserDaoImpl();
	ProductDao pdao=new ProductDaoImpl(); 
	if(option==1) {
		System.out.println("Enter your details");
		CartAUser user=new CartAUser();	
		Product prod=new Product();
		System.out.println("Enter user ID");
		user.setUserid(sc.nextInt());
		System.out.println("Enter User name");
		user.setUsername(sc.next());
		System.out.println("Enter Email");
		user.setEmail(sc.next());
		System.out.println("Enter Password");
		user.setPassword(sc.next());
		System.out.println("Enter Credit Card number");
		user.setCredit(sc.nextInt());
		System.out.println("Enter Gender(m/f)");
		user.setGender(sc.next());
		cdao.register(user);
		System.out.println("Registered Successfully!");
		pdao.addProduct(prod);
		pdao.deleteProduct(prod.getPid());
		pdao.getProductByName(prod.getPname());
		pdao.getById(prod.getPid());
		pdao.getAll();
		pdao.updateProduct(prod.getPid(),prod.getCost(),prod.getQty());
		
		
		
		
	}else if(option==2) {
		System.out.println("Enter email and password for login");
	}else {
		System.out.println("Invalid Selection");
	}*/
		
		Scanner sc=new Scanner(System.in);
		ProductDao pdao=new ProductDaoImpl();
		CartAUserBo dao=new CartAUserBoImpl();
System.out.println("Welcome to CartA\nIndia's no.1 shopping market\n\n");
System.out.println("1. Register \n 2.Login");
int option=sc.nextInt();


if(option==1) {
	System.out.println("Enter Your Details");
	CartAUser user=new CartAUser();
	System.out.println("Enter User ID");
	user.setUserid(sc.nextInt());
	System.out.println("Enter Username");
	user.setUsername(sc.next());
	System.out.println("Enter Email");
	user.setEmail(sc.next());
	System.out.println("Enter Password");
	user.setPassword(sc.next());
	System.out.println("Enter Credit Card Number");
	user.setCredit(sc.nextLong());
	System.out.println("Enter Gender");
	user.setGender(sc.next());
	try {
	dao.register(user);
	}catch(BusinessException b){
		b.getMessage();
	}
	System.out.println("Registered Successfully");
	do {
	System.out.println("1. Products \n 2. Logout");
	  int ch=sc.nextInt();
	  if(ch==1) {
		  System.out.println("List of products");
		  List<Product> products=pdao.getAll();
		  products.forEach((p)-> System.out.println(p));
	  }
	  else if(ch==2) {
		  System.out.println("Thanks for using our App");
		  System.exit(0);
	  }
	}while(true);
}else if(option==2) {
   System.out.println("Enter Email and Password for Login");
   String ema=sc.next();
   String pas=sc.next();
   CartAUser cuser=dao.login(ema, pas);
  try {
	  if(ema.equals(cuser.getEmail()) && pas.equals(cuser.getPassword()))
	   System.out.println("Login Success\n Welcome "+cuser.getUsername());
	  else {
		  System.out.println("Invalid Credentials");
	      System.out.println("Try Again");
	      System.exit(0);}
	  
  }catch(NullPointerException e) {
  System.out.println("Invalid");
  }
  do {
	   System.out.println("1.Add Product\n2.Update\n3.Delete\n4. Retrieve \n 5. Change password\n 6.By Id \n 7.By name");
	   int ch=sc.nextInt();
	   switch(ch) {
	   case 1: System.out.println("Enter the Product details");
	   Product p=new Product();
	   System.out.println("Enter ID");
	   p.setPid(sc.nextInt());
	   System.out.println("Enter Product Name");
	   p.setPname(sc.next());
	   System.out.println("Enter Cost");
	   p.setCost(sc.nextDouble());
	   System.out.println("Enter Qty");
	   p.setQty(sc.nextInt());
	   int i=pdao.addProduct(p);
	   if(i>0) System.out.println("Product is Added");
	   else System.out.println("Product not Added");
	   break;
	   case 2: System.out.println("Enter Product ID, Cost and Quantity");
	    int j=pdao.updateProduct(sc.nextInt(), sc.nextDouble(), sc.nextInt());
	    if(j>0) System.out.println("Product Updated");
	    else System.out.println("Product is not Updated");
		   break;
	   case 3: System.out.println("Enter Product ID to Delete");
	   int k=pdao.deleteProduct(sc.nextInt());
	   if(k>0) System.out.println("Product Deleted");
	    else System.out.println("Product is not Deleted");
		   break;
	   case 4:System.out.println("List of products");
		  List<Product> products=pdao.getAll();
		  products.forEach((pr)-> System.out.println(pr));
		  break;
	   case 5: System.out.println("Enter the Old password and New password");
	     try {
	      int m=dao.changePassword(sc.next(), sc.next());
	      if(m>0) 
	      System.out.println("Password Changed");
	      else 
	    	  System.out.println("Password is not Changed");
	     }catch(BusinessException b) {
	    	 System.out.println(b.getMessage());
	     } 
	     break;
	   case 6:System.out.println("Enter ID");
	   Product pr=pdao.getById(sc.nextInt());
	   System.out.println(pr);
		   break;
	   case 7:System.out.println("Enter Product Name");
	   List<Product> ps=pdao.getProductByName(sc.next());
	   ps.forEach((pl)-> System.out.println(pl));
 		   break;
	   case 8: System.out.println("Thanks");
	   System.exit(0);
	   default: System.out.println("Invalid");
	   }
	   }while(true);
   }

else {
		System.out.println("Invalid Selection");
}


		
	}

}
