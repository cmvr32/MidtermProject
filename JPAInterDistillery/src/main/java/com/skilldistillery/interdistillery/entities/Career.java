package com.skilldistillery.interdistillery.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Career {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="career_title")
	private String careerTitle;
	@Column(name="image_url")
	private String imageUrl;
	@Column(name="low_salary")
	private double lowSalary;
	@Column(name="high_salary")
	private double highSalary;
	@Column(name="career_category_id")
	private int careerCategoryId;

}
