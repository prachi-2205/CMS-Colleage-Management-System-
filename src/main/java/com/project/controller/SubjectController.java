package com.project.controller;


import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.SubjectVO;



@Controller
public class SubjectController {


	@RequestMapping(value = "/user/sub", method = RequestMethod.GET)
	public ModelAndView sub() {
		return new ModelAndView("user/blog-list");
	}

	
	@GetMapping(value = "admin/addSubject")
	public ModelAndView addSubject() {
	
		
		return new ModelAndView("admin/addSubject", "SubjectVO", new SubjectVO());
	}

	@PostMapping(value = "admin/saveSubject")
	public ModelAndView saveSubject() {

		return new ModelAndView("redirect:/admin/viewSubject");
	}

	@PostMapping(value = "admin/updateSubject")
	public ModelAndView updateSubject() {
		
		return new ModelAndView("redirect:/admin/viewSubject");
	}

	@GetMapping(value = "admin/viewSubject")
	public ModelAndView viewSubject() {
		
		return new ModelAndView("admin/viewSubject");
	}

	@GetMapping(value = "admin/deleteSubject")
	public ModelAndView deleteSubject() {

		

		return new ModelAndView("redirect:/admin/viewSubject");
	}

	@GetMapping(value = "admin/editSubject")
	public ModelAndView editSubject(@ModelAttribute SubjectVO subjectVO, @RequestParam int id) {

		

		return new ModelAndView("admin/editSubject", "SubjectVO", subjectVO);
	}

	@GetMapping(value = "faculty/viewSubject")
	public ModelAndView facultyViewSubject(@RequestParam(required = false) Integer degreeId,
			@RequestParam(required = false) Integer semesterId) {

		



		return new ModelAndView("faculty/viewSubject");
	}

}
