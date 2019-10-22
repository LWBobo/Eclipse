package com.logintest.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.logintest.pojo.User;

public class LoginDaoImpl implements LoginDao{

	@Override
	public User checkLoginDao(String uname, String pwd) {
		
		Connection conn =null;
		conn = new JDBCutil().getMysqlConn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		User u = null;
		
		
		try {
	//		Class.forName("com.mysql.jdbc.Driver");
	//		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet_user","root","123456789");
			
			
			String sql = "select * from user where uname=? and pwd=?";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, uname);
			ps.setString(2, pwd);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				u = new User();
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setPwd(rs.getString("pwd"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			new JDBCutil().close(rs,conn);
		}
		

		
		
		return u;
	}

}
