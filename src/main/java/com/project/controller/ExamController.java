package com.project.controller;





import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;


import com.project.model.ExamVO;




@Controller
public class ExamController {

	

	@GetMapping(value = "user/exam")
	public ModelAndView userExam() {
		
		return new ModelAndView("user/exam", "ExamVO", new ExamVO());
	}

	@GetMapping(value = "user/userViewExam")
	public ModelAndView userViewExam() {

		

		return new ModelAndView("user/exam");
	}

	@PostMapping(value = "user/saveUserExam")
	public ModelAndView saveUserExam() {

		
		return new ModelAndView("redirect:/user/exam");
	}

	
	@GetMapping(value = "admin/addExam")
	public ModelAndView addExam() {
		
		return new ModelAndView("admin/addExam", "ExamVO", new ExamVO());
	}

	

	@PostMapping(value = "admin/saveExam")
	public ModelAndView saveExam() {

		
		return new ModelAndView("redirect:/admin/viewExam");
	}

	@GetMapping(value = "admin/viewExam")
	public ModelAndView viewExam() {
		
		return new ModelAndView("admin/viewExam");
	}

	@GetMapping(value = "admin/deleteExam")
	public ModelAndView deleteExam() {

		

		return new ModelAndView("redirect:/admin/viewExam");
	}

	@GetMapping(value = "admin/editExam")
	public ModelAndView editExam(@ModelAttribute ExamVO examVO, @RequestParam int id) {

	
		return new ModelAndView("admin/addExam", "ExamVO", examVO);
	}

}
