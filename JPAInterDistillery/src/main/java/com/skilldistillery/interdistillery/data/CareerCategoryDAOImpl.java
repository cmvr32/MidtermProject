package com.skilldistillery.interdistillery.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.interdistillery.entities.CareerCategory;

public class CareerCategoryDAOImpl implements CareerCategoryDAO {

	@Override
	public CareerCategory createCareerCategory(CareerCategory careerCategory) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		System.out.println("Before persist: " + careerCategory);
		em.persist(careerCategory);
		System.out.println("After persist: " + careerCategory);
		em.flush();
		em.getTransaction().commit();

		return careerCategory;

	}

	@Override
	public CareerCategory updateCareerCategory(int id, CareerCategory careerCategory) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
		EntityManager em = emf.createEntityManager();

		return careerCategory;

	}

	@Override
	public boolean destoryCareerCategry(int id) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
		EntityManager em = emf.createEntityManager();

		return false;

	}

}
