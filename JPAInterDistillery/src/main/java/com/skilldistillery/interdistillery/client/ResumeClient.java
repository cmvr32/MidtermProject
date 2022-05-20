package com.skilldistillery.interdistillery.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.interdistillery.entities.Resume;

public class ResumeClient {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("InterDistillery");

		EntityManager em = emf.createEntityManager();

		Resume resume = em.find(Resume.class, 1);
		System.out.println(resume);

		em.close();
		emf.close();

	}
}
