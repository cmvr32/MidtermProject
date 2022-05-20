package com.skilldistillery.interdistillery.client;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.interdistillery.entities.Skill;

public class SkillClient {

	public static void main(String[] args) {
		EntityManagerFactory emf = 
				Persistence.createEntityManagerFactory("InterDistillery");
		EntityManager em = emf.createEntityManager();
		
		Skill skill = em.find(Skill.class, 1);
		System.out.println(skill);
		
		em.close();
		emf.close();

	}

}
