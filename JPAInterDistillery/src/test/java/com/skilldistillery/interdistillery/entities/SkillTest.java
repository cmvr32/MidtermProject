package com.skilldistillery.interdistillery.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SkillTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private Skill skill;

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
		skill = em.find(Skill.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {

		em.close();
		skill = null;
	}

	@Test
	@DisplayName("testing skill mappings")
	void test_basic_mappings() {
		assertNotNull(skill);
		assertEquals("Java", skill.getName());

	}

}
