package com.skilldistillery.interdistillery.data;

import com.skilldistillery.interdistillery.entities.Resume;
import com.skilldistillery.interdistillery.entities.User;

public interface ResumeDAO {
	//read
	Resume findResumeById(int userId);
	
	//read
	Resume findByUserAndResumeID(int userId, int resumeId);
	
	
	//read
	//Resume find by (userId, resumeId, userName);
	Resume findByUserIdResumeIduserName();
	
	//create
	//create a new resume
	public Resume createResume(Resume newResume);

	//update
	public Resume updateResume(Resume resume);
	
	//delete
	public Boolean deleteResume(int id);
	
	
	
}
