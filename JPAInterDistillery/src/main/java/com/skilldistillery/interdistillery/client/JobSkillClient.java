package com.skilldistillery.interdistillery.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JobSkillClient {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");

		EntityManager em = emf.createEntityManager();

		em.close();
		emf.close();

	}
}
