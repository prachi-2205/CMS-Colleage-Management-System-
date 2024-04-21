package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.SemesterVO;
import com.project.model.StudentVO;
import com.project.model.SubjectVO;

@Repository
public class SubjectDAOImpl implements SubjectDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveSubject(SubjectVO subjectVO) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(subjectVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SubjectVO> getSubject() {
		List<SubjectVO> ls = new ArrayList<SubjectVO>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from SubjectVO where status = true");
			ls = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SubjectVO> findById(SubjectVO subjectVO) {
		List<SubjectVO> subjectList = new ArrayList<SubjectVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from SubjectVO where status = true and id = " + subjectVO.getId());
			subjectList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subjectList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SubjectVO> findBySemesterId(int semesterId) {
		List<SubjectVO> subjectList = new ArrayList<SubjectVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from SubjectVO where status = true and semester = " + semesterId);
			subjectList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subjectList;
	}

	@Override
	public SemesterVO getSemesterOfSubject(String subjectId) {
		String semseter = "";
		List<SubjectVO> subjectList = new ArrayList<SubjectVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from SubjectVO where status = true and id = " + subjectId);
			subjectList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		SubjectVO subjectVO = subjectList.get(0);
		System.out.println(subjectList.size());
		return subjectVO.getSemester();
	}

	@Override
	public List<SubjectVO> findByDegreeAndSemesterId(int degreeId, Integer semesterId) {
		List<SubjectVO> subjectList = new ArrayList<SubjectVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(
					"from SubjectVO where status = true and degree = " + degreeId + " and  semester = " + semesterId);
			subjectList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subjectList;
	}
	

	@Override
	public List<SubjectVO> findByDegreeId(int degreeId) {
		List<SubjectVO> subjectList = new ArrayList<SubjectVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(
					"from SubjectVO where status = true and degree = " + degreeId );
			subjectList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subjectList;
	}
}
