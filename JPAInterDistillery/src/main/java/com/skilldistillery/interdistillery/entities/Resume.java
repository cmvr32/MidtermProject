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

	private String experience;

	// TODO DOES THIS NEED TO BE A BOOLEAN OR A INT
	@Column(name = "degreed")
	private Integer degree;

	@Column(name = "user_id")
	private Integer userId;

	@Column(name = "job_listing_id")
	private Integer jobListingId;

	@Column(name = "education_level_id")
	private Integer educationLevelId;

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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getJobListingId() {
		return jobListingId;
	}

	public void setJobListingId(Integer jobListingId) {
		this.jobListingId = jobListingId;
	}

	public Integer getEducationLevelId() {
		return educationLevelId;
	}

	public void setEducationLevelId(Integer educationLevelId) {
		this.educationLevelId = educationLevelId;
	}

	@Override
	public String toString() {
		return "Resume [id=" + id + ", contactInfo=" + contactInfo + ", introduction=" + introduction + ", experience="
				+ experience + ", degree=" + degree + ", userId=" + userId + ", jobListingId=" + jobListingId
				+ ", educationLevelId=" + educationLevelId + "]";
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
