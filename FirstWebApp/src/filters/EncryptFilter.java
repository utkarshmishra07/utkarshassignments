package filters;

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
@WebFilter("/encryptservlet")
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
		// TODO Auto-generated method stub
		// place your code here
		HttpServletRequest srequest=(HttpServletRequest)request;
		try {
			String pass=srequest.getParameter("pass");
			String name=srequest.getParameter("uname");
			if(pass!=null) {
				KeyGenerator keyGenerator=KeyGenerator.getInstance("DESede");
				SecretKey secretKey=keyGenerator.generateKey();
				Cipher cipher=Cipher.getInstance("DESede");
				cipher.init(Cipher.ENCRYPT_MODE, secretKey);
				byte[] encryptedpass =cipher.doFinal(pass.getBytes());
				cipher.init(Cipher.DECRYPT_MODE, secretKey);
				byte[] decryptedpass=cipher.doFinal(encryptedpass);
				cipher.init(Cipher.ENCRYPT_MODE, secretKey);
				byte[] encryptedname =cipher.doFinal(name.getBytes());
				cipher.init(Cipher.DECRYPT_MODE, secretKey);
				byte[] decryptedname=cipher.doFinal(encryptedname);
				
				srequest.setAttribute("encryptedpass", new String(encryptedpass));
				srequest.setAttribute("decryptedpass", new String(decryptedpass));
				srequest.setAttribute("encryptedname", new String(encryptedname));
				srequest.setAttribute("decryptedname", new String(decryptedname));
				request.getRequestDispatcher("encryptservlet").forward(srequest, response);
			}else {
				chain.doFilter(request, response);
			}
		}catch(Exception e) {
				e.printStackTrace();
			}
		
		// pass the request along the filter chain
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
