package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.dao.Basedao;
import com.entity.Student;
import com.entity.User;

public class UserDao {
	public static int insert(User u) {
		String sql = "insert into User values(?, ?, ?, ?)";
		Object[] params = {
				u.getUserID(),
				u.getUserPassword(),
				u.isUserType(),
				u.getRegisterTime()};
		return Basedao.executeIUD(sql, params);
	}
	
	public static int delete(String username) {
		String sql = "delete from User where USER_ID=?";
		Object[] params = {username};
		return Basedao.executeIUD(sql, params);
	}
	
	public static User selectByID(String username,String pwd) {
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		User u = null;
		
		try {
			String sql = "select * from User where userID=? and userPassword=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,username);
			ps.setString(2,pwd);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				u.setUserID(rs.getString(1)) ;
				u.setUserPassword(rs.getString(2));
				u.setUserType(rs.getBoolean(3)); 
				u.setRegisterTime(rs.getDate(4)); 
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		return u;
	}
	
}

























