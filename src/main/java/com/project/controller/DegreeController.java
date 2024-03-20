package com.project.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.DegreeVO;
import com.project.model.SemesterVO;
import com.project.model.SubjectVO;
import com.project.service.DegreeService;


@Controller
public class DegreeController {


	

	@GetMapping(value = "admin/addDegree")
	public ModelAndView addDegree() {
		return new ModelAndView("admin/addDegree");
	}

	@PostMapping(value = "admin/saveDegree")
	public ModelAndView saveDegree() {
	
		return new ModelAndView("redirect:/admin/viewDegree");
	}

	@GetMapping(value = "admin/viewDegree")
	public ModelAndView viewDegree() {
		
		return new ModelAndView("admin/viewDegree");
	}

	@GetMapping(value = "user/viewCourses")
	public ModelAndView viewUserDegree() {
		
		return new ModelAndView("user/viewCourse");
	}

	@GetMapping(value = "user/viewCourseDetails")
	public ModelAndView viewCourseDetails() {
		
		
		return new ModelAndView("user/viewCourseDetails");
	}

	@GetMapping(value = "admin/deleteDegree")
	public ModelAndView deleteDegree() {

		

		return new ModelAndView("redirect:/admin/viewDegree");
	}

	@GetMapping(value = "admin/editDegree")
	public ModelAndView editDegree() {
		
		return new ModelAndView("admin/addDegree");
	}

}
