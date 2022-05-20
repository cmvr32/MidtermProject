package com.skilldistillery.interdistillery.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.interdistillery.entities.User;

public class JobSkillDAOImpl implements JobSkillDAO {

	@Override
	public User createJobSkill(JobSkillDAO jobSkill) {
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
	public User updateJobSkill(int id, JobSkillDAO jobSkill) {
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
