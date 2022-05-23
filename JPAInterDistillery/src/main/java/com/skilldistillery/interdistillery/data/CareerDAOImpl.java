package com.skilldistillery.interdistillery.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.interdistillery.entities.Career;

public class CareerDAOImpl implements CareerDAO {

	@Override
	public Career createCareer(Career career) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		System.out.println("Before persist: " + career);
		em.persist(career);
		System.out.println("After persist: " + career);
		em.flush();
		em.getTransaction().commit();

		return career;
	}

	@Override
	public Career updateCareer(int id, Career career) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
		EntityManager em = emf.createEntityManager();

		return career;

	}

	@Override
	public boolean destoryCareerCategry(int id) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
		EntityManager em = emf.createEntityManager();

		return false;

	}

}
