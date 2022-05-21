package com.skilldistillery.interdistillery.entities;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

	@Column(name = "interviewee_id")
	private int intervieweeId;

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

	public int getIntervieweeId() {
		return intervieweeId;
	}

	public void setIntervieweeId(int intervieweeId) {
		this.intervieweeId = intervieweeId;
	}

	@Override
	public String toString() {
		return "MockInterview [id=" + id + ", interviewDate=" + interviewDate + ", interviewTime=" + interviewTime
				+ ", topic=" + topic + ", intervieweeId=" + intervieweeId + "]";
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
		return id == other.id;
	}

}
