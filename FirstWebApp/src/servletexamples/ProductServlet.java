package servletexamples;

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

import shoppingcart.Product;
import shoppingcart.ProductDao;
import shoppingcart.ProductDaoImpl;

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
    productDao=new ProductDaoImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Product> products=productDao.getAll();
		//int add=productDao.addProduct(p);
		HttpSession session1=request.getSession();
		request.setAttribute("readonly", " ");
		request.getRequestDispatcher("addproduct.jsp");
		session1.setAttribute("products", products);
		RequestDispatcher rd=request.getRequestDispatcher("products.jsp");
		rd.include(request, response);
		//response.sendRedirect("products.jsp");
		
		
		/*response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");//http1.1
		response.setHeader("Pragma", "no-cache");//http1.0
		response.setHeader("Expires", "0");//proxies
		PrintWriter out=response.getWriter();
		try{

		response.setContentType("text/html");
		HttpSession session=request.getSession(false);
		String s=session.getAttribute("sname").toString();
		out.print("Product page "+s);
		RequestDispatcher rd=request.getRequestDispatcher("menu.html");
		rd.include(request, response);
		
		List<Product> products=productDao.getAll();
		System.out.println(products);
		out.print("<table border='1' align='center'>"
				+ "<tr>"
				+ "<th>PID</th>"
				+ "<th>Pname</th>"
				+ "<th>Cost</th>"
				+ "<th>Quantity</th>"
				+ "<th>Buy</th>"
				+ "</tr>");
		for(Product p:products) {
			out.print("<tr>");
			out.print("<td>"+p.getPid()+"</td>");
			out.print("<td>"+p.getPname()+"</td>");
			out.print("<td>"+p.getCost()+"</td>");
			out.print("<td>"+p.getQty()+"</td>");
			out.print("<td><a href=#>Buy</a></td>");
			out.print("</tr>");
		}
		out.print("</table>");
		
		}catch(NullPointerException e) {
			out.println("Not logged in");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
				
		}*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
