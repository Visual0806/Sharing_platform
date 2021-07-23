package com.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.NUAA_USER;
import com.entity.Student;
import com.service.ClassDao;
import com.service.NUAA_USERDao;
import com.service.StudentDao;

/**
 * Servlet implementation class Login
 */
@WebServlet("/logout")
public class Logout extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null)
			for(Cookie c : cookies){
				String name = c.getName();//获取Cookie名称
				if(name.equals("username")){
					String username = c.getValue();
					int count1 = NUAA_USERDao.delete(username);
                    int count2 = StudentDao.delete(username);
                    int count3 = ClassDao.delete(StudentDao.selectByName(username).getScno());
                    if(count1 == 0 || count2 == 0 || count3 == 0) {
                    	PrintWriter out = response.getWriter();
                        out.flush();
                        out.println("<script>");
                        out.println("alert('账号注销失败！');");
                        out.println("history.back();");
                        out.println("</script>");
                    }
                    else {
                    	response.sendRedirect("login.jsp");
                    }
                    
                }
				
			}
		
	}

}
