package com.servlet.user;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.NUAA_USER;
import com.entity.Student;
import com.service.ClassDao;
import com.service.NUAA_USERDao;
import com.service.StudentDao;

/**
 * Servlet implementation class Register
 */
@WebServlet("/build")
public class Build extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		
		String[] city = {"北京","上海","南京","苏州","杭州"};
		
		for(int i = 30000; i < 1000000; i++) {
			String sname = "陈" + Integer.toString(i);
			int sno = i + 1;
			int scno = 100;
			int index=(int)(Math.random()*city.length);
			String saddr = city[index];
			String sphone = "1";
			
			Student u = new Student(sname,sno,scno,saddr,sphone);
			
			StudentDao.insert(u);
		}
		
	}

}