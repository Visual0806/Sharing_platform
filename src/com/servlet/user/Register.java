package com.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.entity.User;
import com.service.UserDao;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class Register extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String username = request.getParameter("userName");
		String pwd = request.getParameter("passWord");
		Date time = new Date();
		
		User u = new User(username,pwd,false,time);
		
		int count = UserDao.insert(u);
		
		if(count > 0) {
			response.sendRedirect("login.jsp");
		}
		else {
			PrintWriter out = response.getWriter();
            out.flush();
            out.println("<script>");
            out.println("alert('注册失败！');");
            out.println("history.back();");
            out.println("</script>");
		}
	}

}
