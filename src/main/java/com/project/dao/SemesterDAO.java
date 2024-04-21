package com.project.dao;

import java.util.List;

import com.project.model.DegreeVO;
import com.project.model.SemesterVO;

public interface SemesterDAO {

	void saveSemester(SemesterVO semesterVO);

	List<SemesterVO> getSemester();

	List<SemesterVO> findById(SemesterVO semesterVO);

	List<SemesterVO> findByDegree(DegreeVO degreeVO);

}
