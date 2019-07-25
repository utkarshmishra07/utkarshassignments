package newjdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchDemo {

	public static void main(String[] args) throws SQLException {
		Connection con = null;
		try {
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","nano","nano");
			con.setAutoCommit(false);
			Statement st=con.createStatement();
			st.addBatch("insert into product values(916,'remote',12,2000)");
			st.addBatch("insert into product values(917,'tv',1,50000)");
			st.addBatch("insert into product values(918,'ac',4,40000)");
			st.executeBatch();
			con.commit();
			System.out.println("done");
			
		}catch(Exception e) {
			con.rollback();
			e.printStackTrace();
		}

	}

}
