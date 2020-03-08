package com.mavenproject.dao;

import java.util.List;

import com.mavenproject.model.Category;

public interface Categorydao {
	public boolean addCategory(Category category);
	public boolean updateCategory(Category category);
	public boolean deleteCategory(Category category);
	public Category getCategoryByid(int c_id);
   public List<Category>listCategory();
}
