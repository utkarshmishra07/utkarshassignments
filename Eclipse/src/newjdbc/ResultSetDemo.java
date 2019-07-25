package newjdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class ResultSetDemo {

	public static void main(String[] args) {
		Connection con = null;
		try {
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","nano","nano");
			con.setAutoCommit(false);
			
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select pid,pname,quantity,cost from product");
			rs.moveToInsertRow();
			rs.updateInt(1, 975);
			rs.updateString(2, "keyboard");
			rs.updateInt(3, 12);
			rs.updateInt(4, 213);
			rs.insertRow();
			rs.afterLast();
			while(rs.previous()) {
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3)+" "+rs.getInt(4));
				
			}
			con.commit();
			System.out.println("done");
			
			ResultSetMetaData rsm=rs.getMetaData();
			System.out.println(rsm.getColumnCount());
			
			DatabaseMetaData db=con.getMetaData();
			System.out.println(db.getDatabaseProductName());
			System.out.println(db.getDatabaseProductVersion());
			System.out.println(db.getDriverName());
			System.out.println(db.getURL());
			System.out.println(db.getDatabaseMajorVersion());
			
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
