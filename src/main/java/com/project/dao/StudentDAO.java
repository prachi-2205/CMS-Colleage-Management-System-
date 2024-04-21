package com.project.dao;

import java.util.List;

import com.project.model.SemesterVO;
import com.project.model.StudentVO;

public interface StudentDAO {

	void saveStudent(StudentVO studentVO);

	List<StudentVO> getStudent();

	List<StudentVO> findById(StudentVO studentVO);

	List<StudentVO> getStudentByDegreeAndSemester(int degreeId, int semesterId);

	List getByErNo(String erNo);

	SemesterVO getSemesterOfStudent(String studentId);

}
