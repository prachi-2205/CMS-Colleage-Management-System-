package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.FacultyVO;

@Repository
public class FacultyDAOImpl implements FacultyDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveFaculty(FacultyVO facultyVO) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(facultyVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FacultyVO> getFaculty() {
		List<FacultyVO> ls = new ArrayList<FacultyVO>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from FacultyVO where status = true");
			ls = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FacultyVO> findById(FacultyVO facultyVO) {
		List<FacultyVO> facultyList = new ArrayList<FacultyVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from FacultyVO where status = true and id =   " + facultyVO.getId());
			facultyList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return facultyList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<FacultyVO> findByUserName(String userName) {
		List<FacultyVO> facultyList = new ArrayList<FacultyVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session
					.createQuery("from FacultyVO where status = true and loginVO.username =  '" + userName + "'  ");
			facultyList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return facultyList;
	}

}
