package com.skilldistillery.interdistillery.entities;

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
@Table(name = "study_guide")
public class StudyGuide {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String topic;

	@Column(name = "learning_objectives")
	private String learningObjectives;

	private String content;

	private String review;

	@Column(name = "resource_url")
	private String resrourceUrl;

	@Column(name = "image_url")
	private String imageUrl;

	// --------------------------------------------------------------------------------
	// many to many user/mock interviewer
	// join table mock_interviewer
	@ManyToMany(mappedBy = "userStudyGuides")
	private List<User> usersWithStudyGuides;

	public void addUsersWithStudyGuides(User userWithStudyGuide) {

		if (usersWithStudyGuides == null) {
			usersWithStudyGuides = new ArrayList<>();
		}

		if (!usersWithStudyGuides.contains(userWithStudyGuide)) {
			usersWithStudyGuides.add(userWithStudyGuide);
			userWithStudyGuide.addUserStudyGuides(this);
		}
	}

	public void removeUsersWithStudyGuides(User userWithStudyGuide) {

		if (usersWithStudyGuides != null && usersWithStudyGuides.contains(userWithStudyGuide)) {
			usersWithStudyGuides.remove(userWithStudyGuide);
			userWithStudyGuide.removeUserStudyGuides(this);
		}
	}

	public List<User> getUsersWithStudyGuides() {
		return usersWithStudyGuides;
	}

	public void setUsersWithStudyGuides(List<User> usersWithStudyGuides) {
		this.usersWithStudyGuides = usersWithStudyGuides;
	}

	// --------------------------------------------------------------------------------------

	// many to one studyguide/user
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	// many to one studyguide/career
	@ManyToOne
	@JoinColumn(name = "career_id")
	private Career career;

	public Career getCareer() {
		return career;
	}

	public void setCareer(Career career) {
		this.career = career;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getLearningObjectives() {
		return learningObjectives;
	}

	public void setLearningObjectives(String learningObjectives) {
		this.learningObjectives = learningObjectives;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getResrourceUrl() {
		return resrourceUrl;
	}

	public void setResrourceUrl(String resrourceUrl) {
		this.resrourceUrl = resrourceUrl;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "StudyGuide [id=" + id + ", topic=" + topic + ", learningObjectives=" + learningObjectives + ", content="
				+ content + ", review=" + review + ", resrourceUrl=" + resrourceUrl + ", imageUrl=" + imageUrl + "]";
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
		StudyGuide other = (StudyGuide) obj;
		return id == other.id;
	}

}
