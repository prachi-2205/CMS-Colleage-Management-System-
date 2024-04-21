package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.FormDAO;
import com.project.model.AcademicVO;
import com.project.model.FormVO;


@Service
@Transactional
public class FormServiceImpl implements FormService {

	@Autowired
	private FormDAO formDAO;

	@Override
	public void saveForm(FormVO formVO) {
		this.formDAO.saveForm(formVO);
	}

	@Override
	public List<FormVO> getForm() {
		return this.formDAO.getForm();
	}
	
	@Override
	public List<FormVO> findById(FormVO formVO) {
		return this.formDAO.findById(formVO);
	}
	
	@Override
	public void deleteForm(FormVO formVO) {
		this.formDAO.deleteForm(formVO);
		
	}

}
