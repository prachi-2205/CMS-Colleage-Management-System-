package com.project.service;

import java.util.List;

import com.project.model.DegreeVO;

public interface DegreeService {

	void saveDegree(DegreeVO degreeVO);

	List<DegreeVO> getDegree();
	List<DegreeVO> findById(DegreeVO degreeVO);
}
