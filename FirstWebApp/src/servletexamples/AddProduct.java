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
 * Servlet implementation class AddProduct
 */
@WebServlet("/addproduct")
public class AddProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDao productDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddProduct() {
		productDao = new ProductDaoImpl();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * response.setHeader("Cache-Control",
		 * "no-cache,no-store,must-revalidate");//http1.1 response.setHeader("Pragma",
		 * "no-cache");//http1.0 response.setHeader("Expires", "0");//proxies
		 */
		String pid = request.getParameter("pid");
		String pname = request.getParameter("pname");

		int qty = Integer.parseInt(request.getParameter("qty"));
		Double cost = Double.parseDouble(request.getParameter("cost"));
		HttpSession session = request.getSession();
		if (pid.isEmpty()) {
			Product p = new Product();
			p.setPname(pname);
			p.setQty(qty);
			p.setCost(cost);
			
			System.out.println(p);
			/* int i= */productDao.addProduct(p);
			List<Product> products=productDao.getAll();
			session.setAttribute("products", products);
			
			response.sendRedirect("products.jsp");
		} else {

			int pid1 = Integer.parseInt(pid);

			Double costy = Double.parseDouble(request.getParameter("cost"));
			int quantityy = Integer.parseInt(request.getParameter("qty"));

			int i = productDao.updateProduct(pid1, costy, quantityy);

			List<Product> products = productDao.getAll();
//			request.setAttribute("readonly", "readonly");
			request.getRequestDispatcher("addproduct.jsp");

			session.setAttribute("products", products);

			request.getRequestDispatcher("products.jsp").forward(request, response);

		}

		/*-------------------------------------------*/

		/*
		 * PrintWriter out=response.getWriter();
		 * 
		 * response.setContentType("text/html"); HttpSession
		 * session=request.getSession(false); String
		 * s=session.getAttribute("sname").toString(); try { String
		 * pid=request.getParameter("pid"); if(pid == null) { String
		 * pname=request.getParameter("pname"); int
		 * qty=Integer.parseInt(request.getParameter("qty")); int
		 * cost=Integer.parseInt(request.getParameter("cost"));
		 * out.print("Add Product Page "+s); RequestDispatcher
		 * rd1=request.getRequestDispatcher("menu.html"); rd1.include(request,
		 * response); Product p=new Product(); p.setPname(pname); p.setQty(qty);
		 * p.setCost(cost); productDao.addProduct(p);
		 * out.print("Product Added Successfully"); response.sendRedirect("product");
		 * }else { String pid1=request.getParameter("pid"); String
		 * pname=request.getParameter("pname"); String qty=request.getParameter("qty");
		 * String cost=request.getParameter("cost"); out.print("Edit Product Page "+s);
		 * RequestDispatcher rd1=request.getRequestDispatcher("menu.html");
		 * rd1.include(request, response);
		 * 
		 * request.getRequestDispatcher("addproduct.jsp").forward(request, response);
		 * productDao.updateProduct(Integer.parseInt(pid1), Double.parseDouble(cost),
		 * Integer.parseInt(qty)); out.print("Product Added Successfully"); }
		 * 
		 * }catch(NullPointerException e) { out.println("Not Added");
		 * e.printStackTrace(); RequestDispatcher
		 * r=request.getRequestDispatcher("addproduct"); r.include(request, response); }
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
