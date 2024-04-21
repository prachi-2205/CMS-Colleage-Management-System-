package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.AcademicVO;
import com.project.model.FormVO;

@Repository
public class FormDAOImpl implements FormDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveForm(FormVO formVO) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(formVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FormVO> getForm() {
		List<FormVO> ls = new ArrayList<FormVO>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from FormVO where status = true");
			ls = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;

	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<FormVO> findById(FormVO formVO) {
		List<FormVO> formList = new ArrayList<FormVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from FormVO where status = true and id = " + formVO.getId());
			formList = (List<FormVO>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return formList;
	}
	
	@Override
	public void deleteForm(FormVO formVO) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.delete(formVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
