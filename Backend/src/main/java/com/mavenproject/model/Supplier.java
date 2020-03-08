package com.mavenproject.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table
@Entity
public class Supplier {
	@Id
	@GeneratedValue
	int s_id;
	String s_name,Address;

	public int getId() {
		return s_id;
	}

	public void setId(int id) {
		id = id;
	}

	public String getName() {
		return s_name;
	}

	public void setName(String name) {
		this.s_name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
