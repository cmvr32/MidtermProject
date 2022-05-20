package com.skilldistillery.interdistillery.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.interdistillery.entities.MockInterview;
import com.skilldistillery.interdistillery.entities.User;

public class MockInterviewDAOImpl implements MockInterviewDAO {

	@Override
	public User createMockInterview(MockInterview mockInterview) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		System.out.println("Before persist: " + mockInterview);
		em.persist(mockInterview);
		System.out.println("After persist: " + mockInterview);
		em.flush();
		em.getTransaction().commit();
		return null;
	}

	@Override
	public User updateMockInterview(int id, MockInterview mockInterview) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
		EntityManager em = emf.createEntityManager();

		return null;
	}

	@Override
	public boolean destroyMockInterview(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
		EntityManager em = emf.createEntityManager();

		return false;
	}

}
