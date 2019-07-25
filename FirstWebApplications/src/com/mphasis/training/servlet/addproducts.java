package com.mphasis.training.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mphasis.cart.beans.Product;
import com.mphasis.cart.dao.ProductDao;
import com.mphasis.cart.dao.Productdaoimpl;

/**
 * Servlet implementation class addproducts
 */
@WebServlet("/addproduct")
public class addproducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ProductDao productDao;
    
 /**
  * @return 
 * @see HttpServlet#HttpServlet()
  */
 public  addproducts() {
     productDao =new Productdaoimpl();
     // TODO Auto-generated constructor stub
 }


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//List<Product> products=productDao.getAll();
        
				String pid=request.getParameter("pid");
	              String pname=request.getParameter("pname");
	              double cost=Double.parseDouble(request.getParameter("cost"));
	              int quantity=Integer.parseInt(request.getParameter("quantity"));
	              if(pid.isEmpty()) {
	              Product p=new Product();
	              p.setPname(pname);
	              p.setCost(cost);
	              p.setQuantity(quantity);
	              System.out.println(p);
	           int i= productDao.addProduct(p); 	  
	       	  response.sendRedirect("addproduct.jsp");
	              }else {
	      				           
	            		  			int pid1= Integer.parseInt(pid);
	            		  			
	            		  			double costy=Double.parseDouble(request.getParameter("cost"));
	            		              int quantityy=Integer.parseInt(request.getParameter("quantity"));
	            		  			int i=productDao.updateProduct(pid1, costy,pname, quantityy);
	            		  			
	            		  			List<Product>products=productDao.getAll();
	            		  			HttpSession session= request.getSession();
	            		  			session.setAttribute("products", products);

	            		  			request.getRequestDispatcher("Product.jsp").forward(request, response);

	            		  		}
	            		   

	    	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
