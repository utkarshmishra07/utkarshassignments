package com.mphasis.cart.listeners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MyListener
 *
 */
@WebListener
public class MyListener implements HttpSessionListener {
	private int sessionCount=0;
    /**
     * Default constructor. 
     */
   
	
    public void sessionCreated(HttpSessionEvent se)  { 
        synchronized(this) {
        	sessionCount++;
        }
        System.out.println("id of session"+se.getSession().getId());
        System.out.println("count of logged"+sessionCount);
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	synchronized(this) {
        	sessionCount--;
        }
        System.out.println("id of session"+se.getSession().getId());
        System.out.println("count of logged"+sessionCount);
    }
	
}
