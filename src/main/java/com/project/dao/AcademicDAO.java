package com.project.dao;

import java.util.List;

import com.project.model.AcademicVO;
import com.project.model.SemesterVO;

public interface AcademicDAO {

	void saveAcademic(AcademicVO academicVO);

	List<AcademicVO> getAcademic();

	List<AcademicVO> findById(AcademicVO academicVO);

	void deleteAcademic(AcademicVO academicVO);
	
	SemesterVO getSemesterOfAcademic(String academicId);
	
	List<AcademicVO> getAcademicByDegreeAndSemester(int degreeId, int semesterId);

}
