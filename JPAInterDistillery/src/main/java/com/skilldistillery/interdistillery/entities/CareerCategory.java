package com.skilldistillery.interdistillery.entities;

<<<<<<< HEAD
<<<<<<< HEAD
import java.util.ArrayList;
=======
>>>>>>> 1753deed26fd0fde178860a66dbea5dcd2fbe9a8
=======
>>>>>>> 3c11bbdbfa6e5b2b71d99e807504f397e77bc126
import java.util.List;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "career_category")
public class CareerCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;

	private String description;

	@OneToMany(mappedBy = "careerCategory")
	private List<Career> careers;

	public CareerCategory() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

<<<<<<< HEAD
<<<<<<< HEAD
	// -------------------------------------------------------------------
	// one to many career_category/career
=======
>>>>>>> 3c11bbdbfa6e5b2b71d99e807504f397e77bc126
	@OneToMany(mappedBy = "careerCatergory")
	private List<Career> careers;

	public void addCareer(Career career) {

		if (careers == null) {
			careers = new ArrayList<>();
		}

		if (!careers.contains(career)) {
			careers.add(career);
			career.setCareerCatergory(this);
		}
	}

	public void removeCareer(Career career) {

		if (careers != null && careers.contains(career)) {
			careers.remove(career);
		}
	}

<<<<<<< HEAD
=======
>>>>>>> 1753deed26fd0fde178860a66dbea5dcd2fbe9a8
=======
>>>>>>> 3c11bbdbfa6e5b2b71d99e807504f397e77bc126
	public List<Career> getCareers() {
		return careers;
	}

	public void setCareers(List<Career> careers) {
		this.careers = careers;
	}

<<<<<<< HEAD
<<<<<<< HEAD
//-------------------------------------------------------------------------------
=======
>>>>>>> 1753deed26fd0fde178860a66dbea5dcd2fbe9a8
=======
>>>>>>> 3c11bbdbfa6e5b2b71d99e807504f397e77bc126
	@Override
	public String toString() {
		return "CareerCategory [id=" + id + ", name=" + name + ", description=" + description + ", careers=" + careers
				+ "]";
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
		CareerCategory other = (CareerCategory) obj;
		return id == other.id;
	}

}
