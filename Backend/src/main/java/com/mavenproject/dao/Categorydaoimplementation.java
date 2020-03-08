package com.mavenproject.dao;

import java.util.List;

import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mavenproject.model.Category;
@Repository("categoryDao")
@Transactional
public class Categorydaoimplementation implements Categorydao {
	@Autowired
	 SessionFactory sessionfactory;

	@Override
	public boolean addCategory(Category category) {
		// TODO Auto-generated method stub
		try {
			sessionfactory.getCurrentSession().save(category);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateCategory(Category category) {
		// TODO Auto-generated method stub
		try {
			sessionfactory.getCurrentSession().update(category);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean deleteCategory(Category category) {
		// TODO Auto-generated method stub
		try {
			sessionfactory.getCurrentSession().delete(category);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public Category getCategoryByid(int c_id) {
		// TODO Auto-generated method stub
		Session session=sessionfactory.openSession();
		Category category=(Category)session.get(Category.class,c_id);
		session.close();
		return category;
	}

	@Override
	public List<Category> listCategory() {
		// TODO Auto-generated method stub
		Session session=sessionfactory.openSession();
		Query query=session.createQuery("from Category");
		List<Category> listcategory=query.list();
		session.close();
		return listcategory;
		
		
	}

}
