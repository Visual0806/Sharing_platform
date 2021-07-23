package com.servlet.user;

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
@WebServlet("/alterInformation")
public class AlterInformation extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String sname = request.getParameter("sname");
		int sno = Integer.parseInt(request.getParameter("sno"));
		int scno = Integer.parseInt(request.getParameter("scno"));
		String saddr = request.getParameter("saddr");
		String sphone = request.getParameter("sphone");
		
		Student u = new Student(sname,sno,scno,saddr,sphone);
		
		int old_cno = StudentDao.selectByName(sname).getScno();
		
		int count1 = StudentDao.update(u);
		int count2 = 1;
		int count3 = 1;
		if(old_cno != scno) {
			count2 = ClassDao.delete(old_cno);
			count3 = ClassDao.update(scno);
		}
		if(count1 > 0 && count2 > 0 && count3 > 0) {
        	response.sendRedirect("catalog.jsp");
        }
		else {
			PrintWriter out = response.getWriter();
            out.flush();
            out.println("<script>");
            out.println("alert('修改失败！');");
            out.println("history.back();");
            out.println("</script>");
		}
			
	}

}