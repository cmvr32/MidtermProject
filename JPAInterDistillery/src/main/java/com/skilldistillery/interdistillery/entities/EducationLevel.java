package com.skilldistillery.interdistillery.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "education_level")
public class EducationLevel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "education_level")
	private String educationLevel;

	private String description;

	public EducationLevel() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(String educationLevel) {
		this.educationLevel = educationLevel;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// ------------------------------------------------------------------------------------
	// one to many user/resume
	@OneToMany(mappedBy = "resumeEducationLevel")
	private List<Resume> resumes;

	public void addResume(Resume resume) {

		if (resumes == null) {
			resumes = new ArrayList<>();
		}

		if (!resumes.contains(resume)) {
			resumes.add(resume);
			resume.setResumeEducationLevel(this);
		}
	}

	public void removeResume(Resume resume) {
		
		resume.setUser(null);
		if (resumes != null && resumes.contains(resume)) {
			resumes.remove(resume);

		}
	}

	public List<Resume> getResumes() {
		return resumes;
	}

	public void setResumes(List<Resume> resumes) {
		this.resumes = resumes;
	}

	@Override
	public String toString() {
		return "EducationLevel [id=" + id + ", educationLevel=" + educationLevel + ", description=" + description + "]";
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
		EducationLevel other = (EducationLevel) obj;
		return id == other.id;
	}

}
