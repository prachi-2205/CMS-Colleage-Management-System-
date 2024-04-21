package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.AcademicVO;
import com.project.model.SemesterVO;
import com.project.model.StudentVO;
import com.project.model.SubjectVO;

@Repository
public class AcademicDAOImpl implements AcademicDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveAcademic(AcademicVO academicVO) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(academicVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AcademicVO> getAcademic() {
		List<AcademicVO> ls = new ArrayList<AcademicVO>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from AcademicVO where status = true");
			ls = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AcademicVO> findById(AcademicVO academicVO) {
		List<AcademicVO> academicList = new ArrayList<AcademicVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from AcademicVO where status = true and id = " + academicVO.getId());
			academicList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return academicList;
	}

	@Override
	public void deleteAcademic(AcademicVO academicVO) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.delete(academicVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public SemesterVO getSemesterOfAcademic(String academicId) {
		String semseter = "";
		List<AcademicVO> academicList = new ArrayList<AcademicVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from AcademicVO where status = true and id = " + academicId);
			academicList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		AcademicVO academicVO = academicList.get(0);
		System.out.println(academicList.size());
		return academicVO.getSemester();
	}

	@Override
	public List<AcademicVO> getAcademicByDegreeAndSemester(int degreeId, int semesterId) {
		List<AcademicVO> academicList = new ArrayList<AcademicVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(
					"from AcademicVO where status = true and semester = '" + semesterId + "' and degree = " + degreeId);
			academicList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return academicList;
	}

}
