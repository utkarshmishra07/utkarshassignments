package com.mphasis.training.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.apache.catalina.ant.SessionsTask;

import com.mphasis.cart.beans.Product;
import com.mphasis.cart.dao.ProductDao;
import com.mphasis.cart.dao.Productdaoimpl;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
                private static final long serialVersionUID = 1L;
                ProductDao dao = null;
                Product p = null;

                public EditServlet() {
                                dao = new Productdaoimpl();

                }

                protected void doGet(HttpServletRequest request, HttpServletResponse response)
                                                throws ServletException, IOException {

                                String pid = request.getParameter("pid");
                
                                Product p = dao.getById(Integer.parseInt(pid));
                                HttpSession session= request.getSession();
                                session.setAttribute("product", p);
///                          String pname = p.getPname();
//                            
//                            String pcost = Double.toString(p.getPcost());
//                            
//                            String pquantity = Integer.toString(p.getPquantity());
//                            
//                            request.setAttribute("pid", pid);
//                            request.setAttribute("pname", pname);
//                            request.setAttribute("pcost", pcost);
//                            request.setAttribute("pquantity", pquantity);
                                
                                request.getRequestDispatcher("addproduct.jsp").forward(request, response);

                }

                protected void doPost(HttpServletRequest request, HttpServletResponse response)
                                                throws ServletException, IOException {
                                // TODO Auto-generated method stub
                                doGet(request, response);
                }

}
