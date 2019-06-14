package org.alex.entity;

public class Logins {
	private String loginid;
	private String password;
	private String userid;
	private String Roleid;
	
	
	
	public Logins(String loginid, String password, String userid, String roleid) {
		super();
		this.loginid = loginid;
		this.password = password;
		this.userid = userid;
		Roleid = roleid;
	}

	public Logins() {
		
	}
	
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
	
	public String getRoleid() {
		return Roleid;
	}

	public void setRoleid(String roleid) {
		Roleid = roleid;
	}

	@Override
	public String toString() {
		return this.loginid+"--"+this.password+"--"+this.userid;
	}
}
