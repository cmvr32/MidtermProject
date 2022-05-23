package com.skilldistillery.interdistillery.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.interdistillery.entities.Resume;
import com.skilldistillery.interdistillery.entities.StudyGuide;

public class StudyGuideClient {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("InterDistillery");

		EntityManager em = emf.createEntityManager();

		StudyGuide studyGuide = em.find(StudyGuide.class, 1);
		System.out.println(studyGuide);

		em.close();
		emf.close();

	}
}
