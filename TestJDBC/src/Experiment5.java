import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

import util.JDBCutil;


public class Experiment5 {
	private   Connection conn = null;
	public  PreparedStatement ps = null;
	

	public Experiment5(Connection con) {
		this.conn = con;
	}


	public void add(Student stu) {
		try {
			String sql = "insert into stu (id,name,age,sex,logintime) values (?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, stu.getID());
			ps.setString(2, stu.getName());
			ps.setInt(3, stu.getAge());
			ps.setObject(4, stu.getSex()+"");
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			ps.setTimestamp(5,timestamp);
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCutil.close(ps);
		}
	}
	public void dispAll() {
		ResultSet rs = null;
		String sql = "select * from  stu where 1=1";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("id:"+rs.getString(1) + " " +"name:"+ rs.getString(2) + " " +"age:"+ rs.getInt(3) + " " + 
						"sex:" + rs.getString(4) + " " +"logintime:"+ rs.getTimestamp(5));
			}
			ps.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCutil.close(ps);
			JDBCutil.close(rs);
		}
	}
	public boolean findById(String id) {
		ResultSet rs = null;
		String sql = "select * from  stu where id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("id查询结果：");
				System.out.println("id:"+rs.getString(1) + " " +"name:"+ rs.getString(2) + " " +"age:"+ rs.getInt(3) + " " + 
						"sex:" + rs.getString(4) + " " +"logintime:"+ rs.getTimestamp(5));
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCutil.close(ps);
			JDBCutil.close(rs);
		}
		
		return false;
	}
	public boolean findByName(String name) {
		ResultSet rs = null;
		String sql = "select * from  stu where name=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println("name查询结果：");
				System.out.println("id:"+rs.getString(1) + " " +"name:"+ rs.getString(2) + " " +"age:"+ rs.getInt(3) + " " + 
						"sex:" + rs.getString(4) + " " +"logintime:"+ rs.getTimestamp(5));
				return true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCutil.close(ps);
			JDBCutil.close(rs);
		}
		
		return false;
	}
	public int delById(String id) {
		
		Statement st = null;
		String sql = "delete  from  stu where id=" + id;
		try {
			st = conn.prepareStatement(sql);
			
			return st.executeUpdate(sql);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
}
