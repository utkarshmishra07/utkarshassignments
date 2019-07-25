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

import com.mphasis.cart.beans.CartAUser;
import com.mphasis.cart.bo.CartAUserBo;
import com.mphasis.cart.bo.CartAUserBoImpl;
import com.mphasis.cart.exceptions.BussinessException;

/**
 * Servlet implementation class SignUp1Servlet
 */
@WebServlet("/SignUp1")
public class SignUp1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CartAUserBo cartAUserBo;
	

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignUp1Servlet() {
		cartAUserBo = new CartAUserBoImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
			int id=Integer.parseInt(request.getParameter("uid"));
			String name=request.getParameter("uname");
			String email=request.getParameter("email");
			String pass=request.getParameter("pwd");
			int cardno=Integer.parseInt(request.getParameter("credit"));
			String gender=request.getParameter("gen");

			CartAUser user = new CartAUser();
			user.setUserid(id);
			user.setUsername(name);
			user.setEmail(email);
			user.setPassword(pass);
			user.setCredit(cardno);
			user.setGender(gender);
			
			try {
				cartAUserBo.register(user);
				out.print("User added!");
				RequestDispatcher rd=request.getRequestDispatcher("Menu.html");
				rd.include(request, response);
			} catch (BussinessException e) {
				// TODO Auto-generated catch block
				out.print("invalid credentials");
				RequestDispatcher rd=request.getRequestDispatcher("SignUp.html");
				rd.include(request, response);
			}
			
			
			/*if(value.length==1)
				out.print("name is "+st+" value is "+value[0]+"<br/>");
			else if(value.length>1) {
				out.print("<ol>");
				for(String st1:value) {
					out.print("<li>"+st1+"</li>");
			}
				out.print("</ol>");	
				
			}*/
//			else {
//				out.print("invalid");
//				RequestDispatcher rd=request.getRequestDispatcher("SignUp.html");
//				rd.include(request, response);
//			}
		

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
