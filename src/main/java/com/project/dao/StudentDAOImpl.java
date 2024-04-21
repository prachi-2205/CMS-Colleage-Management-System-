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

@Repository
public class StudentDAOImpl implements StudentDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveStudent(StudentVO studentVO) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(studentVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentVO> getStudent() {
		List<StudentVO> ls = new ArrayList<StudentVO>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from StudentVO where status = true");
			ls = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<StudentVO> findById(StudentVO studentVO) {
		List<StudentVO> studentList = new ArrayList<StudentVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from StudentVO where status = true and id = " + studentVO.getId());
			studentList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentList;
	}

	@Override
	public List<StudentVO> getStudentByDegreeAndSemester(int degreeId, int semesterId) {
		List<StudentVO> studentList = new ArrayList<StudentVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(
					"from StudentVO where status = true and semester = '" + semesterId + "' and degree = " + degreeId);
			studentList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentList;
	}

	@Override
	public List getByErNo(String erNo) {
		List<StudentVO> studentList = new ArrayList<StudentVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from StudentVO where status = true and enrollmentNo = '" + erNo + "'");
			studentList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentList;
	}

	@Override
	public SemesterVO getSemesterOfStudent(String studentId) {
		String semseter = "";
		List<StudentVO> studentList = new ArrayList<StudentVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from StudentVO where status = true and id = " + studentId);
			studentList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		StudentVO studentVO = studentList.get(0);
		System.out.println(studentList.size());
		return studentVO.getSemester();
	}

	
	
}
