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

//TODO JOBSKILLTEST
class JobSkillTest {

	private static EntityManagerFactory emf;
	private EntityManager em;
	private JobSkill jSTest1;


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
		CompositeIdJobSkill jid1 = new CompositeIdJobSkill();
		jid1.setResumeId(1);
		jid1.setSkillId(1);
		jSTest1 = em.find(JobSkill.class, jid1);

	}

	@AfterEach
	void tearDown() throws Exception {
		
		em.close();
		jSTest1 = null;
	
	}

	@Test
	@DisplayName("testing job skill composite mapping between skill and resume 1")
	void testing_job_skill_composite_mapping_between_skill_and_resume_1() {

		System.err.println("testing job skill composite mapping between skill and resume 1");
		assertNotNull(jSTest1);
		System.err.println(jSTest1);
		assertNotNull(jSTest1.getSkill());
		assertNotNull(jSTest1.getResume());

		assertNotNull(jSTest1.getResume().getId());
		assertNotNull(jSTest1.getResume().getUser());
		
		assertNotNull(jSTest1.getSkill().getId());
		assertNotNull(jSTest1.getSkill().getName());
		assertEquals("Java", jSTest1.getSkill().getName());
		assertEquals("Write Java Applications", jSTest1.getSkill().getDescription());
		assertEquals("Nathan", jSTest1.getResume().getUser().getFirstName());
		assertEquals("Hafley", jSTest1.getResume().getUser().getLastName());
		
		
		
		
		assertNotNull(jSTest1.getResume().getJobSkills());
		assertNotNull(jSTest1.getSkill().getJobSkills());
		
		assertTrue(jSTest1.getResume().getJobSkills().size() > 0);
		assertTrue(jSTest1.getSkill().getJobSkills().size() > 0);
		
		
		System.out.println(jSTest1.getSkill());
		System.out.println(jSTest1.getResume());
		System.out.println(jSTest1.getResume().getJobSkills().size());
		System.out.println(jSTest1.getSkill().getJobSkills().size());
		System.out.println(jSTest1.getSkill().getName());
		System.out.println(jSTest1.getResume().getUser());

	}

}
