package com.p1.pojo;

import java.sql.Date;

public class Banking {

	int account_no;
	int cid;
	int ctg_id;
	Date dateofinit;
	double accbal;
	public Banking(int account_no, int cid, int ctg_id, Date dateofinit,double accbal) {
		this.account_no = account_no;
		this.cid = cid;
		this.ctg_id = ctg_id;
		this.dateofinit =dateofinit;
		this.accbal = accbal;
	}
	public Banking() {	}
	
	public int getAccount_no() {
		return account_no;
	}
	public void setAccount_no(int account_no) {
		this.account_no = account_no;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getCtg_id() {
		return ctg_id;
	}
	public void setCtg_id(int ctg_id) {
		this.ctg_id = ctg_id;
	}
	public Date getDateofinit() {
		return dateofinit;
	}
	public void setDateofinit(Date dateofinit) {
		this.dateofinit = dateofinit;
	}
	public double getAccbal() {
		return accbal;
	}
	public void setAccbal(double accbal) {
		this.accbal = accbal;
	}
	@Override
	public String toString() {
		return  account_no + "\t" + cid + "\t" + ctg_id + "\t"
				+ dateofinit + "\t" + accbal;
	}

}
