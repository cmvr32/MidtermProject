package com.skilldistillery.interdistillery.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JobListingClient {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("InterDistillery");
		EntityManager em = emf.createEntityManager();

		JobListingClient jobListing = em.find(JobListingClient.class, 1);
		System.out.println(jobListing);

		em.close();
		emf.close();

	}

}
