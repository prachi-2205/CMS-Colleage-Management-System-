package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.LoginDAO;
import com.project.model.DegreeVO;
import com.project.model.LoginVO;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDAO loginDAO;

	public void save(LoginVO loginVO) {
		this.loginDAO.save(loginVO);
	}

	
	public List<LoginVO> getById(LoginVO loginVO) {
		return this.loginDAO.getById(loginVO);
	}

	
	public boolean getByEmailId(String email) {
		List ls = this.loginDAO.getByEmailId(email);
		return ls.size() > 0;
	}

	
	public List<LoginVO> getUserName(String getuserName) {
		// TODO Auto-generated method stub
		return this.loginDAO.getUserName(getuserName);
	}
	
	public List getDegreeCount() {
		return this.loginDAO.getDegreeCount();
	}

	
	public List getFacultyCount() {
		return this.loginDAO.getFacultyCount();
	}

	
	public List getStudentCount() {
		return this.loginDAO.getStudentCount();
	}

	
	public List getStudentCountPerDegree() {
		return loginDAO.getStudentCountPerDegree();
	}
	
	
}
