package com.skilldistillery.interdistillery.data;

import com.skilldistillery.interdistillery.entities.CareerCategory;

public interface CareerCategoryDAO {

	CareerCategory createCareerCategory(CareerCategory careerCategory);
	
	public CareerCategory updateCareerCategory (int id, CareerCategory careerCategory);
	
	public boolean destoryCareerCategry(int id);
	
}
