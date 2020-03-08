package com.mavenproject.test;

import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mavenproject.dao.Productdao;
import com.mavenproject.dao.Userdao;
import com.mavenproject.model.User;

public class Userdaotest {
	static Userdao userdao;
	
	@BeforeClass
	public static void initialize() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.mavenproject");
		context.refresh();
		userdao=(Userdao)context.getBean("userDao");
		}
	@Ignore
	@Test
	public void addUserTest() {
		User user=new User();
		user.setUser_name("Soundarya");
		user.setUser_email_id("asm@gmail.com");
		user.setContact_no("9127665340");
		assertTrue("problem in adding ",userdao.addUser(user));
	}

@Test
public void updateUserTest() {
	User user=userdao.getUserById(2);
	user.setUser_name("Mahalakshmi");
	user.setUser_email_id("mht@gmail.com");
	user.setContact_no("9127668740");
	assertTrue("problem in adding ",userdao.updateUser(user));
}
@Ignore
@Test
public void deleteUserTest() {
	User user=userdao.getUserById(4);
	
	assertTrue("problem in adding ",userdao.deleteUser(user));
}
}
		
		
	