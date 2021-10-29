package com.p1.pojo;

import java.sql.Date;
import java.sql.Timestamp;

public class UserSession {
	Timestamp createtime;
	Timestamp lastaccesstime ;
	String sid;
	int userid;
	
	public UserSession() {}
	
	public UserSession(Timestamp createtime, Timestamp lastaccesstime, String sid, int userid) {
		this.createtime = createtime;
		this.lastaccesstime = lastaccesstime;
		this.sid = sid;
		this.userid = userid;
	}
	
	public UserSession(Timestamp lastaccesstime) {
		this.lastaccesstime = lastaccesstime;

	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public Timestamp getLastaccesstime() {
		return lastaccesstime;
	}
	public void setLastaccesstime(Timestamp lastaccesstime) {
		this.lastaccesstime = lastaccesstime;
	}
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}

}
