package newjdbc;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class JdbcConnection {

	public static void main(String[] args) throws SQLException {
		JdbcRowSet rowSet=RowSetProvider.newFactory().createJdbcRowSet();
		rowSet.setUrl("jdbc:oracle:thin:@localhost:1521:xe");
		rowSet.setUsername("nano");
		rowSet.setPassword("nano");
		System.out.println("Connected");
		rowSet.setCommand("select * from product");
		rowSet.execute();
		
		while(rowSet.next()) {
			System.out.println(rowSet.getInt(1)+" "+rowSet.getString(2)+" "+rowSet.getInt(3)+" "+rowSet.getInt(4));
			
		}
	}

}
