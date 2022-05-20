package com.skilldistillery.interdistillery.data;

import com.skilldistillery.interdistillery.entities.User;

public interface UserDAO {

	public User createUser(User user);

	public User updateUser(int id, User user);

	public boolean destroyUser(int id);

}
