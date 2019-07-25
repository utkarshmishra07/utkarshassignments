package com.mphasis.training.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
* Servlet implementation class Product
*/
@WebServlet("/product")
public class ProductServlet extends HttpServlet {
                private static final long serialVersionUID = 1L;
       ProductDao productDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
    productDao=new Productdaoimpl();
        // TODO Auto-generated constructor stub
    }

                /**
                * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
                */
             protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  
            	 List<Product> products=productDao.getAll();
            	 HttpSession session1=request.getSession();
            	 session1.setAttribute("products",products);
            	 response.sendRedirect("Product.jsp");
            	 }

                /**
                * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
                */
                protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                                // TODO Auto-generated method stub
                                doGet(request, response);
                }

}
