package com.p1.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.p1.pojo.AccountCtg;
import com.p1.pojo.Customer;

/**
 * Servlet implementation class AccountCtgServlet
 */
@WebServlet("/AccountCtgServlet")
public class AccountCtgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountCtgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category;
		int ctg_id;
		ctg_id=Integer.parseInt(request.getParameter("ctg_id"));
		category=request.getParameter("category");
		
		AccountCtg ac=new AccountCtg(ctg_id,category);
		request.setAttribute("acobj", ac); 
	    RequestDispatcher view = 
	         request.getRequestDispatcher("result_accountctg.jsp"); // to jsp
	    view.forward(request, response); 
	}

}
