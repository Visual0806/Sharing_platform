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
@WebServlet("/searchCity")
public class SearchCity extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String addr = request.getParameter("addr");
		int Num = StudentDao.selectCountByCity(addr);
		Student[] u = StudentDao.selectByCity(addr);
	
    	request.setAttribute("num", Num);
    	request.setAttribute("student", u);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cityInfo.jsp");
        dispatcher.forward(request, response);
	
	}

}