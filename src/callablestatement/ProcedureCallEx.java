package callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

public class ProcedureCallEx {
	public static void main(String[] args) {
		try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
		CallableStatement stmt=conn.prepareCall("{call TestProcedure(?,?,?,?,?)}"); 
		stmt.setInt(1, 5);
		stmt.setString(2, "James");
		stmt.setInt(3, 60);
		stmt.setInt(4, 10000);
		stmt.setString(5, "Scientist");
		stmt.execute();
		System.out.println("Procedure executed successfully");
		conn.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
