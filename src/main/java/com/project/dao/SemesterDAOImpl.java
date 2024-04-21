package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.DegreeVO;
import com.project.model.SemesterVO;

@Repository
public class SemesterDAOImpl implements SemesterDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveSemester(SemesterVO semesterVO) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(semesterVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SemesterVO> getSemester() {
		List<SemesterVO> ls = new ArrayList<SemesterVO>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from SemesterVO where status = true");
			ls = q.list();
			System.out.println(ls);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SemesterVO> findById(SemesterVO semesterVO) {
		List<SemesterVO> semesterList = new ArrayList<SemesterVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from SemesterVO where status = true and id = " + semesterVO.getId());
			semesterList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return semesterList;
	}

	@Override
	public List<SemesterVO> findByDegree(DegreeVO degreeVO) {
		List<SemesterVO> semesterList = new ArrayList<SemesterVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from SemesterVO where status = true and degree = " + degreeVO.getId());
			semesterList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return semesterList;
	}

}
