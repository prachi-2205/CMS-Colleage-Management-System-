package com.project.controller;



import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.DegreeVO;
import com.project.model.FacultyVO;
import com.project.model.ResultDetailsVO;
import com.project.model.ResultVO;
import com.project.model.SemesterVO;
import com.project.model.SubjectVO;
import com.project.service.DegreeService;
import com.project.service.FacultyService;
import com.project.service.ResultService;
import com.project.service.SemesterService;
import com.project.service.SubjectService;
import com.project.utils.BaseMethods;

@Controller
public class ResultController {
	@Autowired
	private DegreeService degreeService;

	@Autowired
	private SemesterService semesterService;

	@Autowired
	private ResultService resultService;

	@Autowired
	private SubjectService subjectService;

	@Autowired
	private BaseMethods baseMethods;

	@Autowired
	private FacultyService facultyService;

	
	@GetMapping(value = "admin/viewResult")
	public ModelAndView viewResultAdmin() {
		List<DegreeVO> degreelist1 = degreeService.getDegree();
		return new ModelAndView("admin/viewResult", "degreelist", degreelist1);
	}

	
}
