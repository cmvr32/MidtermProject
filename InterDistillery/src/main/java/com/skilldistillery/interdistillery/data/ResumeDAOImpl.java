package com.skilldistillery.interdistillery.data;

import com.skilldistillery.interdistillery.entities.Resume;

//TODO RESUME DAO

public class ResumeDAOImpl implements ResumeDAO {

	@Override
	public Resume findResumeById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resume findByUserAndResumeID(int userId, int resumeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resume findByUserIdResumeIduserName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resume createResume(Resume newResume) {

		return null;
	}

	@Override
	public Resume updateResume(Resume resume) {
		

//			Resume resumeToUpdate = em.find(resume.class, resume.getId());
//			if (resumeToUpdate != null) {
//				resumeToUpdate.setContactInfo(resume.getContactInfo());
//				resumeToUpdate.setIntroduction(resume.getIntroduction());
//				resumeToUpdate.setExperince(resume.getExperince());
//				resumeToUpdate.setLocation(resume.getLocation());
//				resumeToUpdate.setAircraftTailNumber(resume.getAircraftTailNumber());
//				resumeToUpdate.setPilotInCommandName(resume.getPilotInCommandName());
//				resumeToUpdate.setPilotName(resume.getPilotName());
//				resumeToUpdate.setCrewCheifName(resume.getCrewCheifName());
//				resumeToUpdate.setMedicName(resume.getMedicName());
//				resumeToUpdate.setMissionEnviroment(resume.getMissionEnviroment());
//				resumeToUpdate.setMissionType(resume.getMissionType());
//				resumeToUpdate.setSpecialEquipment(resume.getSpecialEquipment());
//
//			}
		
		return null;
	}

	@Override
	public Boolean deleteResume(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
