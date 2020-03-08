package com.mavenproject.test;

import static org.junit.Assert.*;


import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.mavenproject.dao.Categorydao;
import com.mavenproject.model.Category;


public class Categorydaotest {
static Categorydao categorydao;

@BeforeClass
public static void initialize() {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
	
	context.scan("com.mavenproject");
	
	context.refresh();
	categorydao = (Categorydao)context.getBean("categoryDao");
 
	
}

	@Test
	public void addCategoryTest() {
		Category category = new Category();
		category.setDescription("All mobiles are available");
		category.setName("Mobile");
		assertTrue("problem in adding category:",categorydao.addCategory(category));
	}
	@Ignore
	@Test
	public void updateCategoryTest()
	{
		Category category=categorydao.getCategoryByid(1);
		category.setName("Cosmetics");
		assertTrue("problem in updating product:",categorydao.updateCategory(category));
		
	}
	@Ignore
	@Test
	public void deteteCategoryTest()
	{
		Category category=categorydao.getCategoryByid(2);

		assertTrue("problem in deleting category:",categorydao.deleteCategory(category));
		
	}
	@Ignore
	@Test
	public void listCategory()
	{
		List<Category> listcategory=categorydao.listCategory();
		for(Category c:listcategory)
		{
			System.out.println(c.getId()+";;;;;;"+c.getName()+";;;;;"+c.getDescription()+";;;;;;");
		assertNotNull("problem in listing:",listcategory);
		}
	}
	

}

	

