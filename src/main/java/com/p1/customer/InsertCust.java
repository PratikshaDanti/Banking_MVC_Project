package com.p1.customer;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.p1.pojo.*;

public class InsertCust {

	public InsertCust() {}
	
	public void insert(Customer c) throws ClassNotFoundException {
		
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
		
		String ins="INSERT INTO customer VALUES(?,?,?,?,?)";
		
		PreparedStatement pstmt=null;
		try
		{
			pstmt=con.prepareStatement(ins);
			pstmt.setInt(1, c.getCid());
			pstmt.setString(2, c.getCname());
			pstmt.setString(3, c.getMob());
			pstmt.setString(4, c.getMail_id());
			pstmt.setInt(5, c.getUid());
			pstmt.execute();
			
		}catch(SQLException ob3)
		{
			System.err.println("got an exception");
			System.err.println(ob3.getMessage());
		}

	}

}
