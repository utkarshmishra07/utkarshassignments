/**
 * 
 */
package newjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author utkarsh.mishra1
 *
 */
public class classjdbc {

	/**
	 * @param args
	 */
	public static void main(String[] args)throws ClassNotFoundException {
		Class.forName("oracle.jdbc.OracleDriver");
		try {
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","nano","nano");
		System.out.println("Db connected");
		Statement st=con.createStatement();
		
		String sql = "INSERT INTO employee " +
                "VALUES (15, 'NAME6', '20-AUG-2018', 36000, 690, 1001, 10001, 10)";
        st.executeUpdate(sql);
       	ResultSet rs=st.executeQuery("select * from employee");
        while(rs.next()) {
       	System.out.println(rs.getString(2)+" "+rs.getDouble("salary"));
        }
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
