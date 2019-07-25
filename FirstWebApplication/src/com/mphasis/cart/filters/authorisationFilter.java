package com.mphasis.cart.filters;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class authorisationFilter
 */
@WebFilter("/*")
public class authorisationFilter implements Filter {

    /**
     * Default constructor. 
     */
    public authorisationFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest srequest=(HttpServletRequest)request;
		HttpServletResponse sresponse=(HttpServletResponse)response;
			String url=srequest.getRequestURI();
			PrintWriter out=sresponse.getWriter();
			HttpSession session=srequest.getSession(false);
			if(session == null &&!(url.endsWith("Login.html") || url.endsWith("SignUp.html") || url.endsWith("Login") || url.endsWith("SignUp"))) {
				out.print("not authorised");
				srequest.getRequestDispatcher("Login.html").include(srequest, sresponse);
				//sresponse.sendRedirect("Login.html");
			}else {

		// pass the request along the filter chain
			
		chain.doFilter(request, response);
			}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
