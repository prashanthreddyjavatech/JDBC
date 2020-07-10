package batches;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ExecuteBatchEx {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			Statement stmt=conn.createStatement();
			stmt.addBatch("insert into employee values(4,'James1',25,75000,'Admin')");
			stmt.addBatch("insert into employee values(6,'James2',35,17500,'Admin')");
			stmt.executeBatch();
			
		}catch(Exception e) {
			System.out.println(e);
		}
		
	}

}
