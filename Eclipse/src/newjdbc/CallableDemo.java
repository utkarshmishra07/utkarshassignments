package newjdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class CallableDemo {

	public static void main(String[] args) {
		try {
			Connection con;
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","nano","nano");
			CallableStatement cst=con.prepareCall("{call emp_sal_increase (?,?)}");
			cst.setInt(1, 11);
			cst.registerOutParameter(2, java.sql.Types.DECIMAL);
			cst.executeUpdate();
			double sal=cst.getDouble(2);
			System.out.println("sal="+sal);
		}catch(Exception e) {
			e.printStackTrace();
		}

	}

}
