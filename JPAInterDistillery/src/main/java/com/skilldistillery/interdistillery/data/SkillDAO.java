package com.skilldistillery.interdistillery.data;

import com.skilldistillery.interdistillery.entities.Skill;

public interface SkillDAO {

	Skill createSkill(Skill skill);
	
	public Skill updateSkill(int id, Skill skill);
	
	public boolean destroySkill (int id);

	boolean skillComposite(int skillId, int resumeId);
	
}
