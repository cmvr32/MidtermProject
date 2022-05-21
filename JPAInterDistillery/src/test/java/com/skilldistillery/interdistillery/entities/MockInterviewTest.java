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

class MockInterviewTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private MockInterview mockInterview;

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
		mockInterview = em.find(MockInterview.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		mockInterview = null;
	}

	@Test
	@DisplayName("testing mock interview")
	void test_mock_interview() {
		assertNotNull(mockInterview);

	}

	@Test
	@DisplayName("testing mock interview basic mapping")
	void test_basic_mock_interview_basic_mapping() {
		assertNotNull(mockInterview);
		assertEquals(1, mockInterview.getId());
		assertEquals("java", mockInterview.getTopic());

	}

	@Test
	@DisplayName("testing mock interview and user many to one mapping")
	void test_mock_interview_and_user_one_to_many() {

		System.err.println("testing mock interview and user many to one mapping");
		System.out.println(mockInterview);
		assertNotNull(mockInterview);
		assertEquals(1, mockInterview.getId());
		assertNotNull(mockInterview.getInterviewee());
		System.out.println(mockInterview.getInterviewee());

	}

	@Test
	@DisplayName("testing mock interview and user many to many mapping")
	void test_mock_interview_and_user_ManyToMany_mapping() {
		assertNotNull(mockInterview);
		assertNotNull(mockInterview.getUserInterviews());
		assertTrue(mockInterview.getUserInterviews().size() > 0);
		System.err.println("testing mock interview and user many to many mapping");
		System.out.println(mockInterview);
		System.out.println(mockInterview.getUserInterviews());

	}

}
