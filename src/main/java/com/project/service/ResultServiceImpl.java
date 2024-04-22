package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.ResultDAO;
import com.project.model.ResultDetailsVO;
import com.project.model.ResultVO;
import com.project.model.SemesterVO;

@Service
@Transactional
public class ResultServiceImpl implements ResultService {

	@Autowired
	private ResultDAO resultDAO;

	@Override
	public void saveResult(ResultVO resultVO) {
		this.resultDAO.saveResult(resultVO);
	}

	@Override
	public List<ResultVO> getResult() {
		return this.resultDAO.getResult();
	}

	@Override
	public List<ResultVO> findById(ResultVO resultVO) {
		return this.resultDAO.findById(resultVO);
	}

	@Override
	public void deleteResult(ResultVO resultVO) {
		this.resultDAO.deleteResult(resultVO);
	}

	@Override
	public SemesterVO getSemesterOfExam(String resultId) {
		return this.resultDAO.getSemesterOfExam(resultId);
	}

	@Override
	public void saveResultDetails(ResultDetailsVO resultDetailsVO) {
		this.resultDAO.saveResultDetails(resultDetailsVO);
	}

	@Override
	public List getResultDetails(int semesterId, int subjectId, int degreeId, String username, String exam,
			String type) {
		return this.resultDAO.getResultDetails(semesterId, subjectId, degreeId, username, exam, type);
	}

	@Override
	public ResultDetailsVO getResultById(String resultId) {
		return this.resultDAO.getResultById(resultId);
	}

	@Override
	public List findResults(ResultVO resultVO) {
		return this.resultDAO.findResults(resultVO);
	}

}
