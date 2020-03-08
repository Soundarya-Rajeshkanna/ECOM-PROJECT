package com.mavenproject.dao;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mavenproject.model.User;
@Repository("userDao")
@Transactional


public class Userdaoimplementation implements Userdao {
@Autowired
SessionFactory sessionfactory;

   @Override
	public boolean addUser(User user) {
		// TODO Auto-generated method stub
	   try {
		   sessionfactory.getCurrentSession().save(user);
		   
		   return true;
	   }
      catch(Exception e) {
    	  return false;
      }
	}

@Override
public boolean updateUser(User user) {
	// TODO Auto-generated method stub
	try {
		sessionfactory.getCurrentSession().update(user);
		return true;
	}
	catch(Exception e) {
		return false;
	}
}

@Override
public boolean deleteUser(User user) {
	// TODO Auto-generated method stub
	try {
		sessionfactory.getCurrentSession().delete(user);
		return true;
		
	}
	catch(Exception e) {
		return false;
	}

}

@Override
public User getUserById(int user_id) {
	// TODO Auto-generated method stub
	Session session =sessionfactory.openSession();
	User user =(User)session.get(User.class,user_id);
    session.close();
	return user;
}

@Override
public List<User> listUser() {
	// TODO Auto-generated method stub
	Session session=sessionfactory.openSession();
	Query query=session.createQuery("from User");
	List<User>listuser=query.list();
	session.close();
	return listuser;
}

}
