package com.skilldistillery.interdistillery.entities;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MockInterviewer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mock_interview_id")
	private int mockInterviewId;

	@Column(name = "user_id")
	private int userId;

	public int getMockInterviewId() {
		return mockInterviewId;
	}

	public void setMockInterviewId(int mockInterviewId) {
		this.mockInterviewId = mockInterviewId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "MockInterviewer [mockInterviewId=" + mockInterviewId + ", userId=" + userId + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(mockInterviewId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MockInterviewer other = (MockInterviewer) obj;
		return mockInterviewId == other.mockInterviewId;
	}

}
