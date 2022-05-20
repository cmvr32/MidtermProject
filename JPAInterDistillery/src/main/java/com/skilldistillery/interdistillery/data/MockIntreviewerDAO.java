package com.skilldistillery.interdistillery.data;

import com.skilldistillery.interdistillery.entities.User;

public interface MockIntreviewerDAO {
	public User createMockIntreviewer(MockIntreviewerDAO mockIntreviewer);

	public User updateResume(int id, MockIntreviewerDAO mockIntreviewer);

	public boolean destroyMockIntreviewer(int id);
}
