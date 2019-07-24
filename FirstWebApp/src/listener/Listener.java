package listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class Listener
 *
 */
@WebListener
public class Listener implements HttpSessionListener {
	
	private int sessionCount=0;
	
    

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent se)  { 
    	synchronized (this) {
			sessionCount++;
		}
    	System.out.println("ID of session"+se.getSession());
    	System.out.println("Count of logged"+sessionCount);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	synchronized (this) {
			sessionCount--;
			System.out.println("Logged Out\n Count of logged:"+sessionCount);
		}
    }
	
}
