package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;

import com.project.model.FacultyVO;

import com.project.service.LoginService;
import com.project.utils.BaseMethods;

@Controller
public class FacultyController {

	@Autowired
	private LoginService loginService;

	@Autowired
	private BaseMethods baseMethods;

	@GetMapping(value = "admin/addFaculty")
	public ModelAndView addFaculty() {
		return new ModelAndView("admin/addFaculty", "FacultyVO", new FacultyVO());
	}

	@PostMapping(value = "admin/saveFaculty")
	public ModelAndView saveFaculty() {
		return new ModelAndView("redirect:/admin/viewFaculty");
	}

	@GetMapping(value = "admin/viewFaculty")
	public ModelAndView viewFaculty() {
		return new ModelAndView("admin/viewFaculty");
	}

	@GetMapping(value = "user/teacher")
	public ModelAndView viewTeacher() {
		return new ModelAndView("user/teacher");
	}

	@GetMapping(value = "admin/deleteFaculty")
	public ModelAndView deleteFaculty() {

		return new ModelAndView("redirect:/admin/viewFaculty");
	}

	@GetMapping(value = "user/teacher-profile")
	public ModelAndView teacherprofile() {

		return new ModelAndView("user/teacherProfile");
	}

	@GetMapping(value = "admin/editFaculty")
	public ModelAndView editFaculty() {

		return new ModelAndView("admin/addFaculty");
	}
}
