package servletexamples;

import java.io.IOException;
import java.io.PrintWriter;
/*import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;*/

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import shoppingcart.CartAUser;
import shoppingcart.CartAUserBo;
import shoppingcart.CartAUserBoImpl;

/**
 * Servlet implementation class changepassword
 */
@WebServlet("/changepassword")
public class changepassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CartAUserBo cartAUserBo;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changepassword() {
    	cartAUserBo=new CartAUserBoImpl();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");//http1.1
		response.setHeader("Pragma", "no-cache");//http1.0
		response.setHeader("Expires", "0");//proxies
		PrintWriter out=response.getWriter();
		String npass=request.getParameter("npass");
	//	String email=request.getParameter("email");
		String opass=request.getParameter("opass");
		
		
		
		//String lan[]=request.getParameterValues("lan");
		
		
		try {
		/*	con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","nano","nano");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select password from cartauser where email=?");
			
			*/
			int user =cartAUserBo.changePassword(opass, npass);
		if (user>0) {
			response.setContentType("text/html");
			HttpSession session=request.getSession(false);
			String s=session.getAttribute("sname").toString();
			out.println("Password changed for user "+s );
			RequestDispatcher rr=request.getRequestDispatcher("menu.html");
			rr.include(request, response);
		}
			
			//if(user1.getEmail().equals(email) && user1.getPassword().equals(opass)) {
//				CartAUser user =cartAUserBo.login(name, pass);
				
			//cartAUserBo.changePassword(opass,npass);
			
			
			
		}catch(Exception e) {
			out.print("invalid credentials or not logged in");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
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
