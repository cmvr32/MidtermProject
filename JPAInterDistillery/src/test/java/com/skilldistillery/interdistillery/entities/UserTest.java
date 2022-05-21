package com.skilldistillery.interdistillery.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UserTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private User user;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {

		emf = Persistence.createEntityManagerFactory("JPAInterDistillery");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {

		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {

		em = emf.createEntityManager();
		user = em.find(User.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {

		em.close();
		user = null;
	}

	@Test
	void test() {
		assertNotNull(user);
	}

	@Test
	@DisplayName("testing user basic mapping")
	void testing_user_basic_mapping() {
		assertNotNull(user);
		assertEquals("Nathan", user.getFirstName());
		assertEquals("Hafley", user.getLastName());
		assertEquals("nhafley@interDistillery.com", user.getEmail());
		assertEquals("nhadmin", user.getUsername());
		assertEquals("admin", user.getPassword());
	}

	@Test
	@DisplayName("testing user to resume one to many mapping")
	void testing_user_to_resume_mapping() {
		assertNotNull(user);
		assertNotNull(user.getUserResumes());
		assertTrue(user.getUserResumes().size() > 0);
	}

	@Test
	@DisplayName("testing user to mockInterview one to many mapping")
	void testing_user_to_mockInterview_mapping() {
		System.err.println("testing user to mockInterview one to many mapping");
		assertNotNull(user);
		assertNotNull(user.getUserMockInterviews());
		assertTrue(user.getUserMockInterviews().size() > 0);
		System.out.println("testing user to mockInterview one to many mapping");
		System.out.println(user);
		System.out.println(user.getUserMockInterviews());

	}

	@Test
	@DisplayName("testing user to mock interview many to many mapping")
	void testing_user_to_mock_interview_ManyToMany_mapping() {
		System.err.println("testing user to mockInterview many to many mapping");
		assertNotNull(user);
		System.out.println(user);
		assertNotNull(user.getMockInterviewAppointment());
		System.out.println(user.getMockInterviewAppointment());

	}

	@Test
	@DisplayName("testing user to studyguide many to many mapping")
	void test_user_to_studyguide_many_to_many_mapping() {
		System.out.println("testing user to studyguide many to many mapping");
		assertNotNull(user);
		System.out.println(user);
		assertNotNull(user.getUserStudyGuides());
		System.out.println(user.getUserStudyGuides());

	}

}
