package com.skilldistillery.interdistillery.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.interdistillery.entities.Career;

public class CareerClient {

	public static void main(String[] args) {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("InterDistillery");
		EntityManager em = emf.createEntityManager();
		
		Career career = em.find(Career.class, 1);
		System.out.println(career);
		
		em.close();
		emf.close();

	}
	
}
