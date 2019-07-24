package servletexamples;

import java.io.IOException;
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
 * Servlet implementation class EditServlet
 */
@WebServlet("/edit")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductDao dao = null;
    Product p = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
    	 dao = new ProductDaoImpl();

        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String pid = request.getParameter("pid");
//		 String readonly = request.getParameter("readonly");
         Product p = dao.getById(Integer.parseInt(pid));
         HttpSession session= request.getSession();
         session.setAttribute("product", p);
//         request.setAttribute("readonly", readonly);
         
         request.getRequestDispatcher("addproduct.jsp").forward(request, response);
		}

   
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
