package com.skilldistillery.interdistillery.data;

import com.skilldistillery.interdistillery.entities.User;

public interface MockInterviewerDAO {
	public User createMockIntreviewer(MockInterviewerDAO mockIntreviewer);

	public User updateResume(int id, MockInterviewerDAO mockIntreviewer);

	public boolean destroyMockIntreviewer(int id);
}
