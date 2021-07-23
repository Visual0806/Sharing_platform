package com.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.NUAA_USER;
import com.entity.User;
import com.service.NUAA_USERDao;
import com.service.UserDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String username = request.getParameter("userName");
		String pwd = request.getParameter("passWord");
		
		User u = UserDao.selectByID(username,pwd);
		
		if(u.getUserID() != "0") {
			Cookie cookie = new Cookie("username",username);
			response.addCookie(cookie);
			if(u.isUserType() == true)
				response.sendRedirect("admin.jsp");
			else
				response.sendRedirect("index.jsp");
		}
		else {
			PrintWriter out = response.getWriter();
            out.flush();
            out.println("<script>");
            out.println("alert('登录失败！');");
            out.println("history.back();");
            out.println("</script>");
		}
	}

}
