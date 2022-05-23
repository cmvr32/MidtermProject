package com.skilldistillery.interdistillery.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class compositeIdJobSkill {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("InterDistillery");
		EntityManager em = emf.createEntityManager();

		compositeIdJobSkill skillId = em.find(compositeIdJobSkill.class, 1);
		System.out.println(skillId);

		em.close();
		emf.close();

	}

}
