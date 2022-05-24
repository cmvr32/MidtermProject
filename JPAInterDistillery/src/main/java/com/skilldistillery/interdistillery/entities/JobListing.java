package com.skilldistillery.interdistillery.entities;

import java.time.LocalDateTime;
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
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "job_listing")
public class JobListing {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String title;

	private String description;

	private String requirements;

	private String company;

	@Column(name = "pay_range_min")
	private Double payRangeMin;

	@Column(name = "pay_range_max")
	private Double payRangeMax;

	private String benefits;

	@Column(name = "job_posting_url")
	private String jobPostUrl;

	@CreationTimestamp
	@Column(name = "job_post_date")
	private LocalDateTime jobPostDate;

	@Column(name = "pay_scale_type")
	private String salaryType;

	// many to one JobListing/user
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	// many to one jobListing/resume
	@OneToMany(mappedBy = "jobListing")
	private List<Resume> resumes;

	public void addResume(Resume resume) {

		if (resumes == null) {
			resumes = new ArrayList<>();
		}

		if (!resumes.contains(resume)) {
			resumes.add(resume);
			resume.setJobListing(this);
		}
	}

	public void removeResume(Resume resume) {

		resume.setJobListing(null);
		if (resumes != null && resumes.contains(resume)) {
			resumes.remove(resume);
		}
	}

	public JobListing() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRequirements() {
		return requirements;
	}

	public void setRequirements(String requirements) {
		this.requirements = requirements;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public double getPayRangeMin() {
		return payRangeMin;
	}

	public void setPayRangeMin(double payRangeMin) {
		this.payRangeMin = payRangeMin;
	}

	public double getPayRangeMax() {
		return payRangeMax;
	}

	public void setPayRangeMax(double payRangeMax) {
		this.payRangeMax = payRangeMax;
	}

	public String getBenefits() {
		return benefits;
	}

	public void setBenefits(String benefits) {
		this.benefits = benefits;
	}

	public String getJobPostUrl() {
		return jobPostUrl;
	}

	public void setJobPostUrl(String jobPostUrl) {
		this.jobPostUrl = jobPostUrl;
	}

	public LocalDateTime getJobPostDate() {
		return jobPostDate;
	}

	public void setJobPostDate(LocalDateTime jobPostDate) {
		this.jobPostDate = jobPostDate;
	}

	public String getSalaryType() {
		return salaryType;
	}

	public void setSalaryType(String salaryType) {
		this.salaryType = salaryType;
	}

	public User getUser() {
		return user;
	}

	public void setUserJob(User user) {
		this.user = user;
	}

	public List<Resume> getResumes() {
		return resumes;
	}

	public void setResumes(List<Resume> resumes) {
		this.resumes = resumes;
	}

	@Override
	public String toString() {
		return "JobListing [id=" + id + ", title=" + title + ", description=" + description + ", requirements="
				+ requirements + ", company=" + company + ", payRangeMin=" + payRangeMin + ", payRangeMax="
				+ payRangeMax + ", benefits=" + benefits + ", jobPostUrl=" + jobPostUrl + ", jobPostDate=" + jobPostDate
				+ ", salaryType=" + salaryType + ", user=" + user + "]";
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
		JobListing other = (JobListing) obj;
		return id == other.id;
	}

}
