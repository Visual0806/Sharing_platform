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

import com.entity.NUAA_USER;
import com.entity.Student;
import com.service.NUAA_USERDao;
import com.service.StudentDao;

/**
 * Servlet implementation class Register
 */
@WebServlet("/printInformation")
public class PrintInformation extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		Cookie[] cookies = request.getCookies();
		if(cookies != null)
			for(Cookie c : cookies){
				String name = c.getName();//获取Cookie名称
				if(name.equals("username")){
					String username = c.getValue();
                    Student u = StudentDao.selectByName(username);
                    if(u.getSno() == 0) {
                    	response.sendRedirect("createInfo.jsp");
                    }
                    else {
                        request.setAttribute("student", u);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/printInfo.jsp");
                        dispatcher.forward(request, response);
                    }
                    
                }
				
			}
		
		
	}

}