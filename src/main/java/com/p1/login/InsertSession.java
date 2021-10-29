package com.p1.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.p1.pojo.Customer;
import com.p1.pojo.UserSession;

public class InsertSession {

	public InsertSession() {
		// TODO Auto-generated constructor stub
	}
	
	public void insert(UserSession u) throws ClassNotFoundException {
		
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
		
		String ins="INSERT INTO usersession VALUES(?,?,?,?)";
		
		PreparedStatement pstmt=null;
		try
		{
			pstmt=con.prepareStatement(ins);
			pstmt.setTimestamp(1, u.getCreatetime());
			pstmt.setTimestamp(2, u.getLastaccesstime());
			pstmt.setString(3, u.getSid());
			pstmt.setInt(4, u.getUserid());
			pstmt.execute();
			
		}catch(SQLException ob3)
		{
			System.err.println("got an exception");
			System.err.println(ob3.getMessage());
		}

	}

}
