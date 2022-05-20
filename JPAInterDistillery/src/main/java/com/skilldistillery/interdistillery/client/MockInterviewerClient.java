package com.skilldistillery.interdistillery.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.interdistillery.entities.MockInterviewer;

public class MockInterviewerClient {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("InterDistillery");

		EntityManager em = emf.createEntityManager();

		MockInterviewer mockInterviewer = em.find(MockInterviewer.class, 1);
		System.out.println(mockInterviewer);

		em.close();
		emf.close();

	}
}
