package com.mavenproject.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mavenproject.dao.Supplierdao;
import com.mavenproject.model.Supplier;

public class Supplierdaotest {
	static Supplierdao supplierdao;
	
@BeforeClass
public static void initialize() {
	 AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
	 
	 context.scan("com.mavenproject");
	 
	 context.refresh();
	 supplierdao=(Supplierdao)context.getBean("supplierDao");
	 
}
	@Test
	public void addSupplierTest() {
		Supplier supplier =new Supplier();
		supplier.setName("Soundarya");
		supplier.setAddress("Guindy");
		supplier.setId(321);
		assertTrue("problem in adding supplier:",supplierdao.addSupplier(supplier));
	}

}
