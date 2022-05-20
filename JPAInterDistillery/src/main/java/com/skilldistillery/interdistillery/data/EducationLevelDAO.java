package com.skilldistillery.interdistillery.data;

import com.skilldistillery.interdistillery.entities.EducationLevel;

public interface EducationLevelDAO {

	EducationLevel createEducationLevel(EducationLevel educationLevel);
	
	public EducationLevel updateEducationLevel(int id, EducationLevel educationLevel);
	
	public boolean destroyEducationLevel(int id);
}
