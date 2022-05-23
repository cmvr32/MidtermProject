package com.skilldistillery.interdistillery.data;

import com.skilldistillery.interdistillery.entities.Resume;
import com.skilldistillery.interdistillery.entities.User;

public interface ResumeDAO {
	public User createResume(Resume resume);

	public User updateResume(int id, Resume resume);

	public boolean destroyResume(int id);

	boolean skillComposite(int skillId, int resumeId);
}
