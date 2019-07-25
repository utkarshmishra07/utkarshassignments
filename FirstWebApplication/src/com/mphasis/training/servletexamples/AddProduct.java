package com.mphasis.training.servletexamples;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mphasis.cart.beans.Product;
import com.mphasis.cart.dao.ProductDao;
import com.mphasis.cart.dao.ProductdaoImpl;

/**
 * Servlet implementation class AddProduct
 */
@WebServlet("/Add")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ProductDao productDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProduct() {
       productDao=new ProductdaoImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();

		HttpSession session= request.getSession();
		
        String id=request.getParameter("pid");
        String name=request.getParameter("pname");
        String cost=request.getParameter("cost");
        String quantity=request.getParameter("quantity");
        try {
        	if (id.isEmpty())
        	{
               Product p=new Product();
               p.setPname(name);
               p.setCost(Double.parseDouble(cost));
               p.setQuantity(Integer.parseInt(quantity));
               
               out.println("Successfully added product"); 
               int i=productDao.addProduct(p);
               if(i>0) {
               //RequestDispatcher rd=request.getRequestDispatcher("products.jsp");
            	   List<Product> products=productDao.getAll();
           		session.setAttribute("products", products);
               response.sendRedirect("Product.jsp");}
        	}
        	else
        	{
        		int pid = Integer.parseInt(id);
        		double pcost= Double.parseDouble(cost);
        		int pquantity= Integer.parseInt(quantity);
    
        		productDao.updateProduct(pid, name, pcost, pquantity);
        		
        		List<Product> products=productDao.getAll();
        		
        		session.setAttribute("products", products);
        		request.getRequestDispatcher("Product.jsp").forward(request, response);
        		
        	}
        }catch(Exception e) {
               out.println("already product existing with id");
               response.sendRedirect("AddProduct.jsp");
               e.printStackTrace();
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
