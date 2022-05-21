package com.skilldistillery.interdistillery.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.interdistillery.entities.StudyGuide;

public class StudyGuideDAOImpl implements StudyGuideDAO {

	@Override
	public StudyGuide createStudyGuide(StudyGuide studyGuide) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		System.out.println("Before persist: " + studyGuide);
		em.persist(studyGuide);
		System.out.println("After persist: " + studyGuide);
		em.flush();
		em.getTransaction().commit();

		return studyGuide;
	}

	@Override
	public StudyGuide updateStudyGuide(int id, StudyGuide studyGuide) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
		EntityManager em = emf.createEntityManager();

		return studyGuide;

	}

	@Override
	public boolean destoryStudyGuide(int id) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
		EntityManager em = emf.createEntityManager();

		return false;

	}

}
