package com.project.dao;

import java.util.List;

import com.project.model.DegreeVO;
import com.project.model.LoginVO;

public interface LoginDAO {

	void save(LoginVO loginVO);

	List<LoginVO> getById(LoginVO loginVO);

	List getByEmailId(String email);

	List<LoginVO> getUserName(String getuserName);
	
	List getDegreeCount();

	List getFacultyCount();

	List getStudentCount();

	List getStudentCountPerDegree();

}
