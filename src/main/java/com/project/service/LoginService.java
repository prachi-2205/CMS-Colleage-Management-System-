package com.project.service;

import java.util.List;

import com.project.model.LoginVO;

public interface LoginService {

	void save(LoginVO loginVO);

	public List<LoginVO> getById(LoginVO loginVO);
	
	boolean getByEmailId(String email);

	List<LoginVO> getUserName(String getuserName);
	
	List getDegreeCount();

	List getFacultyCount();

	List getStudentCount();

	List getStudentCountPerDegree();

	
}
