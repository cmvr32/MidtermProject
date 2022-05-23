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

public class JobListingTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private JobListing jobListing;

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
		jobListing = em.find(JobListing.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		em.close();
		jobListing = null;
	}

	@Test
	@DisplayName("testing basic job lsiting mapping")
	void test_basic_job_listing_mapping() {
		assertNotNull(jobListing);
		assertEquals(1, jobListing.getId());
		assertEquals("Java Developer", jobListing.getTitle());
	}

	@Test
	@DisplayName("testing JobListing to resume many to one")
	void testing_user_to_joblisting_one_to_many() {
		System.err.println("testing user to joblisting one to many mapping");
		assertNotNull(jobListing);
		System.out.println(jobListing);
		assertNotNull(jobListing.getResumes());
		assertTrue(jobListing.getResumes().size() > 0);

	}
}
