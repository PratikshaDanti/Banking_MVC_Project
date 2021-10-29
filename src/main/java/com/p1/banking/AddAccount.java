package com.p1.banking;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.p1.pojo.Banking;

public class AddAccount {

	public AddAccount() {
		// TODO Auto-generated constructor stub
	}
	
	public Banking addacc(int cid, int ctg_id, Date dateofinit, double accbal){
		Connection con=null;
		int userid=0;
		int account_no;
		
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
		
		String ins="INSERT INTO banking (cid,ctg_id,dateofinit,accbal) VALUES(?,?,?,?)";
		
		PreparedStatement pstmt=null;
		try{
			pstmt=con.prepareStatement(ins);
			pstmt.setInt(1,cid);
			pstmt.setInt(2,ctg_id);
			pstmt.setDate(3,dateofinit);
			pstmt.setDouble(4,accbal);
			pstmt.execute();
			
			
		}catch(SQLException ob3)
		{
			System.err.println("got an exception");
			System.err.println(ob3.getMessage());
		}
		
		
		String query="SELECT * FROM banking where cid=? ORDER BY account_no desc";
		try{
			PreparedStatement pstmt1=con.prepareStatement(query);
			pstmt1.setInt(1, cid);
			ResultSet rs=pstmt1.executeQuery();
			
			while(rs.next())
			{
					account_no=(rs.getInt("account_no"));
					cid=(rs.getInt("cid"));
					ctg_id=(rs.getInt("ctg_id"));
					dateofinit=(rs.getDate("dateofinit"));
					accbal=(rs.getDouble("accbal"));
					Banking b=new Banking(account_no,cid,ctg_id,dateofinit,accbal);
					return b;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
