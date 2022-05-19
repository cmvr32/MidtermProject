package com.skilldistillery.interdistillery.data;

import com.skilldistillery.interdistillery.entities.User;

public interface UserDAO {
	
	User findById(int userId);
	User findByUserNameAndPassword(String username, String password);

}
