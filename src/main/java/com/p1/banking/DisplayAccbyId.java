package com.p1.banking;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.p1.pojo.Banking;
import com.p1.pojo.Customer;

public class DisplayAccbyId {

	public DisplayAccbyId() {
		// TODO Auto-generated constructor stub
	}
	public LinkedList<Banking> displaybyid(int queryid){
		int account_no,cid,ctg_id;
		Date dateofinit;
		double accbal;
		LinkedList<Banking> bl=new LinkedList<Banking>();
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
	String query="SELECT * FROM banking WHERE cid=?";
	try{
		PreparedStatement pstmt1=con.prepareStatement(query);
		pstmt1.setInt(1, queryid);
		ResultSet rs=pstmt1.executeQuery();
		
		while(rs.next())
		{
			if(queryid==rs.getInt("cid"))
			{		
				account_no=rs.getInt("account_no");
				cid=rs.getInt("cid");
				ctg_id=rs.getInt("ctg_id");
				dateofinit=rs.getDate("dateofinit");
				accbal=rs.getDouble("accbal");
				Banking b=new Banking(account_no,cid,ctg_id,dateofinit,accbal);
				bl.add(b);
			}
		}
		
	}catch(SQLException e) {
		e.printStackTrace();
	}
	
	return bl;
	}
}