package com.mphasis.training.servletexamples;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mphasis.cart.beans.CartAUser;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String name = request.getParameter("uname");
		HttpSession session=request.getSession();
		session.setAttribute("sname", name);
		
		out.print("Welcome:"+" "+name+"<br/>");
		RequestDispatcher rd=request.getRequestDispatcher("MenuCustomer.html");
		rd.include(request, response);
		/*out.println("Language selected<br/>");
		for(String st:lans) {
			out.print(st); 
		}*/
		
		/*Enumeration<String> en=request.getParameterNames();
		while(en.hasMoreElements()) {
			String st=en.nextElement();
			String[] value=request.getParameterValues(st);
			
			if(value.length==1)
				out.print("name is "+st+" value is "+value[0]+"<br/>");
			else if(value.length>1) {
				out.print("<ol>");
				for(String st1:value) {
					out.print("<li>"+st1+"</li>");
			}
				out.print("</ol>");	
				
			}
			else {
				out.print("invalid");
				RequestDispatcher rd=request.getRequestDispatcher("SignUp.html");
				rd.include(request, response);
			}
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
