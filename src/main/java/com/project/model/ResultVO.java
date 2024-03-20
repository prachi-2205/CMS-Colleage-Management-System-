package com.project.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@SuppressWarnings("serial")
@Entity
@Table(name = "result_table")
public class ResultVO implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "degree_id")
	private DegreeVO degree;

	@ManyToOne
	@JoinColumn(name = "semester_id")
	private SemesterVO semester;

	@ManyToOne
	@JoinColumn(name = "subject_id")
	private SubjectVO subject;

	@ManyToOne
	@JoinColumn(name = "faculty_id")
	private FacultyVO facultyVO;

	@Column(name = "exam")
	private String exam;

	@Column(name = "status")
	private boolean status = true;

	private boolean isLockedByFaculty = false;

	private boolean isLockedByAdmin = false;

	public boolean isLockedByFaculty() {
		return isLockedByFaculty;
	}

	public void setLockedByFaculty(boolean isLockedByFaculty) {
		this.isLockedByFaculty = isLockedByFaculty;
	}

	public boolean isLockedByAdmin() {
		return isLockedByAdmin;
	}

	public void setLockedByAdmin(boolean isLockedByAdmin) {
		this.isLockedByAdmin = isLockedByAdmin;
	}

	@Transient
	private List<ResultDetailsVO> resultDetailsList;

	public List<ResultDetailsVO> getResultDetailsList() {
		return resultDetailsList;
	}

	public void setResultDetailsList(List<ResultDetailsVO> resultDetailsList) {
		this.resultDetailsList = resultDetailsList;
	}

	public FacultyVO getFacultyVO() {
		return facultyVO;
	}

	public void setFacultyVO(FacultyVO facultyVO) {
		this.facultyVO = facultyVO;
	}

	public SubjectVO getSubject() {
		return subject;
	}

	public void setSubject(SubjectVO subject) {
		this.subject = subject;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public DegreeVO getDegree() {
		return degree;
	}

	public void setDegree(DegreeVO degree) {
		this.degree = degree;
	}

	public SemesterVO getSemester() {
		return semester;
	}

	public void setSemester(SemesterVO semester) {
		this.semester = semester;
	}

	public String getExam() {
		return exam;
	}

	public void setExam(String exam) {
		this.exam = exam;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
