package com.mavenproject.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mavenproject.model.Product;
import com.mavenproject.model.Supplier;
@Repository("productDao")
@Transactional
public class Productdaoimplementation implements Productdao {
	@Autowired
	SessionFactory sessionfactory;

	@Override
	public boolean addProduct(Product product) {
		
		// TODO Auto-generated method stub
		try {
			sessionfactory.getCurrentSession().save(product);
		return true;
		}
		catch(Exception e) {
		return false;
	}
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			sessionfactory.getCurrentSession().update(product);
			return true;
		}
		catch(Exception e) {
			return false;
		}
		
	}

	@Override
	public boolean deleteProduct(Product product) {
		// TODO Auto-generated method stub
		try {
			sessionfactory.getCurrentSession().delete(product);
			return true;
		}
		catch(Exception e)
		{
			return false;
	}
	}
	@Override
	public Product getProductByid(int p_id) {
		// TODO Auto-generated method stub
		
		Session session=sessionfactory.openSession();
		
		Product product =(Product)session.get(Product.class,p_id);
		session.close();
		return product;
	}

	@Override
	public List<Product> listProduct() {
		// TODO Auto-generated method stub
		Session session=sessionfactory.openSession();
		Query query=session.createQuery("from Product");
		List<Product> listproduct=query.list();
		session.close();
		return listproduct;
	}

}
