package com.mphasis.cart.view;

import java.util.List;
import java.util.Scanner;

import com.mphasis.cart.beans.CartA;
import com.mphasis.cart.beans.Product;
import com.mphasis.cart.bo.CartAUserBo;
import com.mphasis.cart.bo.CartAUserBoImpl;
import com.mphasis.cart.dao.CartADao;
import com.mphasis.cart.dao.CartAUserDao;
import com.mphasis.cart.dao.ProductDao;
import com.mphasis.cart.dao.Productdaoimpl;
import com.mphasis.cart.exceptions.BuisnessException;

public class CartApp {

	public static void main(String[] args) throws BuisnessException
	{
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		ProductDao pdao=new Productdaoimpl();
		CartAUserBo dao=new CartAUserBoImpl();
System.out.println("welcome to CartA");
System.out.println("1. Register \n 2.Login");
int option=sc.nextInt();


if(option==1) {
	System.out.println("enter you details");
	CartA user=new CartA();
	System.out.println("enter user id");
	user.setUserid(sc.nextInt());
	System.out.println("enter Username");
	user.setUsername(sc.next());
	System.out.println("enter email");
	user.setEmailid(sc.next());
	System.out.println("enter password");
	user.setPassword(sc.next());
	System.out.println("enter credit card number");
	user.setCrcardno(sc.nextLong());
	System.out.println("enter gender");
	user.setGender(sc.next());
	try {
		dao.register(user);
	}catch(BuisnessException b)
	{
		System.out.println(b.getMessage());
	}
	
	System.out.println("Registered successfully");
	do {
	System.out.println("1. Products \n 2. Logout");
	  int ch=sc.nextInt();
	  if(ch==1) {
		  System.out.println("List of products");
		  List<Product> products=pdao.getAll();
		  products.forEach((p)-> System.out.println(p));
	  }
	  else if(ch==2) {
		  System.out.println("Thanks for using");
		  System.exit(0);
	  }
	}while(true);
}else if(option==2) {
   System.out.println("Enter email and password for login");
   String ema=sc.next();
   String pas=sc.next();
   CartA cuser=dao.login(ema, pas);
  try {
	  if(ema.equals(cuser.getEmailid()) && pas.equals(cuser.getPassword()))
	   System.out.println("Login Success\n Welcome"+cuser.getUsername());
	  else {
		  System.out.println("invalid credentials");
	      System.out.println("login again");
	      System.exit(0);}
	  
  }catch(NullPointerException e) {
  System.out.println("invalid");
  }
  do {
	   System.out.println("1.Add Product\n2.Update\n3.delete\n4. Retive \n 5. Change password\n 6.By Id \n 7.by name");
	   int ch=sc.nextInt();
	   switch(ch) {
	   case 1: System.out.println("enter the Product details");
	   Product p=new Product();
	   System.out.println("enter id");
	   p.setPid(sc.nextInt());
	   System.out.println("enter p name");
	   p.setPname(sc.next());
	   System.out.println("enter cost");
	   p.setCost(sc.nextDouble());
	   System.out.println("enter qty");
	   p.setQuantity(sc.nextInt());
	   int i=pdao.addProduct(p);
	   if(i>0) System.out.println("product added");
	   else System.out.println("product not addedd");
	   break;
	   case 2: System.out.println("enter pid, cost and qty");
	    int j=pdao.updateProduct(sc.nextInt(), sc.nextDouble(),sc.next(), sc.nextInt());
	    if(j>0) System.out.println("product updated");
	    else System.out.println("product not updated");
		   break;
	   case 3: System.out.println("enter pid to delete");
	   int k=pdao.deleteProduct(sc.nextInt());
	   if(k>0) System.out.println("product deleted");
	    else System.out.println("product not deleted");
		   break;
	   case 4:System.out.println("List of products");
		  List<Product> products=pdao.getAll();
		  products.forEach((pr)-> System.out.println(pr));
		  break;
	   case 5: System.out.println("enter the old pass and new pass");
	   try {
	   	int m=dao.changePassword(sc.next(),sc.next());
	      if(m>0) 
	      System.out.println("password changed");
	      else 
	    	  System.out.println("password not changed");
	   }catch(BuisnessException b)
	   {
		   System.out.println(b.getMessage());
	   }
	   break;
	   case 6:System.out.println("enter id");
	   Product pr=pdao.getById(sc.nextInt());
	   System.out.println(pr);
		   break;
	   case 7:System.out.println("enter product name");
	   List<Product> ps=pdao.getProductByName(sc.next());
	   ps.forEach((pl)-> System.out.println(pl));
 		   break;
	   case 8: System.out.println("Thanks");
	   System.exit(0);
	   default: System.out.println("invalid");
	   }
	   }while(true);
   }

else {
		System.out.println("invalid selection");
}
sc.close();

	}

}