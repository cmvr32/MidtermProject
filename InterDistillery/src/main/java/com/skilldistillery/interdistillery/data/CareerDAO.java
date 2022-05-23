package com.skilldistillery.interdistillery.data;

import com.skilldistillery.interdistillery.entities.Career;

public interface CareerDAO {
	
	Career findById(int careerId);
	Career findByCarrerTitle(String CareerTitle);
	
	
}
