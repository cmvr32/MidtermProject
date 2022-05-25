package com.skilldistillery.interdistillery.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Resume {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "contact_info")
	private String contactInfo;

	private String introduction;

	private String experience;

	// TODO DOES THIS NEED TO BE A BOOLEAN OR A INT
	@Column(name = "degreed")
	private Integer degree;

	public Resume() {
		super();
	}

	public Resume(String contactInfo, String introduction, String experience) {
		super();
		this.contactInfo = contactInfo;
		this.introduction = introduction;
		this.experience = experience;
	}

	public Resume(int id, String contactInfo, String introduction, String experience) {
		super();
		this.id = id;
		this.contactInfo = contactInfo;
		this.introduction = introduction;
		this.experience = experience;
	}

	public Resume(String contactInfo, String introduction, String experience, Integer degree) {
		super();
		this.contactInfo = contactInfo;
		this.introduction = introduction;
		this.experience = experience;
		this.degree = degree;
	}

	public Resume(int id, String contactInfo, String introduction, String experience, Integer degree) {
		super();
		this.id = id;
		this.contactInfo = contactInfo;
		this.introduction = introduction;
		this.experience = experience;
		this.degree = degree;
	}

	public Resume(String contactInfo, String introduction, String experience, Integer degree,
			EducationLevel resumeEducationLevel, List<JobSkill> jobSkills) {
		super();
		this.contactInfo = contactInfo;
		this.introduction = introduction;
		this.experience = experience;
		this.degree = degree;
		this.resumeEducationLevel = resumeEducationLevel;
		this.jobSkills = jobSkills;
	}

	public Resume(int id, String contactInfo, String introduction, String experience, Integer degree,
			EducationLevel resumeEducationLevel, List<JobSkill> jobSkills) {
		super();
		this.id = id;
		this.contactInfo = contactInfo;
		this.introduction = introduction;
		this.experience = experience;
		this.degree = degree;
		this.resumeEducationLevel = resumeEducationLevel;
		this.jobSkills = jobSkills;
	}

	public Resume(String contactInfo, String introduction, String experience, Integer degree, User user) {
		super();
		this.contactInfo = contactInfo;
		this.introduction = introduction;
		this.experience = experience;
		this.degree = degree;
		this.user = user;
	}

	public Resume(int id, String contactInfo, String introduction, String experience, Integer degree, User user) {
		super();
		this.id = id;
		this.contactInfo = contactInfo;
		this.introduction = introduction;
		this.experience = experience;
		this.degree = degree;
		this.user = user;
	}

	public Resume(String contactInfo, String introduction, String experience, Integer degree, User user,
			JobListing jobListing, EducationLevel resumeEducationLevel, List<JobSkill> jobSkills) {
		super();
		this.contactInfo = contactInfo;
		this.introduction = introduction;
		this.experience = experience;
		this.degree = degree;
		this.user = user;
		this.jobListing = jobListing;
		this.resumeEducationLevel = resumeEducationLevel;
		this.jobSkills = jobSkills;
	}

	public Resume(int id, String contactInfo, String introduction, String experience, Integer degree, User user,
			JobListing jobListing, EducationLevel resumeEducationLevel, List<JobSkill> jobSkills) {
		super();
		this.id = id;
		this.contactInfo = contactInfo;
		this.introduction = introduction;
		this.experience = experience;
		this.degree = degree;
		this.user = user;
		this.jobListing = jobListing;
		this.resumeEducationLevel = resumeEducationLevel;
		this.jobSkills = jobSkills;
	}

	// many to one user/resume
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@ManyToOne
	@JoinColumn(name = "job_listing_id")
	private JobListing jobListing;

	public JobListing getJobListing() {
		return jobListing;
	}

	public void setJobListing(JobListing jobListing) {
		this.jobListing = jobListing;
	}

	@ManyToOne
	@JoinColumn(name = "education_level_id")
	private EducationLevel resumeEducationLevel;

	public EducationLevel getResumeEducationLevel() {
		return resumeEducationLevel;
	}

	public void setResumeEducationLevel(EducationLevel resumeEducationLevel) {
		this.resumeEducationLevel = resumeEducationLevel;
	}

	// TODO JOBSKILL-RESUME
	// ONE TO MANY RESUME/JobSkill
	// JOIN TABLE Job_skill
	// COMPOSITE ID jobSKillID
	@OneToMany(mappedBy = "resume")
	private List<JobSkill> jobSkills;

	public void addJobSkill(JobSkill jobSkill) {

		if (jobSkills == null) {
			jobSkills = new ArrayList<>();
		}

		if (!jobSkills.contains(jobSkill)) {
			jobSkills.add(jobSkill);
			jobSkill.setResume(this);
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(String contactInfo) {
		this.contactInfo = contactInfo;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public Integer getDegree() {
		return degree;
	}

	public void setDegree(Integer degree) {
		this.degree = degree;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Resume [id=" + id + ", contactInfo=" + contactInfo + ", introduction=" + introduction + ", experience="
				+ experience + ", degree=" + degree + ", user=" + user + ", resumeEducationLevel="
				+ resumeEducationLevel + "]";
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
		Resume other = (Resume) obj;
		return id == other.id;
	}

}
