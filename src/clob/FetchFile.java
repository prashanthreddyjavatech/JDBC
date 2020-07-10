package clob;

import java.io.FileWriter;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import oracle.sql.CLOB;

public class FetchFile {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "admin");
		PreparedStatement ps = conn.prepareStatement("select * from EMPDATA");
		ResultSet rs = ps.executeQuery();
		FileWriter fw = new FileWriter("C:\\Users\\Admin\\eclipse-workspace\\Jdbc\\src\\clob\\retrivedstfile.txt");
		rs.next();
		CLOB c = (CLOB) rs.getClob(2);
		Reader r = c.getCharacterStream();
		int i;
		while ((i = r.read()) != -1)
			fw.write((char) i);
		System.out.println("records fetching done");
	}

}
