package com.skilldistillery.interdistillery.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.skilldistillery.interdistillery.entities.JobSkill;
import com.skilldistillery.interdistillery.entities.CompositeIdJobSkill;
import com.skilldistillery.interdistillery.entities.Resume;
import com.skilldistillery.interdistillery.entities.Skill;

public class SkillDaoImpl implements SkillDAO {

	@Override
	public Skill createSkill(Skill skill) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
		EntityManager em = emf.createEntityManager();

		em.getTransaction().begin();
		System.out.println("Before persist: " + skill);
		em.persist(skill);
		System.out.println("After persist: " + skill);
		em.flush();
		em.getTransaction().commit();

		return skill;
	}

	@Override
	public Skill updateSkill(int id, Skill skill) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
		EntityManager em = emf.createEntityManager();

		return skill;

	}

	@Override
	public boolean destroySkill(int id) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
		EntityManager em = emf.createEntityManager();

		return false;
	}

	@Override
	public boolean skillComposite(int skillId, int resumeId) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
		EntityManager em = emf.createEntityManager();

		boolean resumeSkill = false;
		Resume resume = em.find(Resume.class, resumeId);
		Skill skill = em.find(Skill.class, skillId);
		if (resume != null && skill != null) {
			CompositeIdJobSkill id = new CompositeIdJobSkill(skillId, resumeId);
			JobSkill jobSkill = new JobSkill();
			jobSkill.setId(id);
			jobSkill.setResume(resume);
			jobSkill.setSkill(skill);
			em.persist(jobSkill);
			resumeSkill = true;
		}
		return resumeSkill;
	}

}
