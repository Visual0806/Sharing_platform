package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.dao.Basedao;
import com.entity.NUAA_USER;

public class NUAA_USERDao {
	public static int insert(NUAA_USER u) {
		String sql = "insert into NUAA_USER values(?, ?)";
		Object[] params = {
				u.getUSER_ID(),
				u.getUSER_PASSWORD()};
		return Basedao.executeIUD(sql, params);
	}
	
	public static int delete(String username) {
		String sql = "delete from NUAA_USER where USER_ID=?";
		Object[] params = {username};
		return Basedao.executeIUD(sql, params);
	}
	
	public static int selectByNM(String username,String pwd) {
		int count = 0;
		
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try {
			String sql = "select count(*) from NUAA_USER where USER_ID=? and USER_PASSWORD=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,username);
			ps.setString(2,pwd);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				count = rs.getInt(1);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		
		return count;
	}
	
}

























