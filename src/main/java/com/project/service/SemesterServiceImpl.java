package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.SemesterDAO;
import com.project.model.DegreeVO;
import com.project.model.SemesterVO;

@Service
@Transactional
public class SemesterServiceImpl implements SemesterService {

	@Autowired
	private SemesterDAO semesterDAO;

	@Override
	public void saveSemester(SemesterVO semesterVO) {
		this.semesterDAO.saveSemester(semesterVO);
	}

	@Override
	public List<SemesterVO> getSemester() {
		return this.semesterDAO.getSemester();
	}
	
	@Override
	public List<SemesterVO> findById(SemesterVO semesterVO) {
		return this.semesterDAO.findById(semesterVO);
	}

	@Override
	public List<SemesterVO> findByDegree(DegreeVO degreeVO) {
		return this.semesterDAO.findByDegree(degreeVO);
	}

	

}
