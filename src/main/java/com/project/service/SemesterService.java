package com.project.service;

import java.util.List;

import com.project.model.DegreeVO;
import com.project.model.SemesterVO;

public interface SemesterService {

	void saveSemester(SemesterVO semesterVO);

	List<SemesterVO> getSemester();

	List<SemesterVO> findById(SemesterVO semesterVO);

	List<SemesterVO> findByDegree(DegreeVO degreeVO);

}
