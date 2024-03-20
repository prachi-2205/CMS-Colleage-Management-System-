package com.project.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;


import com.project.model.FacultyVO;

import com.project.model.ResultVO;

import com.project.utils.BaseMethods;

@Controller
public class ResultController {

	

	@Autowired
	private BaseMethods baseMethods;

	@GetMapping(value = "faculty/addResult")
	public ModelAndView addResult() {
		
		return new ModelAndView("faculty/addResult", "ResultVO", new ResultVO());
	}

	@RequestMapping(value = "user/result", method = RequestMethod.GET)
	public ModelAndView userResult() {
		
		return new ModelAndView("user/result");
	}

	@PostMapping(value = "faculty/saveResult")
	public ModelAndView saveResult(@ModelAttribute ResultVO resultVO, FacultyVO facultyVO) {

		return new ModelAndView("redirect:/faculty/addResult");
	}

	@GetMapping(value = "faculty/viewResult")
	public ModelAndView viewResult() {
		
		return new ModelAndView("faculty/viewResult");
	}

	@GetMapping(value = "admin/viewResult")
	public ModelAndView viewResultAdmin() {
		return new ModelAndView("admin/viewResult");
	}

	@GetMapping(value = "faculty/deleteResult")
	public ModelAndView deleteResult() {
		return new ModelAndView("redirect:/faculty/viewResult");
	}

	@GetMapping(value = "faculty/editResult")
	public ModelAndView editResult() {
		return new ModelAndView("faculty/addResult");
	}

}
