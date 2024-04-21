package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.SubjectDAO;
import com.project.model.SemesterVO;
import com.project.model.SubjectVO;

@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {

	@Autowired
	private SubjectDAO subjectDAO;

	@Override
	public void saveSubject(SubjectVO subjectVO) {
		this.subjectDAO.saveSubject(subjectVO);
	}

	@Override
	public List<SubjectVO> getSubject() {
		return this.subjectDAO.getSubject();
	}

	@Override
	public List<SubjectVO> findById(SubjectVO subjectVO) {
		return this.subjectDAO.findById(subjectVO);
	}

	@Override
	public List<SubjectVO> findBySemesterId(int semesterId) {
		return this.subjectDAO.findBySemesterId(semesterId);
	}

	@Override
	public SemesterVO getSemesterOfSubject(String subjectId) {
		return this.subjectDAO.getSemesterOfSubject(subjectId);
	}

	@Override
	public List<SubjectVO> findByDegreeAndSemesterId(int degreeId, Integer semesterId) {
		return this.subjectDAO.findByDegreeAndSemesterId(degreeId, semesterId);
	}

	@Override
	public List<SubjectVO> findByDegreeId(int degreeId) {
		return this.subjectDAO.findByDegreeId(degreeId);
	}

}
