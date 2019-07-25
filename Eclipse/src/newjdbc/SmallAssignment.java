package newjdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SmallAssignment {

	public static void main(String[] args) {
		Connection con;
		try {
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","nano","nano");
			/*String sql="CREATE OR REPLACE PROCEDURE insertProduct(" + 
					"	   p_userid IN product.pid%TYPE," + 
					"	   p_username IN product.pname%TYPE," + 
					"	   p_createdby IN product.quantity%TYPE," + 
					"	   p_date IN product.cost%TYPE)" + 
					"AS" + 
					"BEGIN" + 
					"  INSERT INTO product (pid, pname, quantity, cost)" + 
					"  VALUES (p_userid, p_username,p_createdby, p_date);" + 
					"  COMMIT;" + 
					"END;" + 
					"/";
			Statement st=con.createStatement();
			st.executeUpdate(sql);*/
			
			CallableStatement cst=con.prepareCall("{call insertProduct(?,?,?,?)}");
			cst.setInt(1, 11);
			cst.setString(2, "monitor");
			cst.setInt(3, 13);
			cst.setInt(4, 150);
			cst.executeUpdate();
						
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
