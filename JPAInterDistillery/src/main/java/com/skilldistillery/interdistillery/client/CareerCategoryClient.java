package com.skilldistillery.interdistillery.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.interdistillery.entities.CareerCategory;

public class CareerCategoryClient {

	public static void main(String[] args) {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("InterDistillery");
		EntityManager em = emf.createEntityManager();
		
		CareerCategory careerCategory = em.find(CareerCategory.class, 1);
		System.out.println(careerCategory);
		
		em.close();
		emf.close();

	}

}
