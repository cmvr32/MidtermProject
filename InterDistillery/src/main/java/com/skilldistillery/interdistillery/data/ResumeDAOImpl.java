package com.skilldistillery.interdistillery.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.interdistillery.entities.Resume;
import com.skilldistillery.interdistillery.entities.User;

//TODO RESUME DAO

@Service
@Transactional
public class ResumeDAOImpl implements ResumeDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Resume findResumeById(int resumeId) {

		return em.find(Resume.class, resumeId);

	}

	// read
	// ADMIN list all users
	// TODO create admin permissions
	@Override
	public List<Resume> findAllResumes() {
		String jpql = "SELECT r FROM resume r";
		return em.createQuery(jpql, Resume.class).getResultList();
	}

	@Override
	// find resume with user ID and resume ID
	// TODO PASS IN USER ID RESUME IF OR USER
	public Resume findByUserIdAndResumeId(int userId, int resumeId) {

		Resume userFindResumeByUserIdAndResumeId = null;
		String jpql = "SELECT c FROM resume c WHERE c.resume = :rs AND c.user=:ur";
		boolean resumeFound = false;

		System.out.println("---FINDING RESUME WITH USER ID AND RESUME ID---");
		System.out.println("LOOKING FOR RESUME:  userID:" + userId + ", resumeId:" + resumeId);

		userFindResumeByUserIdAndResumeId = em.createQuery(jpql, Resume.class).setParameter("rs", resumeId)
				.setParameter("ur", userId).getSingleResult();

		if (userFindResumeByUserIdAndResumeId != null) {

			System.out.println("RESUME FOUND: " + userFindResumeByUserIdAndResumeId);

			resumeFound = true;

		} else if (userFindResumeByUserIdAndResumeId == null) {

			System.err.println("RESUME NOT FOUND");
			System.out.println("SEARCH PARAMETERS: userId" + userId + ", resumeId " + resumeId);
			resumeFound = false;
		}

		return userFindResumeByUserIdAndResumeId;

	}

	@Override
	// create new resume for user
	public Resume createResume(Resume newUserResume, User user) {

		boolean resumeCreated = false;
		User user1 = em.find(User.class, user.getId());
		if (newUserResume != null) {
			newUserResume.setUser(user1);

			System.out.println("Before persist " + newUserResume);
			em.persist(newUserResume);
			System.out.println("After persist " + newUserResume);

			System.out.println("New Resume Created");
			resumeCreated = true;
		} else {
			System.err.println("Resume was not created");
			resumeCreated = false;

		}

		return newUserResume;

	}

	@Override
	public Resume updateResume(Integer resumeId, Resume resume) {

		Resume resumeToUpdate = em.find(Resume.class, resume.getId());

		if (resumeToUpdate != null && resumeToUpdate.getId() == resumeId) {
			resumeToUpdate.setContactInfo(resume.getContactInfo());
			resumeToUpdate.setIntroduction(resume.getIntroduction());
			resumeToUpdate.setExperience(resume.getExperience());
			resumeToUpdate.setDegree(resume.getDegree());
			resumeToUpdate.setUser(resume.getUser());
			resumeToUpdate.setJobListing(resume.getJobListing());
			resumeToUpdate.setResumeEducationLevel(resume.getResumeEducationLevel());

		}

		return null;
	}

	@Override
	// delete resume
	public Boolean deleteResume(int id) {

		boolean deleted = false;
		System.out.println("DELETING RESUME RESUME ID: " + id);
		Resume resumeToDelete = em.find(Resume.class, id);
		if (resumeToDelete != null) {
			em.remove(resumeToDelete);
			deleted = !em.contains(resumeToDelete);
		} else if (resumeToDelete == null) {

			deleted = false;
			System.err.println("RESUME NOT FOUND");
			System.out.println("Deletion Failed for Resume ID" + id);
		}

		return deleted;
	}

	@Override
	// find the education level written on resume
	public Resume findResumeEducationLevel(Resume resume) {

		Integer resumeId = resume.getId();

		String jpql = "SELECT r.resumeEducationLevel FROM resume r WHERE r.resume =:id";
		boolean resumeFound = false;

		System.out.println("---FINDING EDUCATION LEVEL WITH RESUME ID---");
		System.out.println("LOOKING FOR RESUME:  resumeID:" + resumeId);

		Resume educationLevelResult = null;

		educationLevelResult = em.createQuery(jpql, Resume.class).setParameter("id", resumeId).getSingleResult();

		if (educationLevelResult != null) {

			System.out.println("EDUCATION LEVEL FOUND: " + educationLevelResult);

			resumeFound = true;

		} else if (educationLevelResult == null) {

			System.err.println("RESUME NOT FOUND");
			System.out.println("SEARCH PARAMETERS: Resume Id:" + resumeId);
			resumeFound = false;
		}

		return educationLevelResult;

	}

	@Override
	// find any job skills listed on resume
	public List<Resume> findResumeJobSkills(Resume resume) {

		Integer resumeId = resume.getId();

		String jpql = "SELECT r.jobSkill FROM resume r WHERE r.resume =:id";
		boolean jobSkillFound = false;

		System.out.println("---FINDING JOB SKILL WITH RESUME ID---");
		System.out.println("LOOKING FOR JOBSKILL:  resumeID:" + resumeId);

		List<Resume> jobSkillResult = null;

		jobSkillResult = em.createQuery(jpql, Resume.class).setParameter("id", resumeId).getResultList();

		if (jobSkillResult != null) {

			System.out.println("EDUCATION LEVEL FOUND");

			for (Resume jobSkillList : jobSkillResult) {

			}

			jobSkillFound = true;

		} else if (jobSkillResult == null) {

			System.err.println("RESUME NOT FOUND");
			System.out.println("SEARCH PARAMETERS: Resume Id:" + resumeId);
			jobSkillFound = false;
		}

		return jobSkillResult;

	}

	@Override
	// find job listing that corresponds to resume
	public Resume findResumeJobListing(Resume resume) {

		Resume resumeJobListing = null;
		int resumeId = resume.getId();
		String jpql = "SELECT jobListing FROM resume c WHERE c.resume = :id";
		boolean resumeFound = false;

		System.out.println("---FINDING RESUME WITH USER ID AND RESUME ID---");
		System.out.println("LOOKING FOR JOBLISTING WITH resumeId: " + resumeId);

		Resume jobListing = null;

		jobListing = em.createQuery(jpql, Resume.class).setParameter("rs", resumeId).setParameter("id", resumeId)
				.getSingleResult();

		if (jobListing != null) {

			System.out.println("RESUME FOUND: " + jobListing);

			resumeFound = true;

		} else if (jobListing == null) {

			System.err.println("RESUME NOT FOUND");
			System.out.println("SEARCH PARAMETERS: userId " + resumeId);
			resumeFound = false;
		}

		return jobListing;
	}

}
