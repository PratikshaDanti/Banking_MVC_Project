package com.p1.customer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.p1.pojo.Customer;


public class DisplayCustById {

	public DisplayCustById() {	}
	
		public Customer displaybyid(int queryid,Customer c){
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
			String query="SELECT * FROM customer WHERE cid=?";
			try{
				PreparedStatement pstmt=con.prepareStatement(query);
				pstmt.setInt(1, queryid);
				ResultSet rs=pstmt.executeQuery();
				
				while(rs.next())
				{
					if(queryid==rs.getInt("cid"))
					{
						c.setCid(rs.getInt("cid"));
						c.setCname(rs.getString("cname"));
						c.setMob(rs.getString("mob"));
						c.setMail_id(rs.getString("mail_id"));
						c.setUid(rs.getInt("userid"));
						break;
					}
				}
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return c;
		}
}
