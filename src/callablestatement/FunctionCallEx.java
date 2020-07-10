package callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;

public class FunctionCallEx {
	public static void main(String[] args) {
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
		CallableStatement stmt=conn.prepareCall("{?=call Addition(?,?)}"); 
		stmt.setInt(2, 20);
		stmt.setInt(3, 30);
		stmt.registerOutParameter(1, Types.INTEGER);
		stmt.execute();
		System.out.println(stmt.getInt(1));
		conn.close();
	}
	catch(Exception e) {
		System.out.println(e);
	}
	}
	
}
