package com.skilldistillery.interdistillery.data;

import com.skilldistillery.interdistillery.entities.MockInterview;
import com.skilldistillery.interdistillery.entities.User;

public interface MockInterviewDAO {
	public User createMockInterview(MockInterview mockInterview);

	public User updateMockInterview(int id, MockInterview mockInterview);

	public boolean destroyMockInterview(int id);

}
