package com.skilldistillery.interdistillery.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.interdistillery.entities.User;

public class JobListingDAOImpl implements JobListingDAO {

	@Override
	public User createJobSkill(JobListingDAO jobSkill) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		System.out.println("Before persist: " + jobSkill);
		em.persist(jobSkill);
		System.out.println("After persist: " + jobSkill);
		em.flush();
		em.getTransaction().commit();
		return null;
	}

	@Override
	public User updateJobSkill(int id, JobListingDAO jobSkill) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
		EntityManager em = emf.createEntityManager();

		return null;
	}

	@Override
	public boolean destroyJobSkill(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
		EntityManager em = emf.createEntityManager();

		return false;
	}

}
