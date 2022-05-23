package com.skilldistillery.interdistillery.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Skill {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String description;

	// TODO SKILL
	//ONE TO MANY SKILL/RESUME
	//JOIN TABLE Job_skill
	//COMPOSITE ID jobSKillID
	@OneToMany(mappedBy = "skill")
	private List<JobSkill> jobSkills;

	public void addJobSkill(JobSkill jobSkill) {

		if (jobSkills == null) {
			jobSkills = new ArrayList<>();
		}

		if (!jobSkills.contains(jobSkill)) {
			jobSkills.add(jobSkill);
			jobSkill.setSkill(this);
		}
	}

	public void removeJobSkill(JobSkill jobSkill) {

		jobSkill.setSkill(null);
		if (jobSkills != null && jobSkills.contains(jobSkill)) {
			jobSkills.remove(jobSkill);

		}
	}

	public List<JobSkill> getJobSkills() {
		return jobSkills;
	}

	public void setJobSkills(List<JobSkill> jobSkills) {
		this.jobSkills = jobSkills;
	}

	public Skill() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Skill [id=" + id + ", name=" + name + ", description=" + description + "]";
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
		Skill other = (Skill) obj;
		return id == other.id;
	}

}
