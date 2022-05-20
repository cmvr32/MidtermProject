package com.skilldistillery.interdistillery.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.interdistillery.entities.JobSkill;

public class JobSkillClient {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");

		EntityManager em = emf.createEntityManager();

		JobSkill jobSkill = em.find(JobSkill.class, 1);
		System.out.println(jobSkill);

		em.close();
		emf.close();

	}
}
