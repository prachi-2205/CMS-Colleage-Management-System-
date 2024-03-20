package com.project.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "result_details_table")
public class ResultDetailsVO implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "result_id")
	private ResultVO resultVO;

	@ManyToOne
	@JoinColumn(name = "student_id")
	private StudentVO studentVO;

	private String outOfMarks;

	private String obtainedMarks;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ResultVO getResultVO() {
		return resultVO;
	}

	public void setResultVO(ResultVO resultVO) {
		this.resultVO = resultVO;
	}

	public StudentVO getStudentVO() {
		return studentVO;
	}

	public void setStudentVO(StudentVO studentVO) {
		this.studentVO = studentVO;
	}

	public String getOutOfMarks() {
		return outOfMarks;
	}

	public void setOutOfMarks(String outOfMarks) {
		this.outOfMarks = outOfMarks;
	}

	public String getObtainedMarks() {
		return obtainedMarks;
	}

	public void setObtainedMarks(String obtainedMarks) {
		this.obtainedMarks = obtainedMarks;
	}

}
