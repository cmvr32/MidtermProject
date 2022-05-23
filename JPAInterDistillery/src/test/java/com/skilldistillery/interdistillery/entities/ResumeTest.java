package com.skilldistillery.interdistillery.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ResumeTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Resume resume;

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
		resume = em.find(Resume.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {

		em.close();
		resume = null;
	}

	@Test
	@DisplayName("testing Resume mappings")
	void test_basic_resume_mappings() {
		assertNotNull(resume);
		assertEquals("Nathan, Email, Phone", resume.getContactInfo());

	}

	@Test
	@DisplayName("testing Resume mappings")
	void testing_resume_and_education_level_mapping() {
		assertNotNull(resume);
		assertEquals("Bachelors", resume.getResumeEducationLevel().getEducationLevel());

	}

}
