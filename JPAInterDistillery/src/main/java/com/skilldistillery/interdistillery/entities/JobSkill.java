package com.skilldistillery.interdistillery.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Persistence;
import javax.persistence.Table;

@Entity
@Table(name = "job_skill")
public class JobSkill {

	@EmbeddedId
	private CompositeIdJobSkill id;

	@Column(name = "years_experience")
	private int yearsExperience;

	@ManyToOne
	@JoinColumn(name = "resume_id") // DB column name
	@MapsId(value = "resumeId") // Field in ID class
	private Resume resume;

	@ManyToOne
	@JoinColumn(name = "skill_id") // DB column
	@MapsId(value = "skillId") // Field in ID class
	private Skill skill;

	public JobSkill() {
		super();
	}

	public JobSkill(Resume resume, Skill skill) {
		super();
		this.resume = resume;
		this.skill = skill;
	}

	public JobSkill(CompositeIdJobSkill id, Resume resume, Skill skill) {
		super();
		this.id = id;
		this.resume = resume;
		this.skill = skill;
	}

	public JobSkill(CompositeIdJobSkill id, int yearsExperience, Resume resume, Skill skill) {
		super();
		this.id = id;
		this.yearsExperience = yearsExperience;
		this.resume = resume;
		this.skill = skill;
	}

	public CompositeIdJobSkill getId() {
		return id;
	}

	public void setId(CompositeIdJobSkill id) {
		this.id = id;
	}

//	public int getYearsExperience() {
//		return yearsExperience;
//	}
//
//	public void setYearsExperience(int yearsExperience) {
//		this.yearsExperience = yearsExperience;
//	}

	public Resume getResume() {
		return resume;
	}

	public void setResume(Resume resume) {
		this.resume = resume;
	}

	public Skill getSkill() {
		return skill;
	}

	public void setSkill(Skill skill) {
		this.skill = skill;
	}

	public boolean resumeHasJobSkill(int resumeId, int skillId) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
		EntityManager em = emf.createEntityManager();

		boolean invited = false;
		Skill skill = em.find(Skill.class, skillId);
		Resume resume = em.find(Resume.class, resumeId);
		if (skill != null && resume != null) {
			CompositeIdJobSkill id = new CompositeIdJobSkill(resumeId, skillId);
			JobSkill jobSkill = new JobSkill();
			jobSkill.setId(id);
			jobSkill.setSkill(skill);
			jobSkill.setResume(resume);
			em.persist(jobSkill);
			invited = true;
		}
		return invited;
	}

	@Override
	public String toString() {
		return "JobSkill [id=" + id + ", resume=" + resume + ", skill=" + skill + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobSkill other = (JobSkill) obj;
		return Objects.equals(id, other.id);
	}

}
