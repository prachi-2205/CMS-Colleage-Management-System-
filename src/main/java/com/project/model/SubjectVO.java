package com.project.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "subject_table")
public class SubjectVO implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="degree_id")
	private DegreeVO degree;
	
	@ManyToOne
	@JoinColumn(name="semester_id")
	private SemesterVO semester;

	@Column(name = "subject_name")
	private String subjectName;

	@Column(name = "subject_code")
	private String subjectCode;
	
	@Column(name = "subject_credit")
	private String subjectCredit;

	@Column(name = "status")
	private boolean status = true;

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

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectCredit() {
		return subjectCredit;
	}

	public void setSubjectCredit(String subjectCredit) {
		this.subjectCredit = subjectCredit;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	
}
