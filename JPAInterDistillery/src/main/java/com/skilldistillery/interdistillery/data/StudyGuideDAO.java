package com.skilldistillery.interdistillery.data;

import com.skilldistillery.interdistillery.entities.StudyGuide;

public interface StudyGuideDAO {

	StudyGuide createStudyGuide(StudyGuide studyGuide);

	public StudyGuide updateStudyGuide(int id, StudyGuide studyGuide);

	public boolean destoryStudyGuide(int id);

}
