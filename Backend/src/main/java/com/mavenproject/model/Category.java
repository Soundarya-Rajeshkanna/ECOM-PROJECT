package com.mavenproject.model;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Category {
	@Id
	@GeneratedValue
int c_id;
String cname,cdescription;

	public int getId() {
	return c_id;
}

public void setId(int id) {
	this.c_id = id;
}

public String getName() {
	return cname;
}

public void setName(String name) {
	this.cname = name;
}

public String getDescription() {
	return cdescription;
}

public void setDescription(String description) {
	this.cdescription = description;
}

	
}
