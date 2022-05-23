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
<<<<<<< HEAD
<<<<<<< HEAD
import javax.persistence.OneToMany;
=======
>>>>>>> 1753deed26fd0fde178860a66dbea5dcd2fbe9a8
=======
>>>>>>> 3c11bbdbfa6e5b2b71d99e807504f397e77bc126

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
<<<<<<< HEAD

<<<<<<< HEAD
	// ------------------------------------------------------------------------------------
=======
	@ManyToOne
	@JoinColumn(name = "career_category_id")
	private CareerCategory careerCategory;

>>>>>>> 3c11bbdbfa6e5b2b71d99e807504f397e77bc126
	// one to many career/studyguide
	@OneToMany(mappedBy = "career")
	private List<StudyGuide> careerStudyGuides;

	public void addCareerStudyGuides(StudyGuide studyguide) {

		if (careerStudyGuides == null) {
			careerStudyGuides = new ArrayList<>();
		}

		if (!careerStudyGuides.contains(studyguide)) {
			careerStudyGuides.add(studyguide);
			studyguide.setCareer(this);
		}
	}

	public void removeCareerStudyGuides(StudyGuide studyguide) {

		if (careerStudyGuides != null && careerStudyGuides.contains(studyguide)) {
			careerStudyGuides.remove(studyguide);

		}
	}

	public List<StudyGuide> getCareerStudyGuides() {
		return careerStudyGuides;
	}

	public void setCareerStudyGuides(List<StudyGuide> careerStudyGuides) {
		this.careerStudyGuides = careerStudyGuides;
	}

	// many to one career/career_category
		@ManyToOne
		@JoinColumn(name = "career_category_id")
		private CareerCategory careerCatergory;

	
	public CareerCategory getCareerCatergory() {
			return careerCatergory;
		}

		public void setCareerCatergory(CareerCategory careerCatergory) {
			this.careerCatergory = careerCatergory;
		}
<<<<<<< HEAD
=======
	@ManyToOne
	@JoinColumn(name = "career_category_id")
	private CareerCategory careerCategory;

	// TODO: one to many study guide/ career id
//	@OneToMany(mappedBy = "career")
//	private List<StudyGuide> studyGuides;
//
//	@OneToMany(mappedBy = "career")
//	private List<Project> projects;
>>>>>>> 1753deed26fd0fde178860a66dbea5dcd2fbe9a8
=======
>>>>>>> 3c11bbdbfa6e5b2b71d99e807504f397e77bc126

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

<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> 3c11bbdbfa6e5b2b71d99e807504f397e77bc126
	public CareerCategory getCareerCategory() {
		return careerCategory;
	}

	public void setCareerCategory(CareerCategory careerCategory) {
		this.careerCategory = careerCategory;
	}
<<<<<<< HEAD
>>>>>>> 1753deed26fd0fde178860a66dbea5dcd2fbe9a8
=======

>>>>>>> 3c11bbdbfa6e5b2b71d99e807504f397e77bc126

	@Override
	public String toString() {
		return "Career [id=" + id + ", careerTitle=" + careerTitle + ", imageUrl=" + imageUrl + ", lowSalary="
<<<<<<< HEAD
<<<<<<< HEAD
				+ lowSalary + ", highSalary=" + highSalary + "]";
=======
				+ lowSalary + ", highSalary=" + highSalary + ", careerCategory=" + careerCategory + "]";
>>>>>>> 1753deed26fd0fde178860a66dbea5dcd2fbe9a8
=======
				+ lowSalary + ", highSalary=" + highSalary + ", careerCategory=" + careerCategory + "]";
>>>>>>> 3c11bbdbfa6e5b2b71d99e807504f397e77bc126
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
