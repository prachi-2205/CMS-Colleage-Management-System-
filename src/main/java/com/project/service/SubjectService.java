package com.project.service;

import java.util.List;

import com.project.model.SemesterVO;
import com.project.model.SubjectVO;

public interface SubjectService {

	void saveSubject(SubjectVO subjectVO);

	List<SubjectVO> getSubject();

	List<SubjectVO> findById(SubjectVO subjectVO);

	List<SubjectVO> findBySemesterId(int semesterId);

	List<SubjectVO> findByDegreeAndSemesterId(int degreeId, Integer semesterId);

	SemesterVO getSemesterOfSubject(String subjectId);

	List<SubjectVO> findByDegreeId(int degreeId);

}
