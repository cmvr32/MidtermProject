package com.skilldistillery.interdistillery.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mock_interview")
public class MockInterview {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "interview_date")
	private LocalDateTime interviewDate;

	@Column(name = "interview_time")
	private LocalDateTime interviewTime;

	private String topic;

//	@Column(name = "interviewee_id")
//	private int intervieweeId;

	// ----------------------------------------------------------------------
	// one to many user/mock interviewer
	@ManyToOne
	@JoinColumn(name = "interviewee_id")
	private User interviewee;

	// -----------------------------------------------------------------------
	// many to many user/mock interviewer
	// join table mock_interviewer

	@ManyToMany(mappedBy = "mockInterviewAppointments")
	private List<User> userInterviews;

	public List<User> getUserInterviews() {
		return userInterviews;
	}

	public void setUserInterviews(List<User> userInterviews) {
		this.userInterviews = userInterviews;
	}

	public void addUserInterview(User userInterview) {
		if (userInterviews == null) {
			userInterviews = new ArrayList<>();
		}
		if (!userInterviews.contains(userInterview)) {
			userInterviews.add(userInterview);
			userInterview.addMockInterviewAppointments(this);
		}
	}

	public void removeUserInterview(User userInterview) {
		if (userInterviews != null && userInterviews.contains(userInterview)) {
			userInterviews.remove(userInterview);
			userInterview.removeMockInterviewAppointments(this);
		}
	}

	public User getInterviewee() {
		return interviewee;
	}

	public void setInterviewee(User interviewee) {
		this.interviewee = interviewee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(LocalDateTime interviewDate) {
		this.interviewDate = interviewDate;
	}

	public LocalDateTime getInterviewTime() {
		return interviewTime;
	}

	public void setInterviewTime(LocalDateTime interviewTime) {
		this.interviewTime = interviewTime;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

//	public int getIntervieweeId() {
//		return intervieweeId;
//	}
//
//	public void setIntervieweeId(int intervieweeId) {
//		this.intervieweeId = intervieweeId;
//	}



	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public String toString() {
		return "MockInterview [id=" + id + ", interviewDate=" + interviewDate + ", interviewTime=" + interviewTime
				+ ", topic=" + topic + ", interviewee=" + interviewee + "]";
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MockInterview other = (MockInterview) obj;
		return id == other.id;
	}

}
