package com.p1.login;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;

import com.p1.pojo.UserSession;

public class DisplaySessionById {

	public DisplaySessionById() {
		// TODO Auto-generated constructor stub
	}
	public LinkedList<UserSession> displaysessbyid(int queryid){
		Connection con=null;
		String sid;
		int userid;
		Timestamp createtime,lastaccesstime;
		LinkedList<UserSession> arr=new LinkedList<UserSession>();
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
		String query="SELECT * FROM usersession WHERE userid=?";
		try{
			
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setInt(1, queryid);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				if(queryid==rs.getInt("userid"))
				{
					createtime=(rs.getTimestamp("createtime"));
					lastaccesstime=(rs.getTimestamp("lastaccesstime"));
					sid=(rs.getString("sid"));
					userid=(rs.getInt("userid"));
					
					UserSession t=new UserSession(createtime,lastaccesstime,sid,userid);
					arr.add(t);
				}
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
}
