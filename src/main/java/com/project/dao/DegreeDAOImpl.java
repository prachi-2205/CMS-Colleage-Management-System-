package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.DegreeVO;

@Repository
public class DegreeDAOImpl implements DegreeDAO {

	@Autowired
	private SessionFactory sessionFactory;

	
	public void saveDegree(DegreeVO degreeVO) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(degreeVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	
	public List<DegreeVO> getDegree() {
		List<DegreeVO> ls = new ArrayList<DegreeVO>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from DegreeVO where status = true");
			ls = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;

	}
	
	@SuppressWarnings("unchecked")
	
	public List<DegreeVO> findById(DegreeVO degreeVO) {
		List<DegreeVO> degreeList = new ArrayList<DegreeVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from DegreeVO where status = true and id = " + degreeVO.getId());
			degreeList = (List<DegreeVO>) query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return degreeList;
	}

}
