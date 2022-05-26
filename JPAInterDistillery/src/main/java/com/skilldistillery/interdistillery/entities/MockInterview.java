package com.skilldistillery.interdistillery.entities;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
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
	private Integer id;

	@Column(name = "interview_date")
	private Date interviewDate;

	@Column(name = "interview_time")
	private Time interviewTime;

	private String topic;

	// Constructors

	// defualt no arg
	public MockInterview() {
		super();
	}

	// date, time topic
	public MockInterview(Date interviewDate, Time interviewTime, String topic) {
		super();
		this.interviewDate = interviewDate;
		this.interviewTime = interviewTime;
		this.topic = topic;
	}

	public MockInterview(Integer id, Date interviewDate, Time interviewTime, String topic) {
		super();
		this.id = id;
		this.interviewDate = interviewDate;
		this.interviewTime = interviewTime;
		this.topic = topic;
	}

	// date, time, topic, and interviewee
	public MockInterview(Date interviewDate, Time interviewTime, String topic, User interviewee) {
		super();
		this.interviewDate = interviewDate;
		this.interviewTime = interviewTime;
		this.topic = topic;
		this.interviewee = interviewee;
	}

	public MockInterview(int id, Date interviewDate, Time interviewTime, String topic, User interviewee) {
		super();
		this.id = id;
		this.interviewDate = interviewDate;
		this.interviewTime = interviewTime;
		this.topic = topic;
		this.interviewee = interviewee;
	}

	public List<User> getUserInterviews() {
		return userInterviews;
	}

	public void setUserInterviews(List<User> userInterviews) {
		this.userInterviews = userInterviews;
	}

	public User getInterviewee() {
		return interviewee;
	}

	public void setInterviewee(User interviewee) {
		this.interviewee = interviewee;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(Date interviewDate) {
		this.interviewDate = interviewDate;
	}

	public Time getInterviewTime() {
		return interviewTime;
	}

	public void setInterviewTime(Time interviewTime) {
		this.interviewTime = interviewTime;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

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

	@Override
	public int hashCode() {
		return Objects.hash(id);
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
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "MockInterview [id=" + id + ", interviewDate=" + interviewDate + ", interviewTime=" + interviewTime
				+ ", topic=" + topic + ", interviewee=" + interviewee + "]";
	}

	// -----------------------------------------------------------------------

}
