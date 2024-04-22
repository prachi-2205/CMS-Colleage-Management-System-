package com.project.service;

import java.util.List;

import com.project.model.ResultDetailsVO;
import com.project.model.ResultVO;
import com.project.model.SemesterVO;

public interface ResultService {

	void saveResult(ResultVO resultVO);

	List<ResultVO> getResult();

	List<ResultVO> findById(ResultVO resultVO);

	void deleteResult(ResultVO resultVO);

	SemesterVO getSemesterOfExam(String resultId);

	void saveResultDetails(ResultDetailsVO resultDetailsVO);

	ResultDetailsVO getResultById(String resultId);

	List getResultDetails(int semesterId, int subjectId, int degreeId, String username, String examTypeId, String type);

	List findResults(ResultVO resultVO);
}
