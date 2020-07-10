package blob;

import java.io.FileOutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class FetchImage {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
		PreparedStatement ps=conn.prepareStatement("select * from student");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			Blob b=rs.getBlob(3);
			byte arr[]=b.getBytes(1, (int)b.length());
			FileOutputStream fos=new FileOutputStream("D:\\java.jpg");
			fos.write(arr);
			fos.close();
			System.out.println("record fetched");
		}

		conn.close();
		
	}

}
