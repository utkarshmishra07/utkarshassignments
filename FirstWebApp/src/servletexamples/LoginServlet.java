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

import shoppingcart.CartAUser;
import shoppingcart.CartAUserBo;
import shoppingcart.CartAUserBoImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       CartAUserBo cartAUserBo;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		String name=request.getParameter("uname");
		String pass=request.getParameter("pwd");
		//String lan[]=request.getParameterValues("lan");
		
		CartAUser user =cartAUserBo.login(name, pass);
		String r = user.getRole();
		try {
		if(user.getEmail().equals(name) && user.getPassword().equals(pass) && r.equalsIgnoreCase("admin")) {

			out.print("Welcome "+name/*+"<br/>Languages selected"*/);
			 /*for(String st:lan) {
				out.print("<br/>"+st);
			}*/
			RequestDispatcher rr=request.getRequestDispatcher("menuadmin.html");
			rr.include(request, response);
			HttpSession session=request.getSession();
			session.setAttribute("sname", name);
			session.setAttribute("role", r);
			
		}else if (user.getEmail().equals(name) && user.getPassword().equals(pass) && r.equalsIgnoreCase("customer")) {
			
			out.print("Welcome:" + " " + name + "<br/>");
			RequestDispatcher rd = request.getRequestDispatcher("menucustomer.html");
			rd.include(request, response);
			/*
			 * out.println("Language selected<br/>"); for(String st:lans) { out.print(st); }
			 */
			HttpSession session = request.getSession();
			session.setAttribute("sname", name);
			session.setAttribute("role", r);

		}		
		}catch(Exception e) {
			out.print("invalid credentials or not logged in");
			//response.sendRedirect("http://www.google.com");
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
