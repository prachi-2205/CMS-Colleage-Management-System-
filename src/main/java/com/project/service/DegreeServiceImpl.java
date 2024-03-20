package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.DegreeDAO;
import com.project.model.DegreeVO;


@Service
@Transactional
public class DegreeServiceImpl implements DegreeService {

	@Autowired
	private DegreeDAO degreeDAO;


	public void saveDegree(DegreeVO degreeVO) {
		this.degreeDAO.saveDegree(degreeVO);
	}

	
	public List<DegreeVO> getDegree() {
		return this.degreeDAO.getDegree();
	}
	
	
	public List<DegreeVO> findById(DegreeVO degreeVO) {
		return this.degreeDAO.findById(degreeVO);
	}

}
