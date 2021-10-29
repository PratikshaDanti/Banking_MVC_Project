package com.p1.transactions;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.p1.pojo.Transactions;


public class DisplayTransById {

	public DisplayTransById() {
		
	}
	public LinkedList<Transactions> displaytranbyid(int queryid){
		Connection con=null;
		String comments;
		int trn_id,account_no,cid,ctg_id;
		Date trn_date,dateofinit;
		double amount,accbal;
		LinkedList<Transactions> arr=new LinkedList<Transactions>();
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
		String query="select * from transactions t, banking b where b.account_no=t.account_no and cid=?";
		try{
			
			PreparedStatement pstmt=con.prepareStatement(query);
			pstmt.setInt(1, queryid);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next())
			{
				if(queryid==rs.getInt("cid"))
				{
					trn_id=(rs.getInt("trn_id"));
					account_no=(rs.getInt("account_no"));
					trn_date=(rs.getDate("trn_date"));
					amount=(rs.getDouble("amount"));
					comments=(rs.getString("comments"));
					account_no=rs.getInt("account_no");
					cid=rs.getInt("cid");
					ctg_id=rs.getInt("ctg_id");
					dateofinit=rs.getDate("dateofinit");
					accbal=rs.getDouble("accbal");
					Transactions t=new Transactions(trn_id,account_no,trn_date,amount,comments);
					arr.add(t);
				}
				
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}

}
