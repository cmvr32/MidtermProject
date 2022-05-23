package com.skilldistillery.interdistillery.data;

import java.util.ArrayList;
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
		em.close();

		return userFindResumeByUserIdAndResumeId;

	}

	@Override
	//create new resume for user
	public Resume createResume(Resume newUserResume) {

		boolean resumeCreated=false;
		
		if(newUserResume !=null){
		
		
		System.out.println("Before persist " + newUserResume);
		em.persist(newUserResume);
		System.out.println("After persist " + newUserResume);

		System.out.println("New Resume Created");
		resumeCreated=true;
		}else {
			System.err.println("Character was not created");
			resumeCreated=false;
			
		}
		em.close();
		return newUserResume;


	}

	@Override
	public Resume updateResume(Resume resume) {

		Resume resumeToUpdate = em.find(Resume.class, resume.getId());
		if (resumeToUpdate != null) {
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
	public Resume findResumeJobListing(Resume resume) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resume findResumeEducationLevel(Resume resume) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resume findResumeJobSkills(Resume resume) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resume findAllResumesForUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
