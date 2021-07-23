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
@WebServlet("/searchPhone")
public class SearchPhone extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String sname = request.getParameter("sname");
		int sno = Integer.parseInt(request.getParameter("sno"));
	
		String phone = StudentDao.selectphoneByName(sname,sno);
		Student u = new Student(sname,sno,0," ",phone);
		
        if(u.getSno() == 0) {
            PrintWriter out = response.getWriter();
            out.flush();
            out.println("<script>");
            out.println("alert('未查到此同学！');");
            out.println("history.back();");
            out.println("</script>");
        }
        else {
        	request.setAttribute("student", u);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/phoneInfo.jsp");
            dispatcher.forward(request, response);
        }
                    
				
	}

}