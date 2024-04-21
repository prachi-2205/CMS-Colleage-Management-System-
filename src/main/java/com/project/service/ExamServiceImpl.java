package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.ExamDAO;
import com.project.model.AcademicVO;
import com.project.model.ExamVO;
import com.project.model.SemesterVO;

@Service
@Transactional
public class ExamServiceImpl implements ExamService {

	@Autowired
	private ExamDAO examDAO;

	@Override
	public void saveExam(ExamVO examVO) {
		this.examDAO.saveExam(examVO);
	}

	@Override
	public List<ExamVO> getExam() {
		return this.examDAO.getExam();

	}
	
	@Override
	public List<ExamVO> findById(ExamVO examVO) {
		return this.examDAO.findById(examVO);
	}
	
	@Override
	public void deleteExam(ExamVO examVO) {
		this.examDAO.deleteExam(examVO);
		
	}

	@Override
	public SemesterVO getSemesterOfExam(String examId) {
		return this.examDAO.getSemesterOfExam(examId);
	}
	
	@Override
	public List<ExamVO> getExamByDegreeAndSemester(int degreeId, int semesterId) {
		return this.examDAO.getExamByDegreeAndSemester(degreeId, semesterId);
	}
}
