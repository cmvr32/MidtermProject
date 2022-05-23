package com.skilldistillery.interdistillery.data;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.interdistillery.entities.Resume;

public interface ResumeDAO {
	
	// read
	Resume findResumeById(int userId);

	// read
	// TODO create admin permissions
	public List<Resume> findAllResumes();
	
	// read
	public Resume findByUserIdAndResumeId(int userId, int resumeId);
	
	//read
	//find resume joblisting
	public Resume findResumeJobListing(Resume resume);
	
	//read
	//find resume EducationLevel
	public Resume findResumeEducationLevel(Resume resume);
	
	//read
	//find resumeJobSkills
	public List<Resume> findResumeJobSkills(Resume resume);
	
	
	// create
	// create a new resume
	public Resume createResume(Resume newResume);

	// update
	public Resume updateResume(Resume updateResume);

	// delete
	public Boolean deleteResume(int resumeId);
	
	//TODO ADD RESUME TO USER
	//TODO ADD RESUME TO JOBLISTING
	
}
