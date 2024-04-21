package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.AcademicVO;
import com.project.model.ExamVO;
import com.project.model.SemesterVO;
import com.project.model.StudentVO;

@Repository
public class ExamDAOImpl implements ExamDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveExam(ExamVO examVO) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(examVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ExamVO> getExam() {
		List<ExamVO> ls = new ArrayList<ExamVO>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from ExamVO where status = true");
			ls = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ExamVO> findById(ExamVO examVO) {
		List<ExamVO> examList = new ArrayList<ExamVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from ExamVO where status = true and id = " + examVO.getId());
			examList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return examList;
	}
	
	
	@Override
	public void deleteExam(ExamVO examVO) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.delete(examVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public SemesterVO getSemesterOfExam(String examId) {
		String semseter = "";
		List<ExamVO> examList = new ArrayList<ExamVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from ExamVO where status = true and id = " + examId);
			examList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		ExamVO examVO = examList.get(0);
		System.out.println(examList.size());
		return examVO.getSemester();
	}
	
	@Override
	public List<ExamVO> getExamByDegreeAndSemester(int degreeId, int semesterId) {
		List<ExamVO> examList = new ArrayList<ExamVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(
					"from ExamVO where status = true and semester = '" + semesterId + "' and degree = " + degreeId);
			examList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return examList;
	}

}
