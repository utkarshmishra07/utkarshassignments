package com.mphasis.training.servletexamples;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mphasis.cart.beans.Product;
import com.mphasis.cart.bo.CartAUserBo;
import com.mphasis.cart.bo.CartAUserBoImpl;
import com.mphasis.cart.dao.ProductDao;
import com.mphasis.cart.dao.ProductdaoImpl;


/**
* Servlet implementation class EditServlet
*/
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
                private static final long serialVersionUID = 1L;
                ProductDao productDao;
                /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
       productDao=new ProductdaoImpl();
      // TODO Auto-generated constructor stub
    }

                /**
                * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
                */
                protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                                String pid1=request.getParameter("pid");
                                int pid=Integer.parseInt(pid1);
                                int j=productDao.deleteProduct(pid); 
                                List<Product> products=productDao.getAll();
        HttpSession session1=request.getSession();
        session1.setAttribute("Product",products);
                                                response.sendRedirect("Product.jsp");
                                
                                
                }

                /**
                * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
                */
                protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                                // TODO Auto-generated method stub
                                doGet(request, response);
                }

}
