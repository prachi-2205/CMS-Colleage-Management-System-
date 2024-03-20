package com.project.dao;

import java.util.List;

import com.project.model.DegreeVO;

public interface DegreeDAO {

	void saveDegree(DegreeVO degreeVO);

	List<DegreeVO> getDegree();
	List<DegreeVO> findById(DegreeVO degreeVO);
}
