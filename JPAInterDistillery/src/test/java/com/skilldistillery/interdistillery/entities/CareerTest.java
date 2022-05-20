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

class CareerTest {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Career career;

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
		career = em.find(Career.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		career = null;
	}

	@Test
	@DisplayName("testing basic career mapping")
	void test() {
		assertNotNull(career);
		assertEquals(1, career.getId());
		assertEquals("Java Developer", career.getCareerTitle());
		
	}

}
