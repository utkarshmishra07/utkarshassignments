package com.mphasis.training.servletexamples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mphasis.cart.beans.CartAUser;
import com.mphasis.cart.bo.CartAUserBo;
import com.mphasis.cart.bo.CartAUserBoImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CartAUserBo cartAUserBo;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		cartAUserBo = new CartAUserBoImpl();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setHeader("Cache-Control", "no-cache,no-store,must-revalidate");// http 1.1
		response.setHeader("Pragma", "no-cache");// 1.0
		response.setHeader("Expires", "0");// proxies
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String name = request.getParameter("uname");
		String pass = request.getParameter("pwd");
		CartAUser user = cartAUserBo.login(name, pass);

		String r = user.getRole();
		try {
			// String lans[]=request.getParameterValues("lan");
			if (user.getEmail().equals(name) && user.getPassword().equals(pass) && r.equalsIgnoreCase("admin")) {
				
				out.print("Welcome:" + " " + name + "<br/>");
				RequestDispatcher rd = request.getRequestDispatcher("MenuAdmin.html");
				rd.include(request, response);
				/*
				 * out.println("Language selected<br/>"); for(String st:lans) { out.print(st); }
				 */
				HttpSession session = request.getSession();
				session.setAttribute("sname", name);
				session.setAttribute("role", r);

			}else if (user.getEmail().equals(name) && user.getPassword().equals(pass) && r.equalsIgnoreCase("customer")) {
				
				out.print("Welcome:" + " " + name + "<br/>");
				RequestDispatcher rd = request.getRequestDispatcher("MenuCustomer.html");
				rd.include(request, response);
				/*
				 * out.println("Language selected<br/>"); for(String st:lans) { out.print(st); }
				 */
				HttpSession session = request.getSession();
				session.setAttribute("sname", name);
				session.setAttribute("role", r);

			}

		} catch (Exception e) {
			out.print("invalid credentials");
			RequestDispatcher rd = request.getRequestDispatcher("Login.html");
			rd.include(request, response);
			e.printStackTrace();

		}
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
