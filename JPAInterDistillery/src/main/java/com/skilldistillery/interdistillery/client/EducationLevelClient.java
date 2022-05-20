package com.skilldistillery.interdistillery.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.interdistillery.entities.EducationLevel;

public class EducationLevelClient {

	public static void main(String[] args) {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("InterDistillery");
		EntityManager em = emf.createEntityManager();
		
		EducationLevel educationLevel = em.find(EducationLevel.class, 1);
		System.out.println(educationLevel);
		
		em.close();
		emf.close();

	}
	
}
