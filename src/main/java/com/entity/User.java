package com.entity;

public class User {
private int userid;
private String username;
private String email;
private int password;
private String usertype;
private String state;

public User(String username,String email,int password,String usertype,String state) {
	this.username=username;
	this.email=email;
	this.password=password;
	this.usertype=usertype;
	this.state=state;
	
}

public User() {
	
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

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public int getPassword() {
	return password;
}

public void setPassword(int password) {
	this.password = password;
}

public String getUsertype() {
	return usertype;
}

public void setUsertype(String usertype) {
	this.usertype = usertype;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state ;
}

@Override
public String toString() {
	return "User [userid=" + userid + ", username=" + username + ", email=" + email + ", password=" + password
			+ ", usertype=" + usertype + ", state=" + state + "]";
}



















}
