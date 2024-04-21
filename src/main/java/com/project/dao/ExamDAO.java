package com.project.dao;

import java.util.List;

import com.project.model.ExamVO;
import com.project.model.SemesterVO;

public interface ExamDAO {

	void saveExam(ExamVO examVO);

	List<ExamVO> getExam();

	List<ExamVO> findById(ExamVO examVO);
	
	void deleteExam(ExamVO examVO);
	
	SemesterVO getSemesterOfExam(String examId);
	
	List<ExamVO> getExamByDegreeAndSemester(int degreeId, int semesterId);

}
