package com.skilldistillery.interdistillery.data;

import java.util.List;

import com.skilldistillery.interdistillery.entities.Resume;
import com.skilldistillery.interdistillery.entities.User;

public interface ResumeDAO {

	// read
	public Resume findResumeById(int resumeId);

	// read
	// TODO create admin permissions
	public List<Resume> findAllResumes();

	// read
	public Resume findByUserIdAndResumeId(int userId, int resumeId);

	// read
	// find resume joblisting
	public Resume findResumeJobListing(Resume resume);

	// read
	// find resume EducationLevel
	public Resume findResumeEducationLevel(Resume resume);

	// read
	// find resumeJobSkills
	public List<Resume> findResumeJobSkills(Resume resume);

	// create
	// create a new resume
	public Resume createResume(Resume newResume, User user);

	// update
	public Resume updateResume(Resume resume);
//	public Resume updateResume(Integer resumeId, Resume resumeToUpdate, Resume resumeUpdater, String introduction,
//			String contactInfo, String experience);

	// delete
	public Boolean deleteResume(Integer resumeId);

	// TODO ADD RESUME TO USER
	// TODO ADD RESUME TO JOBLISTING

}
