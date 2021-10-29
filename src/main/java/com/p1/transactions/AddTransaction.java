package com.p1.transactions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.LinkedList;

import com.p1.pojo.Transactions;
import com.p1.transactions.*;

public class AddTransaction {

	public AddTransaction() {
		// TODO Auto-generated constructor stub
	}
	
	public void insert(Transactions t) {
		Connection con=null;
		String myDriver="com.mysql.cj.jdbc.Driver";
		String myUrl="jdbc:mysql://localhost:3306/banking";
		try {
			Class.forName(myDriver);
		}catch(ClassNotFoundException ob1)
		{
			System.out.println("cannot load driver"+ob1);
		}
		try {
			con=DriverManager.getConnection(myUrl,"root","Caroot");
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		String ins="INSERT INTO transactions VALUES(?,?,?,?,?)";
		PreparedStatement pstmt=null;
		try {
			pstmt=con.prepareStatement(ins);
			pstmt.setInt(1, t.getTrn_id());
			pstmt.setInt(2, t.getAccount_no());
			pstmt.setDate(3, t.getTrn_date());
			pstmt.setDouble(4, t.getAmount());
			pstmt.setString(5, t.getComments());
			pstmt.execute();
			
		}catch(SQLException ob3)
		{
			System.err.println("got an exception");
			System.err.println(ob3.getMessage());
		}

	}

}
