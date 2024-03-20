package com.project.controller;

import java.io.BufferedOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.AssignmentVO;
import com.project.model.DegreeVO;
import com.project.model.SemesterVO;
import com.project.model.SubjectVO;


@Controller
public class AssignmentController {

	

	@SuppressWarnings("unchecked")
	@GetMapping(value = "user/assignment")
	public ModelAndView userAssignment() {

		

		return new ModelAndView("user/assignment");
	}

	@GetMapping(value = "user/viewAssignment")
	public ModelAndView viewAssignment1() {
		

		return new ModelAndView("user/viewAssignment");
	}
//
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	@GetMapping(value = "faculty/getSemesterOfAssignment")
//	public ResponseEntity getSemesterOfAssignment(String assignmentId) {
//		Map semester = this.assignmentService.getSemesterOfAssignment(assignmentId);
//		return new ResponseEntity(semester, HttpStatus.OK);
//	}

	@GetMapping(value = "faculty/uploadAssignment")
	public ModelAndView uploadAssignment() {
		

		return new ModelAndView("faculty/uploadAssignment");
	}

	@PostMapping(value = "faculty/saveAssignment")
	public ModelAndView saveAssignment(@ModelAttribute AssignmentVO assignmentVO, @RequestParam MultipartFile file,
			HttpServletRequest request) {

		
		return new ModelAndView("redirect:/faculty/viewAssignment");
	}

	@GetMapping(value = "faculty/viewAssignment")
	public ModelAndView viewAssignment() {
		
		return new ModelAndView("faculty/viewAssignment");
	}

	@GetMapping(value = "faculty/deleteAssignment")
	public ModelAndView deleteAssignment() {

		

		return new ModelAndView("redirect:/faculty/viewAssignment");
	}

	@GetMapping(value = "faculty/editAssignment")
	public ModelAndView editAssignment() {

		

		return new ModelAndView("faculty/uploadAssignment");
	}

//	@GetMapping(value = { "faculty/getSubjectBySemester", "admin/getSubjectBySemester" })
//	public ResponseEntity<Object> getSemesterByDegree(@RequestParam int semesterId) {
//		List<SubjectVO> subjectList = this.subjectService.findBySemesterId(semesterId);
//		return new ResponseEntity<Object>(subjectList, HttpStatus.OK);
//	}

//	@SuppressWarnings("rawtypes")
//	@GetMapping(value = { "user/getAssignmentsByDegreeAndSem" })
//	public ResponseEntity<Object> getAssignmentsByDegreeAndSem(@RequestParam int semesterId,
//			@RequestParam String degreeName) {
//		List data = this.assignmentService.getAssignmentsByDegreeAndSem(degreeName, semesterId);
//		return new ResponseEntity<Object>(data, HttpStatus.OK);
//	}

}
