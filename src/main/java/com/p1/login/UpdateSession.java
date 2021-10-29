package com.p1.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class UpdateSession {

	public UpdateSession() {
		// TODO Auto-generated constructor stub
	}
	public void updatesession(Timestamp t,String s1){

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
		String ins="UPDATE usersession SET lastaccesstime=? WHERE sid=?";
		PreparedStatement pstmt=null;
		try {
			pstmt=con.prepareStatement(ins);
			pstmt.setTimestamp(1, t);
			pstmt.setString(2, s1);
			pstmt.execute();
		}catch(SQLException ob3)
		{
			System.err.println("got an exception");
			System.err.println(ob3.getMessage());
		}
	}

}
