package com.skilldistillery.interdistillery.data;

import com.skilldistillery.interdistillery.entities.User;

public interface JobSkillDAO {
	public User createJobSkill(JobSkillDAO jobSkill);

	public User updateJobSkill(int id, JobSkillDAO jobSkill);

	public boolean destroyJobSkill(int id);

}
