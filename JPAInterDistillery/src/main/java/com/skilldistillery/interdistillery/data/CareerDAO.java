package com.skilldistillery.interdistillery.data;

import com.skilldistillery.interdistillery.entities.Career;

public interface CareerDAO {

	Career createCareer(Career career);
	
	public Career updateCareer (int id, Career career);
	
	public boolean destoryCareerCategry(int id);
	
}
