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
@Table(name = "academic_table")
public class AcademicVO implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "degree_id")
	private DegreeVO degree;

	@ManyToOne
	@JoinColumn(name = "semester_id")
	private SemesterVO semester;

	@Column(name = "academic_start_date")
	private String academicStartDate;
	
	@Column(name = "academic_end_date")
	private String academicEndDate;

	@Column(name = "file_name")
	private String fileName;

	@Column(name = "file_path")
	private String filePath;

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

	public String getAcademicStartDate() {
		return academicStartDate;
	}

	public void setAcademicStartDate(String academicStartDate) {
		this.academicStartDate = academicStartDate;
	}

	public String getAcademicEndDate() {
		return academicEndDate;
	}

	public void setAcademicEndDate(String academicEndDate) {
		this.academicEndDate = academicEndDate;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	

}