package com.mavenproject.dao;

import java.util.List;


import org.hibernate.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mavenproject.model.Supplier;
@Repository("supplierDao")
@Transactional

public class Supplierdaoimplementation implements Supplierdao {
@Autowired
SessionFactory sessionfactory;

	@Override
	public boolean addSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		try {
			sessionfactory.getCurrentSession().save(supplier);
			
		
		return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean updateSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		try {
			sessionfactory.getCurrentSession().update(supplier);
			return true;
		}
		catch(Exception e) {
			return false;	
		}
	}

	@Override
	public boolean deleteSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		try {
			sessionfactory.getCurrentSession().delete(supplier);
			return true;
		}
		catch(Exception e) {
			return false;	
		}
		
	}

	@Override
	public Supplier getSupplierById(int s_id) {
		// TODO Auto-generated method stub
		Session session=sessionfactory.openSession();
		Supplier supplier =(Supplier)session.get(Supplier.class,s_id);
		session.close();
		return supplier;
	}

	@Override
	public List<Supplier> listSupplier() {
		// TODO Auto-generated method stub
		Session session=sessionfactory.openSession();
		Query query=session.createQuery("from Supplier");
		List<Supplier> listsupplier=query.list();
		session.close();
		return listsupplier;
		
	}

}
