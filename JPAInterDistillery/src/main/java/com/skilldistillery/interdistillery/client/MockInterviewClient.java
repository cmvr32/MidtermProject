package com.skilldistillery.interdistillery.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.interdistillery.entities.MockInterview;

public class MockInterviewClient {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("VideoStore");

		EntityManager em = emf.createEntityManager();

		MockInterview mockInterview = em.find(MockInterview.class, 1);
		System.out.println(mockInterview);

		em.close();
		emf.close();

	}
}
