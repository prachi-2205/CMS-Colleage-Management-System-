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
@Table(name = "sem_table")
public class SemesterVO implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="degree_id")
	private DegreeVO degree;

	@Column(name = "semester_no")
	private String semesterNo;

	@Column(name = "semester_time")
	private String semesterTime;

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

	public String getSemesterNo() {
		return semesterNo;
	}

	public void setSemesterNo(String semesterNo) {
		this.semesterNo = semesterNo;
	}

	public String getSemesterTime() {
		return semesterTime;
	}

	public void setSemesterTime(String semesterTime) {
		this.semesterTime = semesterTime;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	

}
