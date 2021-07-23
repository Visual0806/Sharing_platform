package com.servlet.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.Document;
import com.entity.Student;
import com.service.DocumentDao;
import com.service.StudentDao;

@WebServlet("/admin_documents")
public class Audit_Document extends HttpServlet {
		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		Document[] u = DocumentDao.selectByAudit(0);
	
    	request.setAttribute("document", u);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin_documents.jsp");
        dispatcher.forward(request, response);
	
	}

}

