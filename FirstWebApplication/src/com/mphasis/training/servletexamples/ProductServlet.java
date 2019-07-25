package com.mphasis.training.servletexamples;

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
import com.mphasis.cart.dao.ProductdaoImpl;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/Product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ProductDao productDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
       productDao=new ProductdaoImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		try{
			HttpSession session=request.getSession(false);
		String s=session.getAttribute("sname").toString();
		out.print("Product page" +s );
		List<Product> products=productDao.getAll();
		session.setAttribute("products", products);
		
		RequestDispatcher rd=request.getRequestDispatcher("Product.jsp");
		rd.include(request, response);
		
	/*	List<Product> products=productDao.getAll();
		out.print("<table border='1'>");
		out.print("<tr><th>Pid</th><th>Pname</th><th>Cost</th><th>Quantity</th><th>Buy</th></tr>");
		for(Product p:products) {
			out.print("<tr>");
			out.print("<td>"+p.getPid()+"</td>");
			out.print("<td>"+p.getPname()+"</td>");
			out.print("<td>"+p.getCost()+"</td>");
			out.print("<td>"+p.getQuantity()+"</td>");
			//out.print("<td><a>Buy</a></td>");
			out.print("</tr>");
			
		}
		out.print("</table>");*/
		
		}catch(NullPointerException e) {
			out.print("Login First");
			RequestDispatcher rd=request.getRequestDispatcher("Login.html");
			rd.include(request, response);
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
