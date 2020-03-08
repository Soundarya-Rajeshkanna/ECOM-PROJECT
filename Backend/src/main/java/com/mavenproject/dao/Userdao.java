package com.mavenproject.dao;

import java.util.List;

import com.mavenproject.model.User;



public interface Userdao {
	
		public boolean addUser(User user);
		public boolean updateUser(User user);
		public boolean deleteUser(User user);
		public User getUserById(int user_id);
	   public List<User>listUser();
	
}
