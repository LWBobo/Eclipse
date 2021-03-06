
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;


public class BlobTest {

	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		InputStream is = null;
		OutputStream os = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testjdbc","root","123456789");
			
			
			
//			String sql = "insert into t_user (username,img) values (?,?)";
//			pst = conn.prepareStatement(sql);
//			pst.setObject(1, "���Ĳ�");
//			pst.setBlob(2, new FileInputStream("C:/Users/Bo/Pictures/Camera Roll/����.jpg"));
			
			String sql = "select * from t_user where id=?";
			pst = conn.prepareStatement(sql);
			pst.setInt(1, 8);
			rs = pst.executeQuery();
			while(rs.next()) {
				Blob b = rs.getBlob("img");
				is = b.getBinaryStream();
				int temp = 0;
				os = new FileOutputStream("G:/JAVASpace/TestJDBC/img/����.jpg");
				while((temp = is.read())!= -1) {
					os.write(temp);
				}
				System.out.println("д��ɹ���");
			}
			
			
			
			
			pst.execute();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
//				rs.close();
				pst.close();
				conn.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
