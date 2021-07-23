package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.Basedao;
import com.entity.Student;

public class StudentDao {
	public static int insert(Student u) {
		String sql = "insert into Student values(?, ?, ?, ?, ?)";
		Object[] params = {
				u.getSname(),
				u.getSno(),
				u.getScno(),
				u.getSaddr(),
				u.getSphone()};
		return Basedao.executeIUD(sql, params);
	}
	
	public static int update(Student u) {
		String sql = "update Student set Sno=?,Scno=?,Saddr=?,Sphone=? where Sname=?";
		Object[] params = {
				u.getSno(),
				u.getScno(),
				u.getSaddr(),
				u.getSphone(),
				u.getSname()};
		return Basedao.executeIUD(sql, params);
	}
	
	public static int delete(String username) {
		String sql = "delete from Student where Sname=?";
		Object[] params = {username};
		return Basedao.executeIUD(sql, params);
	}
	
	public static Student selectByName(String username) {
		int count = 0;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Student u = new Student("",0,0,"","");
		
		try {
			String sql = "select * from Student where Sname=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
		    rs = ps.executeQuery();
		    
		    while(rs.next())
			{
				u.setSname(rs.getString(1)) ;
				u.setSno(rs.getInt(2));
				u.setScno(rs.getInt(3));
				u.setSaddr(rs.getString(4));
				u.setSphone(rs.getString(5)); 
			}
			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		
		return u;
	}
	
	public static String selectphoneByName(String username, int sno) {
		int count = 0;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String u = "";
		
		try {
			String sql = "select Sphone from Student where Sname=? and Sno=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setInt(2, sno);
		    rs = ps.executeQuery();
		    
		    while(rs.next())
			{
				u = rs.getString(1); 
			}
			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		
		return u;
	}
	
	public static int selectCountByCity(String addr) {
		int count = 0;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		int u = 0;
		
		try {
			String sql = "select count(*) from Student where Saddr=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, addr);
		    rs = ps.executeQuery();
		    
		    while(rs.next())
			{
				u = rs.getInt(1); 
			}
			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		
		return u;
	}
	
	public static Student[] selectByCity(String addr) {
		int count = 0, i = 0;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Student[] u = new Student[1100000];
		
		try {
			String sql = "select * from Student where Saddr=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, addr);
		    rs = ps.executeQuery();
		    
		    while(rs.next())
			{
		    	u[i] = new Student("",0,0,"","");
		    	u[i].setSname(rs.getString(1));
				u[i].setSno(rs.getInt(2));
				u[i].setScno(rs.getInt(3));
				u[i].setSaddr(rs.getString(4));
				u[i].setSphone(rs.getString(5)); 
				i++;
			}
			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		
		return u;
	}
	
	public static Student[] selectByCno(int cno) {
		int count = 0, i = 0;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Student[] u = new Student[100];
		
		try {
			String sql = "select * from Student where Scno=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cno);
		    rs = ps.executeQuery();
		    
		    while(rs.next())
			{
		    	u[i] = new Student("",0,0,"","");
		    	u[i].setSname(rs.getString(1));
				u[i].setSno(rs.getInt(2));
				u[i].setScno(rs.getInt(3));
				u[i].setSaddr(rs.getString(4));
				u[i].setSphone(rs.getString(5)); 
				i++;
			}
			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		
		return u;
	}
	
}

























