package com.project.service;

import java.util.List;

import com.project.model.ExamVO;
import com.project.model.SemesterVO;

public interface ExamService {

	void saveExam(ExamVO examVO);

	List<ExamVO> getExam();

	List<ExamVO> findById(ExamVO examVO);
	 
	void deleteExam(ExamVO examVO);
	
	SemesterVO getSemesterOfExam(String examId);
	
	List<ExamVO> getExamByDegreeAndSemester(int degreeId, int semesterId);
}
