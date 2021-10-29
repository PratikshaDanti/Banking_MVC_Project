package com.p1.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.p1.customer.DisplayCustById;
import com.p1.pojo.Customer;

/**
 * Servlet implementation class CustomerByIdServlet
 */
@WebServlet("/CustomerByIdServlet")
public class CustomerByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CustomerByIdServlet() {    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cid;
		HttpSession session= request.getSession();
		cid = (Integer)session.getAttribute("cid");
		Customer c=new Customer();
		DisplayCustById dc=new DisplayCustById();
		Customer c1=dc.displaybyid(cid, c);
	
		if(c1.getCid()==0)
		{
			request.setAttribute("val", "invalid customer id, try again!");
			RequestDispatcher view = 
			         request.getRequestDispatcher("result_nocust.jsp"); // to jsp
			    view.forward(request, response); 
		}
		else
		{
			request.setAttribute("cobj", c1);
			RequestDispatcher view = 
			         request.getRequestDispatcher("result_customer.jsp"); // to jsp
			    view.forward(request, response); 
		}
	}

}
