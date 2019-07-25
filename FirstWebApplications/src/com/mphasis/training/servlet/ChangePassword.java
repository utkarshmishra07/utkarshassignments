package com.mphasis.training.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mphasis.cart.bo.CartAUserBo;
import com.mphasis.cart.bo.CartAUserBoImpl;
/**
* Servlet implementation class changepassword
*/
@WebServlet("/changepassword")
public class ChangePassword extends HttpServlet {
       private static final long serialVersionUID = 1L;
       CartAUserBo cartAUserBo;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePassword() {
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
              String npass=request.getParameter("npass");
              String email=request.getParameter("email");
              String opass=request.getParameter("opass");
              
              //String lan[]=request.getParameterValues("lan");
     
              try {
                     
                     int user =cartAUserBo.changePassword(email, npass);
              if (user>0) {
                     out.println("Password changed");
                     RequestDispatcher rr=request.getRequestDispatcher("menu.html");
                     rr.include(request, response);
              }
                     
                     //if(user1.getEmail().equals(email) && user1.getPassword().equals(opass)) {
//                         CartAUser user =cartAUserBo.login(name, pass);
                           //
                     //cartAUserBo.changePassword(opass,npass);
                     
                     
                     
              
              }catch(Exception e) {
                     out.print("invalid credentials");
                     RequestDispatcher rd=request.getRequestDispatcher("index.html");
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

