package com.skilldistillery.interdistillery.data;

import java.util.List;

import com.skilldistillery.interdistillery.entities.User;

public interface UserDAO {

	// read
	// find user account with id
	public User findById(int userId);

	// read
	// ADMIN list all user accounts
	public List<User> findAllUsers();

	// read
	// user can find their account with name and email
	public User findUserAccountByNameAndEmail(String firstName, String lastName, String email);

	// read
	// log into user account
	public User findByUserNameAndPassword(String username, String password);

	// read
	// Find all users resumes
	public List<User> findAllCurrentUserResumes(User user);

	// read
	// Find all user study guides
	public List<User> findAllCurrentUserStudyGuides(User user);

	// read
	// Find all user job listings*
	public List<User> findAllCurrentUserJobListings(User user);

	// read
	// find user mock interview
	public List<User> userFindMockInterview(User user);

	// read
	// find mock interviewer
	public User userFindInterviewer();

	// create
	// new user
	public User createUser(User user);

	// update user
	public User updateUser(User user);

	// update user as admin
	public User updateUserAsAdmin(User user);

	public Boolean deleteUser(int id);

}
