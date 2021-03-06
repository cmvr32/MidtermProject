package com.skilldistillery.interdistillery.entities;

import java.util.ArrayList;
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


	public void addCareer(Career career) {

		if (careers == null) {
			careers = new ArrayList<>();
		}

		if (!careers.contains(career)) {
			careers.add(career);
			career.setCareerCategory(this);
		}
	}

	public void removeCareer(Career career) {

		if (careers != null && careers.contains(career)) {
			careers.remove(career);
		}
	}

	public List<Career> getCareers() {
		return careers;
	}

	public void setCareers(List<Career> careers) {
		this.careers = careers;
	}

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
