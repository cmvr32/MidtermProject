package com.skilldistillery.interdistillery.entities;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//TODO JOBSKILL ID CLASS
@Embeddable
public class CompositeIdJobSkill implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = ":skill_id")
	private Integer skillId;

	@Column(name = "resume_id")
	private Integer resumeId;

	public CompositeIdJobSkill() {
		super();
	}

	public CompositeIdJobSkill(Integer resumeId, Integer skillId) {
		super();

		this.resumeId = resumeId;
		this.skillId = skillId;
	}

	public boolean resumeJobSkill(int resumeId, int skillId) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("");
		EntityManager em = emf.createEntityManager();

		boolean invited = false;
		Resume resume = em.find(Resume.class, resumeId);
		Skill skill = em.find(Skill.class, skillId);
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

	public Integer getSkillId() {
		return skillId;
	}

	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}

	public Integer getResumeId() {
		return resumeId;
	}

	public void setResumeId(Integer resumeId) {
		this.resumeId = resumeId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "JobSkillId [skillId=" + skillId + ", resumeId=" + resumeId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(resumeId, skillId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CompositeIdJobSkill other = (CompositeIdJobSkill) obj;
		return Objects.equals(resumeId, other.resumeId) && Objects.equals(skillId, other.skillId);
	}

}
