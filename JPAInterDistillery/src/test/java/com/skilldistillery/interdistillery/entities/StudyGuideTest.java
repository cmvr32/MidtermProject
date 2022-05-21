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

class StudyGuideTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private StudyGuide studyGuide;

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
		studyGuide = em.find(StudyGuide.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {

		em.close();
		studyGuide = null;
	}

	@Test
	@DisplayName("testing StudyGuide mappings")
	void test_basic_mappings() {
		assertNotNull(studyGuide);
		assertEquals("Java Study Guide", studyGuide.getTopic());

	}

	@Test
	@DisplayName("testing studyguide to user many to many mapping")
	void test_studyguide_to_user_many_to_many_mapping() {
		System.out.println("testing user to studyguide many to many mapping");
		assertNotNull(studyGuide);
		System.out.println(studyGuide);
		assertNotNull(studyGuide.getUsersWithStudyGuides());
		System.out.println(studyGuide.getUsersWithStudyGuides());
	}

}
