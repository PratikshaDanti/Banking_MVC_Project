package com.p1.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ExistingUser {

	public ExistingUser() {
	}
		public int validateuser(String queryname,String querypwd){
		
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
			String query="SELECT * FROM userlogin WHERE username=? AND userpwd=?";
			try{
				PreparedStatement pstmt=con.prepareStatement(query);
				pstmt.setString(1, queryname);
				pstmt.setString(2, querypwd);
				ResultSet rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					if(queryname.equals(rs.getString("username")) && querypwd.equals(rs.getString("userpwd")))
					{
						
						return rs.getInt("userid");
					}
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return 0;
		}



}
