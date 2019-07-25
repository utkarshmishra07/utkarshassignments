package com.mphasis.training.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mphasis.cart.beans.CartA;
import com.mphasis.cart.bo.CartAUserBo;
import com.mphasis.cart.bo.CartAUserBoImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login" )
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
		// TODO Auto-generated method stub
		response.setHeader("cache-control", "no-cache,no-store,must-validate");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Expires", "0");
		PrintWriter out=response.getWriter();
		String name=request.getParameter("uname");
		String pass =request.getParameter("pwd");
		CartA user1=cartAUserBo.login(name, pass);
		System.out.println("text servlet"+user1.getEmailid());
		try{
			if(user1.getEmailid().equals(name)&&user1.getPassword().equals(pass))
			{
				if(user1.getRole().equals("Admin")) {
				HttpSession session=request.getSession();
				session.setAttribute("uname", name);
			System.out.println("welcoem");	
			out.print("Welcome"+name);
			RequestDispatcher rd1= request.getRequestDispatcher("MenuBro.html");
			rd1.include(request,response);	
			
			}else
			{HttpSession session=request.getSession();
			session.setAttribute("uname", name);
		System.out.println("welcoem");	
		out.print("Welcome"+name);
		RequestDispatcher rd1= request.getRequestDispatcher("Menu.html");
		rd1.include(request,response);}
			}
			}catch(Exception e) {
				out.println("invalid ");
				RequestDispatcher rd= request.getRequestDispatcher("Login.html");
				rd.include(request,response);
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
