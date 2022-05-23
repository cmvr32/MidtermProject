package com.skilldistillery.interdistillery.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.interdistillery.entities.User;

@Service
@Transactional
public class UserDaoImpl implements UserDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	// find user by email
	public User findById(int userId) {
		return em.find(User.class, userId);
	}

	@Override
	// find username and password
	public User findByUserNameAndPassword(String username, String password) {

		User userFindUsernameAndPassword = null;
		String jpql = "SELECT c FROM user c WHERE c.username = :un AND c.password=:pw";

		userFindUsernameAndPassword = em.createQuery(jpql, User.class).setParameter("un", username)
				.setParameter("pw", password).getSingleResult();
		System.out.println("---FINDING USER WITH EMAIL AND PASSWORD---");
		System.err.println("LOOKING FOR: " + username + ", " + password);
		System.err.println("NAME FOUND: " + userFindUsernameAndPassword);
		em.close();
		return userFindUsernameAndPassword;

	}

	@Override
	// find user with fname, lname, and email
	public User findUserAccountByNameAndEmail(String firstName, String lastName, String email) {

		User userFindByNameResult = null;
		String jpql = "SELECT c FROM user c WHERE c.fname = :fn AND c.lname=:fn AND c.email=: em";

		userFindByNameResult = em.createQuery(jpql, User.class).setParameter("fn", firstName)
				.setParameter("ln", lastName).setParameter("em", email).getSingleResult();
		System.out.println("---PRINTING FIND USER BY FNAME LNAME EMAIL---");
		System.err.println("LOOKING FOR: " + firstName + ", " + lastName + ", " + email);
		System.err.println("NAME FOUND: " + userFindByNameResult);
		em.close();
		return userFindByNameResult;

	}

	@Override
	// create new user
	// String firstName, String lastName, String email, String userName, String
	// password
	public User createUser(User newUser) {

		boolean newUserCreated = false;

		if (newUser != null) {

			System.out.println("Before persist " + newUser);
			em.persist(newUser);
			System.out.println("After persist " + newUser);

			System.err.println("New Dnd Character Created");
			newUserCreated = true;
		} else {
			System.err.println("Character was not created");
			newUserCreated = false;

		}
		em.close();
		return newUser;

	}

	@Override
	// update user biography
	public User updateUserBiography(String Biography) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	// update user firstname and last name
	public User updateUserfristNameLastName(String fristName, String lastName) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public User updateUserEmail(int id, String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User updateUserNameAndPassword(int id, String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	// delete user
	public Boolean deleteUser(int id, String firstName, String lastName, String userName, String password) {

		boolean successfullyDeleted = false;
		User deleteUser = em.find(User.class, id);
		boolean accountInfoVerification = false;

		if (deleteUser != null) {
			System.err.println("deleteUser not null");
			System.err.println("Verifying fname, lname, username, and password...");

			accountInfoVerification = (deleteUser.getFirstName() == firstName) && (deleteUser.getLastName() == lastName)
					&& (deleteUser.getUserName() == userName) && (deleteUser.getPassword() == password);

			if (accountInfoVerification == true) {
				System.err.println("Delete User ID: " + id);

				em.remove(deleteUser);

				successfullyDeleted = !em.contains(deleteUser);

				System.err.println("Character Deleted ID: " + id);

				// else(){
				System.err.println("Deletion unsuccesful for User ID " + id);
				System.err.println("Incorrect account infromation for Account" + id);

			} else if (accountInfoVerification == false) {
				System.err.println("Could not verify account user information for account Id: " + id);
				System.err.println("First Name, last name, user name, and password");
			}
		} else if (deleteUser == null) {

			System.err.println("Deletion unsuccesful for User ID " + id);
			System.err.println("Could not find acccount with User ID " + id);
		}

		em.close();

		return successfullyDeleted;

	}

	

}