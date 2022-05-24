package com.skilldistillery.interdistillery.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.interdistillery.entities.MockInterview;
import com.skilldistillery.interdistillery.entities.User;

@Service
@Transactional
public class MockInterviewImpl implements MockInterviewDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	// find by user id
	public MockInterview findByInterviewId(int interviewId) {

		return em.find(MockInterview.class, interviewId);
	}

	@Override
	public List<MockInterview> listAllInterviews() {

		boolean foundInterviews = false;
		String jpql = "SELECT c FROM user c";

		List<MockInterview> allMockInterviews = null;

		allMockInterviews = em.createQuery(jpql, MockInterview.class).getResultList();

		if (allMockInterviews != null) {

			foundInterviews = true;
			System.out.println("PRINTING RESULT LIST");

			for (MockInterview mockInterview : allMockInterviews) {

				System.out.println(mockInterview);
			}
		} else if (allMockInterviews == null) {

			foundInterviews = false;
			System.err.println("NO MOCK INTERVIEWS FOUND");

		}
		em.close();
		return allMockInterviews;
	}

	@Override
	public MockInterview findByMockIntervieweeId(int interviewee) {

		return em.find(MockInterview.class, interviewee);
	}

	@Override
	public List<MockInterview> findByUserIdAndMockInterviewId(int interviewee, int mockInterviewId) {

		boolean mockInterviewFound = false;

		String jpql = "SELECT c FROM MockInterview WHERE c.id=:id AND c.interviewee=:in";

		List<MockInterview> mockInterviewResult = null;
		mockInterviewResult = em.createQuery(jpql, MockInterview.class).setParameter("id", mockInterviewId)
				.setParameter("in", interviewee).getResultList();

		if (mockInterviewResult != null) {

			mockInterviewFound = true;
			System.out.println("PRINTING RESULT LIST");
			for (MockInterview mockInterview : mockInterviewResult) {

				System.out.println(mockInterview);
			}
		} else if (mockInterviewResult == null) {

			mockInterviewFound = false;
			System.out.println("COULD NOT FIND INTERVIEW");
			System.out.println("SEARCH PARAMETER: User id: " + interviewee + " Interview ID:" + mockInterviewId);

		}

		return mockInterviewResult;
	}

	@Override
	public MockInterview createInterview(MockInterview mockInterview) {

		boolean mockInterviewCreated = false;

		if (mockInterview != null) {

			System.out.println("Before persist " + mockInterview);
			em.persist(mockInterview);
			System.out.println("After persist " + mockInterview);

			System.err.println("New MockInterview Created");
			mockInterviewCreated = true;
		} else {
			System.err.println("Character was not created");
			mockInterviewCreated = false;

		}
		em.close();
		return mockInterview;

	}

	@Override
	public boolean deleteInterview(int interviewId) {

		boolean successfullyDeleted = false;
		MockInterview deleteInterview = em.find(MockInterview.class, interviewId);

		if (deleteInterview != null) {

			System.out.println("deleteUser not null");

			em.remove(deleteInterview);

			successfullyDeleted = !em.contains(deleteInterview);

			System.out.println("Character Deleted ID: " + interviewId);
		} else if (deleteInterview == null) {

			System.out.println("INTERVIEW DELETION FAILED");
			System.out.println("INTERVIEW ID: " + interviewId);

		}
		em.close();
		return successfullyDeleted;

	}

}
