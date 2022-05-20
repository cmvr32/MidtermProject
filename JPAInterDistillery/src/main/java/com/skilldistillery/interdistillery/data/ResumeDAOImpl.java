package com.skilldistillery.interdistillery.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.interdistillery.entities.Resume;
import com.skilldistillery.interdistillery.entities.User;

public class ResumeDAOImpl implements ResumeDAO {

	@Override
	public User createResume(Resume resume) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		System.out.println("Before persist: " + resume);
		em.persist(resume);
		System.out.println("After persist: " + resume);
		em.flush();
		em.getTransaction().commit();
		return null;
	}

	@Override
	public User updateResume(int id, Resume resume) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
		EntityManager em = emf.createEntityManager();

		return null;
	}

	@Override
	public boolean destroyResume(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
		EntityManager em = emf.createEntityManager();
		
		return false;
	}

}
