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

import com.p1.pojo.Transactions;
import com.p1.transactions.*;

/**
 * Servlet implementation class TransactionByIdServlet
 */
@WebServlet("/TransactionByIdServlet")
public class TransactionByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionByIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cid;
		HttpSession session= request.getSession();
		cid = (Integer)session.getAttribute("cid");
		Transactions t=new Transactions();
		DisplayTransById dt=new DisplayTransById();
		LinkedList<Transactions> t1=new LinkedList<Transactions>();
		t1=dt.displaytranbyid(cid);
		if(t1.size()==0)
		{
			request.setAttribute("val", "no transactions yet!");
			RequestDispatcher view = 
			         request.getRequestDispatcher("result_notrans.jsp"); // to jsp
			    view.forward(request, response); 
			
		}
		else
		{
			request.setAttribute("tobj", t1);
			RequestDispatcher view = 
			         request.getRequestDispatcher("result_transactions.jsp"); // to jsp
			    view.forward(request, response); 
		}
	}
	}


