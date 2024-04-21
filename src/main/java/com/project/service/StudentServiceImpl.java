package com.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.StudentDAO;
import com.project.model.SemesterVO;
import com.project.model.StudentVO;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDAO studentDAO;

	@Override
	public void saveStudent(StudentVO studentVO) {
		this.studentDAO.saveStudent(studentVO);
	}

	@Override
	public List<StudentVO> getStudent() {
		return this.studentDAO.getStudent();
	}

	@Override
	public List<StudentVO> findById(StudentVO studentVO) {
		return this.studentDAO.findById(studentVO);
	}

	@Override
	public List<StudentVO> getStudentByDegreeAndSemester(int degreeId, int semesterId) {
		return this.studentDAO.getStudentByDegreeAndSemester(degreeId, semesterId);
	}

	@Override
	public boolean getByErNo(String erNo) {
		List ls = this.studentDAO.getByErNo(erNo);
		return ls.size() > 0;
	}

	@Override
	public SemesterVO getSemesterOfStudent(String studentId) {
		return this.studentDAO.getSemesterOfStudent(studentId);
	}

}
