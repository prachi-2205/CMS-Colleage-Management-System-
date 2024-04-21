package com.project.dao;

import java.util.List;

import com.project.model.SubjectVO;
import com.project.model.SemesterVO;

public interface SubjectDAO {

	void saveSubject(SubjectVO subjectVO);

	List<SubjectVO> getSubject();

	List<SubjectVO> findById(SubjectVO subjectVO);

	List<SubjectVO> findBySemesterId(int semesterId);

	SemesterVO getSemesterOfSubject(String subjectId);

	List<SubjectVO> findByDegreeAndSemesterId(int degreeId, Integer semesterId);

	List<SubjectVO> findByDegreeId(int degreeId);
}
