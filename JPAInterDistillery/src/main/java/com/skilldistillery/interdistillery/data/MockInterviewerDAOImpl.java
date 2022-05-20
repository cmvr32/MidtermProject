package com.skilldistillery.interdistillery.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.interdistillery.entities.User;

public class MockInterviewerDAOImpl implements MockInterviewerDAO {

	@Override
	public User createMockIntreviewer(MockInterviewerDAO mockIntreviewer) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		System.out.println("Before persist: " + mockIntreviewer);
		em.persist(mockIntreviewer);
		System.out.println("After persist: " + mockIntreviewer);
		em.flush();
		em.getTransaction().commit();

		return null;
	}

	@Override
	public User updateResume(int id, MockInterviewerDAO mockIntreviewer) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
		EntityManager em = emf.createEntityManager();

		return null;
	}

	@Override
	public boolean destroyMockIntreviewer(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
		EntityManager em = emf.createEntityManager();

		return false;
	}

}
