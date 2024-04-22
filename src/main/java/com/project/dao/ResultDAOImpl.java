package com.project.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

//import java.util.ArrayList;
//import java.util.List;

//import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.model.ResultDetailsVO;
import com.project.model.ResultVO;
import com.project.model.SemesterVO;

@Repository
public class ResultDAOImpl implements ResultDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveResult(ResultVO resultVO) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(resultVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ResultVO> getResult() {
		List<ResultVO> ls = new ArrayList<ResultVO>();
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query q = session.createQuery("from ResultVO where status = true");
			ls = q.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ls;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ResultVO> findById(ResultVO resultVO) {
		List<ResultVO> resultList = new ArrayList<ResultVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from ResultVO where status = true and id = " + resultVO.getId());
			resultList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}

	@Override
	public void deleteResult(ResultVO resultVO) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.delete(resultVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public SemesterVO getSemesterOfExam(String resultId) {
		String semseter = "";
		List<ResultVO> resultList = new ArrayList<ResultVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from ResultVO where status = true and id = " + resultId);
			resultList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		ResultVO resultVO = resultList.get(0);
		System.out.println(resultList.size());
		return resultVO.getSemester();
	}

	@Override
	public void saveResultDetails(ResultDetailsVO resultDetailsVO) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			session.saveOrUpdate(resultDetailsVO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List getResultDetails(int semesterId, int subjectId, int degreeId, String username, String examTypeId,
			String type) {
		List<ResultVO> resultList = new ArrayList<ResultVO>();

		String querySQL = "from ResultDetailsVO where resultVO.status = true and resultVO.semester = " + semesterId
				+ " and resultVO.degree  = " + degreeId + " and resultVO.exam = '" + examTypeId + "' ";

		if (subjectId > 0 && type.equals("faculty")) {
			querySQL = querySQL + "and resultVO.subject = " + subjectId + " and resultVO.facultyVO.loginVO.username = '"
					+ username + "'";
		}

		else if (type.equals("student")) {
			querySQL = querySQL + " and resultVO.isLockedByFaculty = true and resultVO.isLockedByAdmin = true";
			querySQL = querySQL + " and studentVO.loginVO.username = '" + username + "'";
		}

		System.out.println(querySQL);
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery(querySQL);
			resultList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(resultList.size());
		return resultList;
	}

	@Override
	public ResultDetailsVO getResultById(String resultId) {
		List<ResultDetailsVO> resultList = new ArrayList<ResultDetailsVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from ResultDetailsVO where id = " + resultId);
			resultList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList.get(0);
	}

	@Override
	public List findResults(ResultVO resultVO) {
		List<ResultVO> resultList = new ArrayList<ResultVO>();
		try {
			Session session = sessionFactory.getCurrentSession();
			Query query = session.createQuery("from ResultVO where status = true and  exam = '" + resultVO.getExam() + "' and degree = '"
					+ resultVO.getDegree().getId() + "' and semester = " + resultVO.getSemester().getId());
			resultList = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}

}
