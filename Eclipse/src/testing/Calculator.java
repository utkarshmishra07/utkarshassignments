package testing;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
	HashMap<String,String> newmap = new HashMap<String,String>();
	public int sub(int a, int b) {
		return a-b;
	}
	
	public int add(int a, int b) {
		return a+b;
	}
	
	public String first(String a) {
		for (int i=0; i<=1; i++) {
			if(a.charAt(i)=='A') {
				a= a.replaceFirst("A", "");
			i--;
				
			} 
				
			
		}
		
		return a;
	}
	
	public boolean second(String str) {
		if(str.length()<=1) 
			return false;
		if(str.length()==2) 
			return true;
		String first2char=str.substring(0, 2);
		String last2char=str.substring(str.length()-2);
		return first2char.equals(last2char);
		
	}
	
	public void addEmployee(String eid, String email){
		
		newmap.put(eid, email);

	}
	public String getEmployee(String eid){
		
		String s=newmap.get(eid);
		
		return s;
	}
	public boolean validateEmail(String email) {
		Pattern p = Pattern.compile("^([a-zA-Z0-9\\.\\#\\%]+)@([a-zA-Z]+).([a-z]{2,5})\\.\\([a-z]{2,5})$");
		Matcher m = p.matcher(email);
		
		return m.matches();
	}
	
}
