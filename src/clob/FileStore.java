package clob;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class FileStore {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
		PreparedStatement ps=conn.prepareStatement("insert into EMPDATA values(?,?)");
		ps.setInt(1, 1);
		FileReader fr=new FileReader(new File("C:\\Users\\Admin\\eclipse-workspace\\Jdbc\\src\\clob\\studentinfo.txt"));
		ps.setClob(2, fr);
		int result=ps.executeUpdate();
		System.out.println("updated records: "+result);
		fr.close();
		conn.close();
	}

}
