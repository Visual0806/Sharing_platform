package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.dao.Basedao;
import com.entity.Document;
import com.entity.Student;
import com.entity.User;

public class DocumentDao {
	public static int insert(Document u) {
		String sql = "insert into User values(?, ?, ?, ?, ?, ?, ?)";
		Object[] params = {
				u.getDocID(),
				u.getUserID(),
				u.getTitle(),
				u.getContent(),
				u.getTag(),
				u.getPublishTime(),
				u.getAuditResult()};
		return Basedao.executeIUD(sql, params);
	}
	
	public static int delete(String docID) {
		String sql = "delete from Document where docID=?";
		Object[] params = {docID};
		return Basedao.executeIUD(sql, params);
	}
	
	public static Document[] selectByAudit(int auditResult) {
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Document[] u = new Document[100];
		int i = 0;
		
		try {
			String sql = "select * from Document where auditResult=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1,auditResult);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				u[i].setDocID(rs.getString(1)) ;
				u[i].setUserID(rs.getString(2));
				u[i].setTitle(rs.getString(3));
				u[i].setContent(rs.getString(4)); 
				u[i].setTag(rs.getString(5));
				u[i].setPublishTime(rs.getDate(6)); 
				u[i].setAuditResult(rs.getInt(7));
				i++;
			}
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			Basedao.closeall(rs, ps, conn);
		}
		return u;
	}
	
	public static Document selectByUser(String userID) {
		Connection conn = Basedao.getconn();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Document u = null;
		
		try {
			String sql = "select * from Document where userID=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,userID);
			rs = ps.executeQuery();
			
			while(rs.next())
			{
				u.setDocID(rs.getString(1)) ;
				u.setUserID(rs.getString(2));
				u.setTitle(rs.getString(3));
				u.setContent(rs.getString(4)); 
				u.setTag(rs.getString(5));
				u.setPublishTime(rs.getDate(6)); 
				u.setAuditResult(rs.getInt(7));
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
