package com.p1.controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.p1.customer.ExistingUser;
import com.p1.customer.SearchCustomer;
import com.p1.pojo.AccountCtg;
import com.p1.pojo.UserLogin;
import com.p1.pojo.UserSession;
import com.p1.login.*;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username,userpwd,cname;
		int userId,cid;
		username=request.getParameter("username");
		userpwd=request.getParameter("userpwd");
		ExistingUser eu=new ExistingUser();
		userId=eu.validateuser(username, userpwd);
		System.out.println("before user login "+userId);
		if(userId!=0)
		{
			SearchCustomer s=new SearchCustomer();
			cid=s.searchCust(userId);
			cname=s.searchCustname(userId);
			
			HttpSession session= request.getSession();
			Timestamp createTime = new Timestamp(session.getCreationTime());
			Timestamp lastAccessTime = new Timestamp(session.getLastAccessedTime());
			Integer userid = new Integer(0);
			String userIDKey = new String("userid");
			String sid = new String("sid");
			//if (session.isNew() ){
			      session.setAttribute(userIDKey, userId);
			      session.setAttribute(sid, session.getId());
			//   } 
			userid = (Integer)session.getAttribute(userIDKey);
			session.setAttribute("cid", cid);
			session.setAttribute("uid", userId);
			session.setAttribute("cname", cname);
			
			System.out.println("user login "+userId);
			
			System.out.println("in user login "+session.getAttribute("cid"));
			sid=(String)session.getAttribute(sid);
			UserSession u=new UserSession(createTime,lastAccessTime,sid,userId);
			InsertSession isess=new InsertSession();
			try {
				isess.insert(u);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			RequestDispatcher view = request.getRequestDispatcher("result_login.jsp"); // to jsp
			view.forward(request, response); 
		}
		else
		{
			HttpSession session=request.getSession();  

			session.invalidate(); 

			request.setAttribute("val", "please check the credentials again!");
			RequestDispatcher view = request.getRequestDispatcher("result_login1.jsp"); // to jsp
			view.forward(request, response);
		}
	    
	}

}
