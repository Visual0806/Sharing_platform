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

import com.entity.Class;
import com.entity.NUAA_USER;
import com.entity.Student;
import com.service.ClassDao;
import com.service.NUAA_USERDao;
import com.service.StudentDao;

/**
 * Servlet implementation class Register
 */
@WebServlet("/searchClass")
public class SearchClass extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null)
			for(Cookie c : cookies){
				String name = c.getName();//获取Cookie名称
				if(name.equals("username")){
					String username = c.getValue();
                    Class u = ClassDao.selectByName(username);
                    Student[] s = StudentDao.selectByCno(u.getCno());
                    if(u.getCno() == 0) {
                        PrintWriter out = response.getWriter();
                        out.flush();
                        out.println("<script>");
                        out.println("alert('班级不存在！');");
                        out.println("history.back();");
                        out.println("</script>");
                    }
                    else {
                    	request.setAttribute("class", u);
                    	request.setAttribute("student", s);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/classInfo.jsp");
                        dispatcher.forward(request, response);
                    }
                    
                }
				
			}
		
		
	}

}