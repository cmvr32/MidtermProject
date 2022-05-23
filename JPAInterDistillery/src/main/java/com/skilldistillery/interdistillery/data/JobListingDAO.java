package com.skilldistillery.interdistillery.data;

import com.skilldistillery.interdistillery.entities.User;

public interface JobListingDAO {
	
	public User createJobSkill(JobListingDAO jobSkill);

	public User updateJobSkill(int id, JobListingDAO jobSkill);

	public boolean destroyJobSkill(int id);

}
