package com.mavenproject.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mavenproject.dao.Productdao;
import com.mavenproject.model.Product;

public class Productdaotest {
	static Productdao productdao;
	
	@BeforeClass
	public static void initialize() {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		
		context.scan("com.mavenproject");
	context.refresh();
	productdao=(Productdao)context.getBean("productDao");
	}
@Ignore
	@Test
	public void addProductTest() {
		Product product=new Product();
		product.setCategory_id("124");
		
		product.setSupplier_id("421");
		product.setId(1);
		product.setPrice(1000);
		product.setProduct_name("Mac");
		product.setQuantity(500);
		product.setProduct_description("All Mac products are available");
		assertTrue("problem in adding product:",productdao.addProduct(product));
		
	}
	@Ignore
	@Test
	public void updateProductTest()
	{
		Product product=productdao.getProductByid(1);
		product.setPrice(50000);
		assertTrue("problem in updating product:",productdao.updateProduct(product));
		
	}
	
	@Test
	public void deteteProductTest()
	{
		Product product=productdao.getProductByid(2);

		assertTrue("problem in deleting product:",productdao.deleteProduct(product));
		
	}
	@Ignore
	@Test
	public void listProduct()
	{
		List<Product> listproduct=productdao.listProduct();
		for(Product p:listproduct)
		{
			System.out.println(p.getId()+";;;;;;"+p.getProduct_description()+";;;;;;;;;"+p.getProduct_name()+";;;;;;;;;"+p.getQuantity()+";;;;;;;"+p.getPrice()+";;;;;;");
		assertNotNull("problem in listing:",listproduct);
		}
	}
	

}
