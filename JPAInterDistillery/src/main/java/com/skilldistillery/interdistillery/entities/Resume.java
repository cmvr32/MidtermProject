package com.skilldistillery.interdistillery.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Resume {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "contact_info")
	private String contactInfo;

	private String introduction;

	private String experinece;

	@Column(name = "degreed")
	private int degree;

	@Column(name = "user_id")
	private int UserId;

	@Column(name = "job_listing_id")
	private int jobListing;

	@Column(name = "education_level_id")
	private int educationLevel;

	public Resume() {
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

	public String getExperinece() {
		return experinece;
	}

	public void setExperinece(String experinece) {
		this.experinece = experinece;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public int getJobListing() {
		return jobListing;
	}

	public void setJobListing(int jobListing) {
		this.jobListing = jobListing;
	}

	public int getEducationLevel() {
		return educationLevel;
	}

	public void setEducationLevel(int educationLevel) {
		this.educationLevel = educationLevel;
	}

	@Override
	public String toString() {
		return "Resume [id=" + id + ", contactInfo=" + contactInfo + ", introduction=" + introduction + ", experinece="
				+ experinece + ", degree=" + degree + ", UserId=" + UserId + ", jobListing=" + jobListing
				+ ", educationLevel=" + educationLevel + "]";
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
