package com.skilldistillery.interdistillery.data;

import com.skilldistillery.interdistillery.entities.User;

public interface UserDAO {

	// read
	// find user account
	User findById(int userId);

	// read
	// user can find their account
	User findUserAccountByNameAndEmail(String firstName, String LastName, String Email);

	// read
	// log into user account
	User findByUserNameAndPassword(String username, String password);

	// create
	// new user
	User createUser(User user);

	// update
	// update user Biography
	User updateUserBiography(String Biography);

	// update
	// user first and last name
	User updateUserfristNameLastName(String fristName, String lastName);
	
	//update
	//update user email
	User updateUserEmail(int id, String email);
	
	//update
	//update username and password
	User updateUserNameAndPassword(int id, String username, String password);

	// delete
	Boolean deleteUser(int id, String firstName, String lastName, String userName, String password);
	

}
