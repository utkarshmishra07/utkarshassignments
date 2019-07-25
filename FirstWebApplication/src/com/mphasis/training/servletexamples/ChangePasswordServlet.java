package com.mphasis.training.servletexamples;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mphasis.cart.bo.CartAUserBo;
import com.mphasis.cart.bo.CartAUserBoImpl;
import com.mphasis.cart.exceptions.BussinessException;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/ChangePassword")
public class ChangePasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CartAUserBo cartAUserBo;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePasswordServlet() {
		cartAUserBo = new CartAUserBoImpl();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String oldpass = request.getParameter("opass");
		String newpass = request.getParameter("npass");
		

		try {
			int i = cartAUserBo.changePassword(email, oldpass, newpass);
			System.out.println("i" + i);

			if (i > 0) {
				out.println("Password updated");
				RequestDispatcher rd = request.getRequestDispatcher("Login.html");
				rd.include(request, response);
			} else {
				out.println(" passwords should match");
				System.out.print("in exception");
				request.getRequestDispatcher("ChangePassword.html").forward(request, response);
			}
		} catch (BussinessException | SQLException e) {
			// TODO Auto-generated catch block
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
