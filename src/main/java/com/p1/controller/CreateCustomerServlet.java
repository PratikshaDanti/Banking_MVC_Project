package com.p1.controller;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.p1.customer.InsertCust;
import com.p1.pojo.Customer;
import com.p1.pojo.UserLogin;
import com.p1.user.AddUser;
//https://www.javaguides.net/2020/01/jsp-servlet-mvc-example-with-database.html
/**
 * Servlet implementation class CreateCustomerServlet
 */
@WebServlet("/CreateCustomerServlet")
public class CreateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
    public CreateCustomerServlet() {
    	
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mail_id,mob,username,userpwd,cname;
		int userid=0;
		InsertCust ic = new InsertCust();
		AddUser au=new AddUser();
		username=request.getParameter("username");
		userpwd=request.getParameter("userpwd");

		cname=request.getParameter("cname");
		mob=request.getParameter("mob");
		mail_id=request.getParameter("mail_id");
		UserLogin ul=new UserLogin(username,userpwd);
		
		try {
			userid=au.insert(ul);     
			System.out.println(userid);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		try {
			Customer c=new Customer(cname,mob,mail_id,userid);
			 ic.insert(c);
		}catch (Exception e) {
            e.printStackTrace();
        }
		
		request.setAttribute("val", "Account Added Successfully!");
		RequestDispatcher view = request.getRequestDispatcher("newacc.jsp"); // to jsp
		view.forward(request, response);

	}

}
