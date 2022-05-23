package com.skilldistillery.interdistillery.data;

import com.skilldistillery.interdistillery.entities.MockInterview;

public interface MockInterviewDAO {
	
	MockInterview findById(int userId);
	MockInterview findByUserIdAndMockInterviewId(int userId, int mockInterviewId);

}
