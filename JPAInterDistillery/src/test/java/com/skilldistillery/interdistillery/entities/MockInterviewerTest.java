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

class MockInterviewerTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private MockInterviewer mockInterviewer;

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
		mockInterviewer = em.find(MockInterviewer.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		mockInterviewer = null;
	}

	@Test
	void test() {
		assertNotNull(mockInterviewer);
		assertTrue();

	}

}
