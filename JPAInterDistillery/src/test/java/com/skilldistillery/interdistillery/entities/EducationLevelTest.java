package com.skilldistillery.interdistillery.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EducationLevelTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private EducationLevel educationLevel;

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
		educationLevel = em.find(EducationLevel.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		educationLevel = null;
	}

	

	@Test
	@DisplayName("testing basic careerCategory mapping")
	void test() {
		assertNotNull(educationLevel);
		assertEquals(1, educationLevel.getId());
		assertEquals("Bachelors", educationLevel.getEducationLevel());
	}


}
