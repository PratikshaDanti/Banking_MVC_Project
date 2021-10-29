package com.p1.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.p1.pojo.*;

public class AddUser {

	public AddUser() {}
	public int insert(UserLogin u) throws ClassNotFoundException {
		Connection con=null;
		int userid=0;
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
		
		String ins="INSERT INTO userlogin (username,userpwd) VALUES(?,?)";
		
		PreparedStatement pstmt=null;
		try{
			pstmt=con.prepareStatement(ins);
			pstmt.setString(1,u.getUsername());
			pstmt.setString(2,u.getUserpwd());
			pstmt.execute();
			
		}catch(SQLException ob3)
		{
			System.err.println("got an exception");
			System.err.println(ob3.getMessage());
		}
		
		
		String query="SELECT * FROM userlogin WHERE username=? and userpwd=?";
		try{
			PreparedStatement pstmt1=con.prepareStatement(query);
			pstmt1.setString(1, u.getUsername());
			pstmt1.setString(2, u.getUserpwd());
			ResultSet rs=pstmt1.executeQuery();
			
			while(rs.next())
			{
				if((u.getUsername().equals(rs.getString("username"))) && (u.getUserpwd().equals(rs.getString("userpwd"))))
				{
					u.setUserid(rs.getInt("userid"));
					u.setUsername(rs.getString("username"));
					u.setUserpwd(rs.getString("userpwd"));
					break;
				}
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return u.getUserid();
	}

}
