package com.project.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;


import com.project.model.FormVO;



@Controller
public class FormController {

	

	@GetMapping(value = "user/form")
	public ModelAndView userForm() {
		
		return new ModelAndView("user/form");
	}
	
	
	@GetMapping(value = "admin/addForm")
	public ModelAndView addForm() {
		return new ModelAndView("admin/addForm", "FormVO", new FormVO());
	} 
		
	@PostMapping(value = "admin/saveForm")
	public ModelAndView saveForm() {

		return new ModelAndView("redirect:/admin/viewForm");
	
	}
	@GetMapping(value = "admin/viewForm")
	public ModelAndView viewForm() {
		
		return new ModelAndView("admin/viewForm");
	}
	
	@GetMapping(value = "admin/editForm")
	public ModelAndView editForm() {

		

		return new ModelAndView("admin/addForm");
	}
	
	@GetMapping(value = "admin/deleteForm")
	public ModelAndView deleteForm() {

		         

		return new ModelAndView("redirect:/admin/viewForm");
	}
}
