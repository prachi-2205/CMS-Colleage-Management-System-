package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.DegreeVO;
import com.project.model.LoginVO;

@Repository
public class LoginDAOImpl implements LoginDAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	public void save(LoginVO loginVO) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(loginVO);
		} catch (HibernateException e) {
			e.printStackTrace();
		}
	}

	
	public List<LoginVO> getById(LoginVO loginVO) {
		List<LoginVO> ls = new ArrayList<LoginVO>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from LoginVO where id = " + loginVO.getId());
			ls = q.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return ls;
	}

	
	public List getByEmailId(String email) {
		List<LoginVO> ls = new ArrayList<LoginVO>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from LoginVO where username = '" + email + "'");
			ls = q.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return ls;
	}


	public List<LoginVO> getUserName(String getuserName) {
		// TODO Auto-generated method stub
		List<LoginVO> ls = new ArrayList<LoginVO>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from LoginVO where username = '" + getuserName + "'");
			ls = q.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return ls;
	}
	
	public List getDegreeCount() {
		List ls = new ArrayList();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createSQLQuery("select count(*) from degree_table where status = true ");
			ls = q.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return ls;
	}

	public List getFacultyCount() {
		List ls = new ArrayList();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createSQLQuery("select count(*) from faculty_table where status = true ");
			ls = q.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return ls;
	}

	public List getStudentCount() {
		List ls = new ArrayList();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createSQLQuery("select count(*) from student_table where status = true ");
			ls = q.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return ls;
	}

	public List getStudentCountPerDegree() {
		List ls = new ArrayList();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createSQLQuery(
					"SELECT COUNT(*),degree_table.degree__name FROM student_table INNER JOIN degree_table ON student_table.degree_id = degree_table.id GROUP BY student_table.degree_id");
			ls = q.list();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return ls;
	}
	
	

}
