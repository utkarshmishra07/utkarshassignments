package com.mphasis.training.assignment;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class HashMapDemo {
	 Map<String, String> map = new HashMap<String, String>();
	       
	       
	       
	       
	       public boolean validateEmail(String email) {
	    	   
	    	  String regex=("^([a-zA-Z0-9_\\-\\.]+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$") ;
	    	  Pattern pt = Pattern.compile(email); 
	          if (email == null) 
	              return false; 
	          return pt.matcher(email).matches(); 
	    	  
	       }
	       
	       public void addEmployee(String key,String value) {
	    	   if(validateEmail(value)) {
	    		   map.put(key, value);
	    	   }
	       }
	       
	      public void  getEmployee( String key) {
			map.put(key, email); 
	      }

}