package servletexamples;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/deleteservlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDao productDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
    productDao=new ProductDaoImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter out=response.getWriter();
		
		response.setContentType("text/html");
	//	HttpSession session=request.getSession(false);
	//	String s=session.getAttribute("sname").toString();
	//	out.print("Delete Product Page "+s);
		try{RequestDispatcher rd=request.getRequestDispatcher("menu.html");
		rd.include(request, response);
		int pid=Integer.parseInt(request.getParameter("pid"));

		//Product p=new Product();
		//p.setPid(pid);
		productDao.deleteProduct(pid);
		out.print("Product Deleted Successfully");
		response.sendRedirect("product");
		/*RequestDispatcher d=request.getRequestDispatcher("product");
		d.include(request, response);*/
		/*if(Integer.toString(p.getPid()).isEmpty()) {
		}*/
		
		}catch(NullPointerException e) {
			out.println("Not Deleted");
			e.printStackTrace();
			RequestDispatcher r=request.getRequestDispatcher("deleteproduct");
			r.include(request, response);
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
