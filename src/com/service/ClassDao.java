package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.Basedao;
import com.entity.Class;
import com.entity.Student;

public class ClassDao {
	public static int insert(Class u) {
		String sql = "insert into Class values(?, ?, ?, ?)";
		Object[] params = {
				u.getCno(),
				u.getCteacher(),
				u.getCdept(),
				u.getCnum()};
		return Basedao.executeIUD(sql, params);
	}
	
	public static int update(int cno) {	
		int num = selectByCno(cno);
		
		String sql = "update Class set Cnum=? where Cno=?";
		Object[] params = {
				num + 1,
				cno};
		return Basedao.executeIUD(sql, params);
	}
	
	public static int delete(int cno) {	
		int num = selectByCno(cno);
		
		String sql = "update Class set Cnum=? where Cno=?";
		Object[] params = {
				num - 1,
				cno};
		return Basedao.executeIUD(sql, params);
	}
	
	public static Class selectByName(String username) {
		int count = 0;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		Class u = new Class(0,"","",0);
		
		try {
			String sql = "select Cno,Cteacher,Cdept,Cnum from Student,Class where Student.Sname=? and Class.cno=Student.Scno";
			ps = conn.prepareStatement(sql);
			ps.setString(1, username);
		    rs = ps.executeQuery();
		    
		    while(rs.next())
			{
				u.setCno(rs.getInt(1)) ;
				u.setCteacher(rs.getString(2));
				u.setCdept(rs.getString(3));
				u.setCnum(rs.getInt(4)); 
			}
			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		
		return u;
	}
	
	public static int selectByCno(int cno) {
		int count = 0;
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			String sql = "select Cnum from Class where Cno=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, cno);
		    rs = ps.executeQuery();
		    
		    while(rs.next())
			{
				count = rs.getInt(1);
			}
			 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Basedao.closeall(rs, ps, conn);
		}
		
		return count;
	}
	
}

























