package com.mavenproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class User {
String user_name,user_email_id,contact_no;
String password;
public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getContact_no() {
	return contact_no;
}

@Id
@GeneratedValue
int user_id;
public int getUser_id() {
	return user_id;
}

public void setUser_id(int user_id) {
	this.user_id = user_id;
}




public void setContact_no(String contact_no) {
	this.contact_no = contact_no;
}






	public String getUser_name() {
	return user_name;
}

public void setUser_name(String user_name) {
	this.user_name = user_name;
}

public String getUser_email_id() {
	return user_email_id;
}

public void setUser_email_id(String user_email_id) {
	this.user_email_id = user_email_id;
}







	
}
