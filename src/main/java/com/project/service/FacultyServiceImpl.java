package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.FacultyDAO;
import com.project.model.FacultyVO;

@Service
@Transactional
public class FacultyServiceImpl implements FacultyService {

	@Autowired
	private FacultyDAO facultyDAO;

	@Override
	public void saveFaculty(FacultyVO facultyVO) {
		this.facultyDAO.saveFaculty(facultyVO);
	}

	@Override
	public List<FacultyVO> getFaculty() {
		return this.facultyDAO.getFaculty();
	}

	@Override
	public List<FacultyVO> findById(FacultyVO facultyVO) {
		return this.facultyDAO.findById(facultyVO);
	}

	@Override
	public List<FacultyVO> findByUserName(String userName) {
		return this.facultyDAO.findByUserName(userName);
	}

}
