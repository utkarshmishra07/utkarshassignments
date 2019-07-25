package com.mphasis.cart.listeners;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class DBCreation
 *
 */
@WebListener
public class DBCreation implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public DBCreation() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	/*try {
     	   Class.forName("oracle.jdbc.OracleDriver");
     	   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","n","notforsale");
     	   Statement st= con.createStatement();
     	   String sql="drop table prod1";
     	   st.execute(sql);
     	   
        }catch(Exception e)
        {
     	   e.printStackTrace();
        }*/
    	
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent sce)  { 
       try {
    	   Class.forName("oracle.jdbc.OracleDriver");
    	   Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","mohit","notforsale");
    	   Statement st= con.createStatement();
    	   String sql="create table prod1 (pid number primary key,pname varchar(20),cost number,qty number)";
    	   st.execute(sql);
    	   System.out.println("table created");
       }catch(Exception e)
       {
    	   e.printStackTrace();
       }
       
    
    }
	
}
