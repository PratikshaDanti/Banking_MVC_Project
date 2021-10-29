package com.p1.controller;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.p1.login.DisplaySessionById;
import com.p1.pojo.Transactions;
import com.p1.pojo.UserSession;
import com.p1.transactions.DisplayTransById;

/**
 * Servlet implementation class SessionById
 */
@WebServlet("/SessionById")
public class SessionById extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionById() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int userid;
		HttpSession session= request.getSession();
		userid = (Integer)session.getAttribute("uid");
		System.out.println("in sess "+userid);
		UserSession t=new UserSession();
		DisplaySessionById dt=new DisplaySessionById();
		LinkedList<UserSession> t1=new LinkedList<UserSession>();
		t1=dt.displaysessbyid(userid);
		if(t1.size()==0)
		{
			request.setAttribute("val", "no activity yet!");
			RequestDispatcher view = 
			         request.getRequestDispatcher("result_nosess.jsp"); // to jsp
			    view.forward(request, response); 
			
		}
		else
		{
			request.setAttribute("tobj", t1);
			RequestDispatcher view = 
			         request.getRequestDispatcher("result_session.jsp"); // to jsp
			    view.forward(request, response); 
		}
	}

}
