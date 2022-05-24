package com.skilldistillery.interdistillery.data;

import java.util.List;

import com.skilldistillery.interdistillery.entities.MockInterview;
import com.skilldistillery.interdistillery.entities.User;

public interface MockInterviewDAO {
	
	public MockInterview findByInterviewId(User user);
	
	public List<MockInterview> listAllInterviews();
	
	public MockInterview findByMockIntervieweeId(int intervieweeId);
	
	public List<MockInterview> findByUserIdAndMockInterviewId(int userId, int mockInterviewId);
	
	public MockInterview createInterview(MockInterview mockInterview);

	public boolean deleteInterview(int interviewId);

	
	
	

}
