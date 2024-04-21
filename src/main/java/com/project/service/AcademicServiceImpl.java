package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.AcademicDAO;
import com.project.model.AcademicVO;
import com.project.model.SemesterVO;
import com.project.model.StudentVO;

@Service
@Transactional
public class AcademicServiceImpl implements AcademicService {

	@Autowired
	private AcademicDAO academicDAO;

	@Override
	public void saveAcademic(AcademicVO academicVO) {
		this.academicDAO.saveAcademic(academicVO);
	}

	@Override
	public List<AcademicVO> getAcademic() {
		return this.academicDAO.getAcademic();

	}
	
	@Override
	public List<AcademicVO> findById(AcademicVO academicVO) {
		return this.academicDAO.findById(academicVO);
	}

	@Override
	public void deleteAcademic(AcademicVO academicVO) {
		this.academicDAO.deleteAcademic(academicVO);
		
	}

	@Override
	public SemesterVO getSemesterOfAcademic(String academicId) {
		return this.academicDAO.getSemesterOfAcademic(academicId);
	}
	
	@Override
	public List<AcademicVO> getAcademicByDegreeAndSemester(int degreeId, int semesterId) {
		return this.academicDAO.getAcademicByDegreeAndSemester(degreeId, semesterId);
	}


}
