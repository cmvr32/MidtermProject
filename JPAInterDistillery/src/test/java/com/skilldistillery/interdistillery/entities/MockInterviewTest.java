package com.skilldistillery.interdistillery.entities;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
	void test() {
		assertNotNull(mockInterview);
		assertTrue(1, mockInterview.getId());
		assertTrue("java", mockInterview.getTopic());
		
	}

}
