package com.p1.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.p1.login.InsertSession;
import com.p1.login.UpdateSession;
import com.p1.pojo.UserSession;

@WebServlet("/UserSessionServlet")
public class UserSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public UserSessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
        HttpSession session=request.getSession();  
        Timestamp lastAccessTime = new Timestamp(session.getLastAccessedTime());
        request.setAttribute("val", "You are successfully logged out!");

        UpdateSession usess=new UpdateSession();
		usess.updatesession(lastAccessTime,session.getId());
		session.invalidate(); 
		RequestDispatcher view = 
		         request.getRequestDispatcher("result_login1.jsp"); // to jsp
		    view.forward(request, response); 
		
	}

}
