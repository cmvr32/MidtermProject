package com.skilldistillery.interdistillery.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.interdistillery.entities.MockInterview;
import com.skilldistillery.interdistillery.entities.Resume;
import com.skilldistillery.interdistillery.entities.User;

@Service
@Transactional
public class UserDaoImpl implements UserDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	// find user by Id
	public User findById(int id) {

		List<User> userAccountInfo = null;
		String jpql = "SELECT c FROM User c WHERE c.id=:id";

		userAccountInfo = em.createQuery(jpql, User.class).setParameter("id", id).getResultList();
		System.err.println("---FINDING USER BY ID--");
		if (userAccountInfo != null && !userAccountInfo.isEmpty()) {

			System.err.println("LOOKING FOR: " + id);
			System.err.println("ACCOUNT FOUND");

			return userAccountInfo.get(0);
		}

		System.err.println("---USER NOT FOUND---");
		return null;
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

		List<User> userFindUsernameAndPassword = null;
		String jpql = "SELECT c FROM User c WHERE c.username = :un AND c.password=:pw";

		userFindUsernameAndPassword = em.createQuery(jpql, User.class).setParameter("un", username)
				.setParameter("pw", password).getResultList();
		if (userFindUsernameAndPassword != null && !userFindUsernameAndPassword.isEmpty()) {

			System.out.println("---FINDING USER WITH USERNAME AND PASSWORD---");
			System.err.println("LOOKING FOR: " + username + ", " + password);
			System.err.println("NAME FOUND: " + userFindUsernameAndPassword);

			return userFindUsernameAndPassword.get(0);

		}

		return null;

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

		return newUser;

	}

	@Override
	// user update
	public User updateUser(User user) {

		boolean userUpdated = false;

		System.err.println("---USER UPDATE DAO BEGIN---");

		User userToUpdate = em.find(User.class, user.getId());
		if (userToUpdate != null) {
			System.err.println("---USER FOUND NOW UPDATING---");
			userToUpdate.setFirstName(user.getFirstName());
			userToUpdate.setLastName(user.getLastName());
			userToUpdate.setEmail(user.getEmail());
			userToUpdate.setUsername(user.getUsername());
			userToUpdate.setPassword(user.getPassword());
			userToUpdate.setProfileImageUrl(user.getProfileImageUrl());
			userToUpdate.setBiography(user.getBiography());

			userUpdated = true;
			System.err.println("---USER UPDATED---");
			return userToUpdate;

		} else if (userToUpdate == null) {

			System.out.println("User update failed");
			System.out.println("User not found");

			userUpdated = true;
			return null;
		}
		return null;

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
			userToUpdate.setUsername(user.getUsername());
			userToUpdate.setPassword(user.getPassword());

			userUpdated = true;

		} else if (userToUpdate == null) {

			System.out.println("User update failed");
			System.out.println("User not found");

			userUpdated = false;
		}

		return user;
	}

	// delete user
	public Boolean deleteUser(Integer id) {

		boolean successfullyDeleted = false;
		User deleteUser = em.find(User.class, id);

		if (deleteUser != null) {
			System.err.println("deleteUser not null");

			em.remove(deleteUser);

			successfullyDeleted = !em.contains(deleteUser);

			System.err.println("Character Deleted ID: " + id);
		}

		return successfullyDeleted;

	}

	@Override
	// find all resumes for the current user
	public List<Resume> findAllCurrentUserResumes(User user) {

		Boolean resumeListFound = false;
		List<Resume> completeResumeList = null;
		Integer userId = user.getId();
		String jpql = "SELECT r FROM Resume r WHERE r.user.id=:id";
		completeResumeList = em.createQuery(jpql, Resume.class).setParameter("id", userId).getResultList();

		System.err.println("---FINDING ALL CURRENT USER RESUMES---");

		if (completeResumeList != null) {

			resumeListFound = true;

		} else if (completeResumeList == null) {

			resumeListFound = false;
			System.err.println("USER RESUME LIST NOT FOUND");
			System.out.println("USER ID: " + userId);
		}
		return completeResumeList;

	}

	@Override
	// find all study guides a user has
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
	// find every job listing a user has checked
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
	// find the mock interviews a user has
	public List<MockInterview> userFindMockInterview(User user, Integer userId) {

		System.err.println("---STARTING FIND ALL CURRENT USER MOCK INTERVIEWS---");
		System.out.println("USER: " + user);
		System.out.println("USER ID: " + userId);
		Boolean hasMockInterview = false;
		List<MockInterview> userInterviewList = null;
//		Integer userId = user.getId();
//		String jpql = "SELECT c.UserInterviews FROM MockInterview c WHERE c.id=: id";
//		userInterviewList = em.createQuery(jpql, User.class).setParameter("id", userId).getResultList();
		
		
		String jpql = "SELECT i FROM MockInterview i WHERE i.interviewee=: user";
		userInterviewList = em.createQuery(jpql, MockInterview.class).setParameter("user", user).getResultList();

		System.err.println("---FINDING ALL CURRENT USER MOCK INTERVIEWS---");

		System.out.println("USER INTERVIEW LIST");

		if (userInterviewList != null) {

			hasMockInterview = true;

			System.err.println("---FOUND USER INTERVIEW---");

			for (MockInterview interview : userInterviewList) {

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

	@Override
	public List<User> userFindMockInterview(User user) {
		// TODO Auto-generated method stub
		return null;
	}
}