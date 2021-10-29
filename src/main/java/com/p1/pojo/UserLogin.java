package com.p1.pojo;

public class UserLogin {

	int userid;
	String username;
	String userpwd;
	
	public UserLogin() {}
	
	public UserLogin( String username,  String userpwd) {
		this.username = username;
		this.userpwd = userpwd;
	}
	
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	@Override
	public String toString() {
		return "UserLogin [userid=" + userid + ", username=" + username + ", userpwd=" + userpwd + "]";
	}
}
