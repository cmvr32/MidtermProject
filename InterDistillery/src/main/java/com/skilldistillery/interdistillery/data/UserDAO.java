package com.skilldistillery.interdistillery.data;

import java.util.List;

import com.skilldistillery.interdistillery.entities.MockInterview;
import com.skilldistillery.interdistillery.entities.Resume;
import com.skilldistillery.interdistillery.entities.User;

public interface UserDAO {

	// read
	// find user account with id
	public User findById(int userId);

	// read
	// ADMIN list all user accounts
	public List<User> findAllUsers();

	// read
	// log into user account
	public User findByUserNameAndPassword(String username, String password);

	// read
	// Find all users resumes
	public List<Resume> findAllCurrentUserResumes(User user);


	// read
	// find user mock interview
	public List<MockInterview> userFindMockInterview(User user, Integer userId);

	// create
	// new user
	public User createUser(User user);

	// update user
	public User updateUser(User user);

	// delete
	public Boolean deleteUser(Integer id);

	//deactivate user
	public User activateUserStatus(User user, Integer userId);	
	
	//change account role
	//user or admin
	public User changeRole(User user, Integer userId);

	



	


}
