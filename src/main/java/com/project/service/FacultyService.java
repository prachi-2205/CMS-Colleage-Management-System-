package com.project.service;

import java.util.List;

import com.project.model.FacultyVO;

public interface FacultyService {

	void saveFaculty(FacultyVO facultyVO);

	List<FacultyVO> getFaculty();

	List<FacultyVO> findById(FacultyVO facultyVO);

	List<FacultyVO> findByUserName(String userName);
}
