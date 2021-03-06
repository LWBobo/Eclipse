package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.Score;
import entity.Student;
import entity.Teacher;
import util.JDBCutil;

public class DbRead {
	static ArrayList<Student> stuarr = new ArrayList<Student>();
	static ArrayList<Teacher> teaarr = new ArrayList<Teacher>();
	
	public static ArrayList<Student> readstuinfo() {
		Connection conn = JDBCutil.getMysqlConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			String sql = "select * from stu_info where 1=1";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				Score score = new Score(rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
				Student stu = new Student(rs.getString(2), rs.getInt(4), rs.getString(3), rs.getString(1), score, rs.getString(10),rs.getString(11));
				stuarr.add(stu);
			}
			return stuarr;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			JDBCutil.close(rs, conn);
			JDBCutil.close(pst);
		}
	}
	public static ArrayList<Teacher> readteacherinfo(){
		Connection conn = JDBCutil.getMysqlConn();
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			String sql = "select * from teacher_info where 1=1";
			pst = conn.prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()) {
				Teacher tea = new Teacher(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(1), rs.getString(5));
				teaarr.add(tea);
			}
			return teaarr;		
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			JDBCutil.close(rs, conn);
			JDBCutil.close(pst);
		}
	}	
}
