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

import com.p1.banking.DisplayAccbyId;
import com.p1.customer.DisplayCustById;
import com.p1.pojo.Banking;
import com.p1.pojo.Customer;


@WebServlet("/DisplayBankingServlet")
public class DisplayBankingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public DisplayBankingServlet() {

    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cid;
		HttpSession session= request.getSession();
		cid = (Integer)session.getAttribute("cid");
		System.out.println(cid);
		DisplayAccbyId dc=new DisplayAccbyId();
		LinkedList<Banking> b1=new LinkedList<Banking>();
		b1=dc.displaybyid(cid);
		
		if(b1.size()==0)
		{
			request.setAttribute("val", "no accounts present!");
			RequestDispatcher view = 
			         request.getRequestDispatcher("result_noacc.jsp"); // to jsp
			    view.forward(request, response); 
		}
		else
		{
			request.setAttribute("blistobj", b1);
			RequestDispatcher view = 
			         request.getRequestDispatcher("result_Account.jsp"); // to jsp
			    view.forward(request, response); 
		}
	}
	}

