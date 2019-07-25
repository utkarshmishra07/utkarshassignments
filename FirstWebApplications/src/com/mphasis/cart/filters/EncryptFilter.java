package com.mphasis.cart.filters;

import java.io.IOException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class EncryptFilter
 */
@WebFilter("/EncryptServlet")
public class EncryptFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EncryptFilter() {
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
		try {
		
		String pass=srequest.getParameter("pass");
		if(pass!=null)
		{
			KeyGenerator keyGenerator=KeyGenerator.getInstance("DESede");
			SecretKey secretkey=keyGenerator.generateKey();
			Cipher cipher=Cipher.getInstance("DESede");
			cipher.init(Cipher.ENCRYPT_MODE, secretkey);
			byte[] encrypted=cipher.doFinal(pass.getBytes());
			cipher.init(Cipher.DECRYPT_MODE, secretkey);
			byte[] decrypted=cipher.doFinal(encrypted);
			srequest.setAttribute("encrypted", new String(encrypted));
			srequest.setAttribute("decrypted", new String(decrypted));
			request.getRequestDispatcher("EncryptServlet").forward(srequest, response);

		}else
		{
		chain.doFilter(srequest, response);
		}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
