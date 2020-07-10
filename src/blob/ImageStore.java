package blob;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ImageStore {
	public static void main(String[] args) throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
		PreparedStatement ps=conn.prepareStatement("insert into student values(?,?,?)");
		ps.setInt(1, 1);
		ps.setString(2, "Java");
		FileInputStream fis=new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\Jdbc\\src\\blob\\Java.jpg");
		ps.setBinaryStream(3, fis);
		int result=ps.executeUpdate();
		fis.close();
		System.out.println("inserted records: "+result);
		conn.close();
		
	}

}
