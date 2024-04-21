package com.project.service;

import java.util.List;

import com.project.model.FormVO;

public interface FormService {

	void saveForm(FormVO formVO);

	List<FormVO> getForm();
	List<FormVO> findById(FormVO formVO);
	void deleteForm(FormVO formVO);
}
