package com.mphasis.training.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mphasis.cart.beans.CartA;
import com.mphasis.cart.bo.CartAUserBo;
import com.mphasis.cart.bo.CartAUserBoImpl;

/**
* Servlet implementation class SignupServlet
*/
@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
                private static final long serialVersionUID = 1L;
                CartAUserBo cartAUserBo;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUpServlet() {
                cartAUserBo=new CartAUserBoImpl();
        // TODO Auto-generated constructor stub
    }

                /**
                * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
                */
                protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                	response.setHeader("cache-control", "no-cache,no-store,must-validate");
            		response.setHeader("Pragma", "no-cache");
            		response.setHeader("Expires", "0");           
                	PrintWriter out=response.getWriter();
                                String name=request.getParameter("uname");
                                String email=request.getParameter("email");
                                String pass=request.getParameter("pwd");
                                String gender=request.getParameter("gender");
                                long credit=Long.parseLong(request.getParameter("credit"));
                                //String lan[]=request.getParameterValues("lan");
                                
                                
                                try {
                                                CartA user=new CartA();
                                                user.setUsername(name);
                                                user.setEmailid(email);
                                                user.setPassword(pass);
                                                user.setCrcardno(credit);
                                                user.setGender(gender);
                                                out.println("User Added");
                                                cartAUserBo.register(user);
                                                RequestDispatcher rr=request.getRequestDispatcher("menu.html");
                                                rr.include(request, response);
                                }catch(Exception e) {
                                                out.print("invalid credentials");
                                                RequestDispatcher rd=request.getRequestDispatcher("signup.html");
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




