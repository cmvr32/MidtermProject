package com.skilldistillery.interdistillery.data;

import com.skilldistillery.interdistillery.entities.User;

public interface StudyGuide {
	
	StudyGuide findById(int studyGuideId);
	StudyGuide findByTopic(String Topic);
	StudyGuide findByUserId(int userId);

}
