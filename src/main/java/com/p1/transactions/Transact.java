package com.p1.transactions;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Transact {

	public Transact() {	}
	
	public void deposit(int x,double amount,int queryid){
		Connection con=null;
		String comments;
		int trn_id,account_no;
		Date trn_date;

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
		
		double currentbal=0.0;
		int cid,ctg_id;
		Date dateofinit;
		String query="SELECT * FROM Banking WHERE account_no=? and cid=?";
		try{
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setInt(1, x);
			pstmt.setInt(2, queryid);
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				if(x==rs.getInt("account_no") && (queryid==rs.getInt("cid")))
				{
					account_no=rs.getInt("account_no");
					cid=rs.getInt("cid");
					ctg_id=rs.getInt("ctg_id");
					dateofinit=rs.getDate("dateofinit");
					currentbal=rs.getDouble("accbal");
					break;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if(currentbal>0) {
		String ins="UPDATE banking b,transactions d SET b.accbal=? WHERE b.account_no=? AND b.account_no=d.account_no";
		PreparedStatement pstmt=null;
		try {
			pstmt=con.prepareStatement(ins);
			pstmt.setDouble(1, currentbal+amount);
			pstmt.setInt(2, x);
			pstmt.execute();
		}catch(SQLException ob3)
		{
			System.err.println("got an exception");
			System.err.println(ob3.getMessage());
		}
		}
	}
	
	public void withdraw(int x,double amount,int queryid){
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
		double currentbal=0.0;
		int cid,ctg_id,account_no;
		Date dateofinit;
		String query="SELECT * FROM Banking WHERE account_no=? and cid=?";
		try{
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setInt(1, x);
			pstmt.setInt(2, queryid);
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next())
			{
				if(x==rs.getInt("account_no")&& (queryid==rs.getInt("cid")))
				{
					account_no=rs.getInt("account_no");
					cid=rs.getInt("cid");
					ctg_id=rs.getInt("ctg_id");
					dateofinit=rs.getDate("dateofinit");
					currentbal=rs.getDouble("accbal");
					break;
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if(currentbal>0)
		{String ins="UPDATE banking b,transactions d SET b.accbal=? WHERE b.account_no=? AND b.account_no=d.account_no";
		PreparedStatement pstmt=null;
		try {
			pstmt=con.prepareStatement(ins);
			pstmt.setDouble(1, currentbal-amount);
			pstmt.setInt(2, x);
			pstmt.execute();
		}catch(SQLException ob3)
		{
			System.err.println("got an exception");
			System.err.println(ob3.getMessage());
		}
		}
	}

}
