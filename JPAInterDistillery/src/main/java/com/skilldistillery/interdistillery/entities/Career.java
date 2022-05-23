package com.skilldistillery.interdistillery.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Career {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "career_title")
	private String careerTitle;

	@Column(name = "image_url")
	private String imageUrl;

	@Column(name = "low_salary")
	private double lowSalary;

	@Column(name = "high_salary")
	private double highSalary;

	@ManyToOne
	@JoinColumn(name = "career_category_id")
	private CareerCategory careerCategory;

	// TODO: one to many study guide/ career id
//	@OneToMany(mappedBy = "career")
//	private List<StudyGuide> studyGuides;
//
//	@OneToMany(mappedBy = "career")
//	private List<Project> projects;

	public Career() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCareerTitle() {
		return careerTitle;
	}

	public void setCareerTitle(String careerTitle) {
		this.careerTitle = careerTitle;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public double getLowSalary() {
		return lowSalary;
	}

	public void setLowSalary(double lowSalary) {
		this.lowSalary = lowSalary;
	}

	public double getHighSalary() {
		return highSalary;
	}

	public void setHighSalary(double highSalary) {
		this.highSalary = highSalary;
	}

	public CareerCategory getCareerCategory() {
		return careerCategory;
	}

	public void setCareerCategory(CareerCategory careerCategory) {
		this.careerCategory = careerCategory;
	}

	@Override
	public String toString() {
		return "Career [id=" + id + ", careerTitle=" + careerTitle + ", imageUrl=" + imageUrl + ", lowSalary="
				+ lowSalary + ", highSalary=" + highSalary + ", careerCategory=" + careerCategory + "]";
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
		Career other = (Career) obj;
		return id == other.id;
	}

}
