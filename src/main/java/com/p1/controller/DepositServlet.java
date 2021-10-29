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

import com.p1.pojo.Transactions;
import com.p1.transactions.AddTransaction;
import com.p1.transactions.Transact;

/**
 * Servlet implementation class DepositServlet
 */
@WebServlet("/DepositServlet")
public class DepositServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepositServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double amount;
		int account_no,cid;
		HttpSession session= request.getSession();
		cid = (Integer)session.getAttribute("cid");
		System.out.println("in deposit "+cid);
		
		account_no=Integer.parseInt(request.getParameter("account_no"));
		amount=Double.parseDouble(request.getParameter("amount"));
		long millis=System.currentTimeMillis();  
		java.sql.Date date=new java.sql.Date(millis);  
		Date trn_date = date; 
		String s1="deposit";
		
		Transact t=new Transact();
		t.deposit(account_no, amount,cid);
		Transactions trn1=new Transactions(account_no,trn_date,amount,s1);
		AddTransaction atrn=new AddTransaction();
		atrn.insert(trn1);
		    
		request.setAttribute("val", "deposit successful");
		RequestDispatcher view =request.getRequestDispatcher("result_notrans.jsp"); // to jsp
		view.forward(request, response); 
	}

}
