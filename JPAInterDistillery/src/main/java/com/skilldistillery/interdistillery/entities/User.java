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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	private String email;

	@Column(name="username")
	private String userName;

	private String password;

	@Column(name = "date_created")
	private LocalDateTime dateCreated;

	private Integer active;

	private String role;

	@Column(name = "profile_image_url")
	private String profileImageUrl;

	@Column(name = "banner_image_url")
	private String bannerImageUrl;

	private String biography;

	// default no arg constructor
	public User() {
		super();
	}

	// create new user constructor
	public User(String firstName, String lastName, String email, String userName, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.password = password;
	}
	

	public User(String firstName, String lastName, String email, String userName, String password, String role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}

	// eventually this will be the new user contructor
	// have to figure out time created and role
	public User(String firstName, String lastName, String email, String userName, String password,
			LocalDateTime dateCreated, String role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.dateCreated = dateCreated;
		this.role = role;
	}

	// all arg no id contructor
	public User(String firstName, String lastName, String email, String userName, String password,
			LocalDateTime dateCreated, Integer active, String role, String profileImageUrl, String bannerImageUrl,
			String biography, List<MockInterview> userMockInterviews, List<MockInterview> mockInterviewAppointments,
			List<Resume> userResumes, List<StudyGuide> userStudyGuides, List<StudyGuide> studyguides,
			List<JobListing> jobListings) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.dateCreated = dateCreated;
		this.active = active;
		this.role = role;
		this.profileImageUrl = profileImageUrl;
		this.bannerImageUrl = bannerImageUrl;
		this.biography = biography;
		this.userMockInterviews = userMockInterviews;
		this.mockInterviewAppointments = mockInterviewAppointments;
		this.userResumes = userResumes;
		this.userStudyGuides = userStudyGuides;
		this.studyGuidesThatThisUserHas = studyguides;
		this.jobListings = jobListings;
	}

	// all arg contructor
	public User(int id, String firstName, String lastName, String email, String userName, String password,
			LocalDateTime dateCreated, Integer active, String role, String profileImageUrl, String bannerImageUrl,
			String biography, List<MockInterview> userMockInterviews, List<MockInterview> mockInterviewAppointments,
			List<Resume> userResumes, List<StudyGuide> userStudyGuides, List<StudyGuide> studyguides,
			List<JobListing> jobListings) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.dateCreated = dateCreated;
		this.active = active;
		this.role = role;
		this.profileImageUrl = profileImageUrl;
		this.bannerImageUrl = bannerImageUrl;
		this.biography = biography;
		this.userMockInterviews = userMockInterviews;
		this.mockInterviewAppointments = mockInterviewAppointments;
		this.userResumes = userResumes;
		this.userStudyGuides = userStudyGuides;
		this.studyGuidesThatThisUserHas = studyguides;
		this.jobListings = jobListings;
	}

	// GETTERS AND SETTERS
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	public String getBannerImageUrl() {
		return bannerImageUrl;
	}

	public void setBannerImageUrl(String bannerImageUrl) {
		this.bannerImageUrl = bannerImageUrl;
	}

	public String getBiography() {
		return biography;
	}

	public void setBiography(String biography) {
		this.biography = biography;
	}

	public List<MockInterview> getUserMockInterviews() {
		return userMockInterviews;
	}

	public void setUserMockInterviews(List<MockInterview> userMockInterviews) {
		this.userMockInterviews = userMockInterviews;
	}

	public List<MockInterview> getMockInterviewAppointments() {
		return mockInterviewAppointments;
	}

	public void setMockInterviewAppointments(List<MockInterview> mockInterviewAppointments) {
		this.mockInterviewAppointments = mockInterviewAppointments;
	}

	public List<Resume> getUserResumes() {
		return userResumes;
	}

	public void setUserResumes(List<Resume> userResumes) {
		this.userResumes = userResumes;
	}

	public List<StudyGuide> getUserStudyGuides() {
		return userStudyGuides;
	}

	public void setUserStudyGuides(List<StudyGuide> userStudyGuides) {
		this.userStudyGuides = userStudyGuides;
	}

	public List<StudyGuide> getStudyGuidesThatThisUserHas() {
		return studyGuidesThatThisUserHas;
	}

	public void setStudyGuidesThatThisUserHas(List<StudyGuide> studyGuidesThatThisUserHas) {
		this.studyGuidesThatThisUserHas = studyGuidesThatThisUserHas;
	}

	public List<JobListing> getJobListings() {
		return jobListings;
	}

	public void setJobListings(List<JobListing> jobListings) {
		this.jobListings = jobListings;
	}

	// ENTITY RELATIONSHIP MAPPINGS AND ADD/REMOVE METHODS
	// ------------------------------------------------------------------------------------
	// one to many user/mock interview
	@OneToMany(mappedBy = "interviewee")
	private List<MockInterview> userMockInterviews;

	public void addMockInterview(MockInterview mockInterview) {

		if (userMockInterviews == null) {
			userMockInterviews = new ArrayList<>();
		}

		if (!userMockInterviews.contains(mockInterview)) {
			userMockInterviews.add(mockInterview);
			mockInterview.setInterviewee(this);
		}
	}

	public void removeMockInterview(MockInterview mockInterview) {

		mockInterview.setInterviewee(null);
		if (userMockInterviews != null && userMockInterviews.contains(mockInterview)) {
			userMockInterviews.remove(mockInterview);

		}
	}

	// ----------------------------------------------------------------------------------
	// many to many user to mock_interview
	// join table mock_interviewer
	@ManyToMany
	@JoinTable(name = "mock_interviewer", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "mock_interview_id"))
	private List<MockInterview> mockInterviewAppointments;

	public void addMockInterviewAppointments(MockInterview mockInterviewAppointment) {

		if (mockInterviewAppointments == null) {
			mockInterviewAppointments = new ArrayList<>();
		}

		if (!mockInterviewAppointments.contains(mockInterviewAppointment)) {
			mockInterviewAppointments.add(mockInterviewAppointment);
			mockInterviewAppointment.addUserInterview(this);
		}
	}

	public void removeMockInterviewAppointments(MockInterview mockInterviewAppointment) {

		if (mockInterviewAppointments != null && mockInterviewAppointments.contains(mockInterviewAppointment)) {
			mockInterviewAppointments.remove(mockInterviewAppointment);
			mockInterviewAppointment.removeUserInterview(this);
		}
	}

	// ------------------------------------------------------------------------------------
	// one to many user/resume
	@OneToMany(mappedBy = "user")
	private List<Resume> userResumes;

	public void addResume(Resume resume) {

		if (userResumes == null) {
			userResumes = new ArrayList<>();
		}

		if (!userResumes.contains(resume)) {
			userResumes.add(resume);
			resume.setUser(this);
		}
	}

	public void removeResume(Resume resume) {

		resume.setUser(null);
		if (userResumes != null && userResumes.contains(resume)) {
			userResumes.remove(resume);

		}
	}

	// ----------------------------------------------------------------------------------
	// many to many user to studyguide
	// join table user_has_study_guide
	@ManyToMany
	@JoinTable(name = "user_has_study_guide", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "study_guide_id"))
	private List<StudyGuide> userStudyGuides;

	public void addUserStudyGuides(StudyGuide userStudyGuide) {

		if (userStudyGuides == null) {
			userStudyGuides = new ArrayList<>();
			if (!userStudyGuides.contains(userStudyGuide)) {
				userStudyGuides.add(userStudyGuide);
				userStudyGuide.addUsersWithStudyGuides(this);
			}
		}
	}

	public void removeUserStudyGuides(StudyGuide userStudyGuide) {

		if (userStudyGuides != null && userStudyGuides.contains(userStudyGuide)) {
			userStudyGuides.remove(userStudyGuide);
			userStudyGuide.removeUsersWithStudyGuides(this);
		}
	}

	// ------------------------------------------------------------------------------------

	// one to many user/studyguide
	@OneToMany(mappedBy = "user")
	private List<StudyGuide> studyGuidesThatThisUserHas;

	public void addStudyGuide(StudyGuide studyguide) {

		if (studyGuidesThatThisUserHas == null) {
			studyGuidesThatThisUserHas = new ArrayList<>();
		}

		if (!studyGuidesThatThisUserHas.contains(studyguide)) {
			studyGuidesThatThisUserHas.add(studyguide);
			studyguide.setUser(this);
		}
	}

	public void removeStudyGuide(StudyGuide studyguide) {

		studyguide.setUser(null);
		if (studyGuidesThatThisUserHas != null && studyGuidesThatThisUserHas.contains(studyguide)) {
			studyGuidesThatThisUserHas.remove(studyguide);
		}
	}

	public List<StudyGuide> getStudyGuides() {
		return studyGuidesThatThisUserHas;
	}

	public void setStudyGuides(List<StudyGuide> studyguides) {
		this.studyGuidesThatThisUserHas = studyguides;
	}

	// ------------------------------------------------------------------------------------

	// many to one user/jobListing
	@OneToMany(mappedBy = "user")
	private List<JobListing> jobListings;

	public void addJobListing(JobListing jobListing) {

		if (jobListing == null) {
			jobListings = new ArrayList<>();
		}

		if (!jobListings.contains(jobListing)) {
			jobListings.add(jobListing);
			jobListing.setUserJob(this);
		}
	}

	public void removeJobListing(JobListing jobListing) {

		jobListing.setUserJob(null);
		if (jobListings != null && jobListings.contains(jobListing)) {
			jobListings.remove(jobListing);
		}
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", userName=" + userName + ", password=" + password + ", dateCreated=" + dateCreated + ", active="
				+ active + ", role=" + role + ", profileImageUrl=" + profileImageUrl + ", bannerImageUrl="
				+ bannerImageUrl + ", biography=" + biography + "]";
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
		User other = (User) obj;
		return id == other.id;
	}

}
