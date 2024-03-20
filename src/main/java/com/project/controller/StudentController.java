package com.project.controller;



import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;

import com.project.model.StudentVO;


@Controller
public class StudentController {

	

	@GetMapping(value = "admin/addStudent")
	public ModelAndView addStudent() {
		
		return new ModelAndView("admin/addStudent", "StudentVO", new StudentVO());
	}

	@GetMapping(value = "faculty/addStudent")
	public ModelAndView facultyAddStudent() {

		
		return new ModelAndView("faculty/addStudent", "StudentVO", new StudentVO());
	}

	@PostMapping(value = "admin/saveStudent")
	public ModelAndView saveStudent() {

		
		return new ModelAndView("redirect:/admin/viewStudent");
	}

	@PostMapping(value = "faculty/saveStudent")
	public ModelAndView facultysaveStudent() {
		

		return new ModelAndView("faculty/addStudent", "StudentVO", new StudentVO());
	}

	@GetMapping(value = "admin/viewStudent")
	public ModelAndView viewStudent() {
		
		return new ModelAndView("admin/viewStudent");
	}

	@GetMapping(value = "faculty/viewStudent")
	public ModelAndView facultyViewStudent() {


		return new ModelAndView("faculty/viewStudent");
	}

	@GetMapping(value = "admin/deleteStudent")
	public ModelAndView deleteStudent() {

		return new ModelAndView("redirect:/admin/viewStudent");
	}

	@GetMapping(value = "admin/editStudent")
	public ModelAndView editStudent() {

		return new ModelAndView("admin/addStudent");
	}

	
}
