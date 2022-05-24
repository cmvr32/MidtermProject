package com.skilldistillery.interdistillery.data;

import java.util.List;

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
	// find user by Id
	public User findById(int userId) {
		return em.find(User.class, userId);
	}

	@Override
	// read
	// ADMIN list all users
	// TODO create admin permissions
	public List<User> findAllUsers() {
		String jpql = "SELECT c FROM user c";
		return em.createQuery(jpql, User.class).getResultList();
	}

	@Override
	// find username and password
	// used to login in user
	// TODO user login
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

		User userFindByNameAndEmailResult = null;
		String jpql = "SELECT c FROM user c WHERE c.fname = :fn AND c.lname=:fn AND c.email=: em";

		userFindByNameAndEmailResult = em.createQuery(jpql, User.class).setParameter("fn", firstName)
				.setParameter("ln", lastName).setParameter("em", email).getSingleResult();
		System.out.println("---PRINTING FIND USER BY FNAME LNAME EMAIL---");
		System.err.println("LOOKING FOR: " + firstName + ", " + lastName + ", " + email);
		System.err.println("NAME FOUND: " + userFindByNameAndEmailResult);

		boolean userFound = false;

		if (userFindByNameAndEmailResult != null) {
			System.err.println("FOUND USER");
			System.out.println("USER ID: " + userFindByNameAndEmailResult.getId());
			userFound = true;

		} else if (userFindByNameAndEmailResult == null) {
			System.out.println("User not found");
			System.out.println("PARAMETERS: " + firstName + " " + lastName + " " + email);
			userFound = false;

		}
		return userFindByNameAndEmailResult;
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
	// user update
	public User updateUser(User user) {

		boolean userUpdated = false;

		User userToUpdate = em.find(User.class, user.getId());
		if (userToUpdate != null) {
			userToUpdate.setFirstName(user.getFirstName());
			userToUpdate.setLastName(user.getLastName());
			userToUpdate.setUserName(user.getUserName());
			userToUpdate.setPassword(user.getPassword());
			userToUpdate.setProfileImageUrl(user.getProfileImageUrl());
			userToUpdate.setBannerImageUrl(user.getBannerImageUrl());
			userToUpdate.setBiography(user.getBiography());

			userUpdated = true;

		} else if (userToUpdate == null) {

			System.out.println("User update failed");
			System.out.println("User not found");

			userUpdated = true;
		}
		em.close();
		return userToUpdate;

	}

	@Override
	// user update as admin
	public User updateUserAsAdmin(User user) {

		User userToUpdate = em.find(User.class, user.getId());
		boolean userUpdated = false;

		if (userToUpdate != null) {

			userToUpdate = em.find(User.class, user.getId());
			userToUpdate.setActive(user.getActive());
			userToUpdate.setRole(user.getRole());
			userToUpdate.setUserName(user.getUserName());
			userToUpdate.setPassword(user.getPassword());

			userUpdated = true;

		} else if (userToUpdate == null) {

			System.out.println("User update failed");
			System.out.println("User not found");

			userUpdated = false;
		}
		em.close();
		return user;
	}

	@Override
	// delete user
	public Boolean deleteUser(int id) {

		boolean successfullyDeleted = false;
		User deleteUser = em.find(User.class, id);

		if (deleteUser != null) {
			System.err.println("deleteUser not null");
			
			em.remove(deleteUser);

			successfullyDeleted = !em.contains(deleteUser);

			System.err.println("Character Deleted ID: " + id);
		}

		em.close();
		return successfullyDeleted;

	}

	@Override
	// find all resumes for the current user
	public List<User> findAllCurrentUserResumes(User user) {

		Boolean resumeListFound = false;
		List<User> completeResumeList = null;
		Integer userId = user.getId();
		String jpql = "SELECT c.userResumes FROM User c WHERE c.id=: id";
		completeResumeList = em.createQuery(jpql, User.class).setParameter("id", userId).getResultList();

		System.err.println("---FINDING ALL CURRENT USER RESUMES---");

		if (completeResumeList != null) {

			resumeListFound = true;

			for (User resume : completeResumeList) {

				System.out.println(resume);

			}

		} else if (completeResumeList == null) {

			resumeListFound = false;
			System.err.println("USER RESUME LIST NOT FOUND");
			System.out.println("USER ID: " + userId);
		}
		return completeResumeList;

	}

	@Override
	//find all study guides a user has
	public List<User> findAllCurrentUserStudyGuides(User user) {

		Boolean studyGuideListFound = false;
		List<User> completeStudyGuideList = null;
		Integer userId = user.getId();
		String jpql = "SELECT c.studyGuidesThatThisUserHas FROM User c WHERE c.id=: id";
		completeStudyGuideList = em.createQuery(jpql, User.class).setParameter("id", userId).getResultList();

		System.err.println("---FINDING ALL CURRENT USER STUDYGUIDES---");

		if (completeStudyGuideList != null) {

			studyGuideListFound = true;

			for (User studyguide : completeStudyGuideList) {

				System.out.println(studyguide);

			}

		} else if (completeStudyGuideList == null) {

			studyGuideListFound = false;
			System.err.println("USER STUDYGUIDE LIST NOT FOUND");
			System.out.println("USER ID: " + userId);
		}
		return completeStudyGuideList;
	}

	@Override
	//find every job listing a user has checked
	public List<User> findAllCurrentUserJobListings(User user) {

		Boolean jobListFound = false;
		List<User> userJobList = null;
		Integer userId = user.getId();
		String jpql = "SELECT c.jobListings FROM User c WHERE c.id=: id";
		userJobList = em.createQuery(jpql, User.class).setParameter("id", userId).getResultList();

		System.err.println("---FINDING ALL CURRENT USER JOBLISTINGS---");

		if (userJobList != null) {

			jobListFound = true;

			for (User jobList : userJobList) {

				System.out.println(jobList);

			}

		} else if (userJobList == null) {

			jobListFound = false;
			System.err.println("USER jobList LIST NOT FOUND");
			System.out.println("USER ID: " + userId);
		}
		return userJobList;
	}

	@Override
	//find the mock interviews a user has
	public List<User> userFindMockInterview(User user) {

		Boolean hasMockInterview = false;
		List<User> userInterviewList = null;
		Integer userId = user.getId();
		String jpql = "SELECT c.userMockInterviews FROM User c WHERE c.id=: id";
		userInterviewList = em.createQuery(jpql, User.class).setParameter("id", userId).getResultList();

		System.err.println("---FINDING ALL CURRENT USER MOCK INTERVIEWS---");

		if (userInterviewList != null) {

			hasMockInterview = true;

			for (User interview : userInterviewList) {

				System.out.println(interview);

			}

		} else if (userInterviewList == null) {

			hasMockInterview = false;
			System.err.println("USER INTERVIEW LIST NOT FOUND");
			System.out.println("USER ID: " + userId);
		}
		return userInterviewList;

	}

	@Override
	public User userFindInterviewer() {
		// TODO Auto-generated method stub
		return null;
	}

}