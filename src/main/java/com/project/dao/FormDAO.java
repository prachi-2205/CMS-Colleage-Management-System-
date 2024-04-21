package com.project.dao;

import java.util.List;

import com.project.model.FormVO;

public interface FormDAO {

	void saveForm(FormVO formVO);

	List<FormVO> getForm();
	List<FormVO> findById(FormVO formVO);
	void deleteForm(FormVO formVO);
}
