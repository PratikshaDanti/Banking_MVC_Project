package com.p1.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SearchCustomer {

	public SearchCustomer() {
		// TODO Auto-generated constructor stub
	}
	
	public int searchCust(int queryid){
		int cid = 0,userid;
		String cname,mob,mail_id;
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
		String query="SELECT * FROM customer WHERE userid=?";
		try{
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setInt(1, queryid);
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				if(queryid==rs.getInt("cid"))
				{
					cid=rs.getInt("cid");
					cname=rs.getString("cname");
					mob=rs.getString("mob");
					mail_id=rs.getString("mail_id");
					userid=rs.getInt("userid");
					return rs.getInt("cid");
				}
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return cid;
	}
	
	public String searchCustname(int queryid){
		int cid = 0,userid;
		String cname="",mob,mail_id;
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
		String query="SELECT * FROM customer WHERE userid=?";
		try{
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setInt(1, queryid);
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				if(queryid==rs.getInt("cid"))
				{
					cid=rs.getInt("cid");
					cname=rs.getString("cname");
					mob=rs.getString("mob");
					mail_id=rs.getString("mail_id");
					userid=rs.getInt("userid");
					return rs.getString("cname");
				}
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return cname;
	}

}
