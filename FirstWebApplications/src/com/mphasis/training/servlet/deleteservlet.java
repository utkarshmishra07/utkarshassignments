package com.mphasis.training.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mphasis.cart.dao.ProductDao;
import com.mphasis.cart.dao.Productdaoimpl;

/**
 * Servlet implementation class deleteservlet
 */
@WebServlet("/delete")
public class deleteservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ProductDao productdao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteservlet() {
      
        productdao=new Productdaoimpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	int pid=Integer.parseInt(request.getParameter("pid"));
	int i=productdao.deleteProduct(pid);
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
