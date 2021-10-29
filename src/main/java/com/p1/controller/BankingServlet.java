package com.p1.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.p1.banking.AddAccount;
import com.p1.customer.DisplayCustById;
import com.p1.pojo.Banking;
import com.p1.pojo.Customer;

/**
 * Servlet implementation class BankingServlet
 */
@WebServlet("/BankingServlet")
public class BankingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public BankingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cid,ctg_id;
		double accbal;
		HttpSession session= request.getSession();
		cid = (Integer)session.getAttribute("cid");
		
		ctg_id=Integer.parseInt(request.getParameter("ctg_id"));
		accbal=Double.parseDouble(request.getParameter("accbal"));
		
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);  
		Date dateofinit = date; 
		Banking b=new Banking();
		AddAccount aa=new AddAccount();
		Banking bnk1=aa.addacc(cid,ctg_id,dateofinit,accbal);	
		session.setAttribute("account_no", bnk1.getAccount_no());
		System.out.println(bnk1.toString());
		if(bnk1.getAccount_no()==0)
		{
			request.setAttribute("val", "invalid account , try again!");
			RequestDispatcher view = 
			         request.getRequestDispatcher("result_noacc.jsp"); // to jsp
			    view.forward(request, response); 
		}
		else
		{
			request.setAttribute("bsobj", bnk1);
			RequestDispatcher view = 
			         request.getRequestDispatcher("result_Accounts.jsp"); // to jsp
			    view.forward(request, response); 
		}
	}
	}
