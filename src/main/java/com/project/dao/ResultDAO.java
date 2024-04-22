package com.project.dao;

import java.util.List;

import com.project.model.ResultDetailsVO;
import com.project.model.ResultVO;
import com.project.model.SemesterVO;

public interface ResultDAO {

	void saveResult(ResultVO resultVO);

	List<ResultVO> getResult();

	List<ResultVO> findById(ResultVO resultVO);

	void deleteResult(ResultVO resultVO);

	SemesterVO getSemesterOfExam(String examId);

	void saveResultDetails(ResultDetailsVO resultDetailsVO);

	List getResultDetails(int semesterId, int subjectId, int degreeId, String username, String examTypeId, String type);

	ResultDetailsVO getResultById(String resultId);

	List findResults(ResultVO resultVO);

}
