package com.skilldistillery.interdistillery.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.interdistillery.entities.EducationLevel;

public class EducationLevelDAOImpl implements EducationLevelDAO {

	@Override
	public EducationLevel createEducationLevel(EducationLevel educationLevel) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		System.out.println("Before persist: " + educationLevel);
		em.persist(educationLevel);
		System.out.println("After persist: " + educationLevel);
		em.flush();
		em.getTransaction().commit();

		return educationLevel;

	}

	@Override
	public EducationLevel updateEducationLevel(int id, EducationLevel educationLevel) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
		EntityManager em = emf.createEntityManager();

		return educationLevel;

	}

	@Override
	public boolean destroyEducationLevel(int id) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
		EntityManager em = emf.createEntityManager();

		return false;

	}

}
