package com.project.controller;




import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.SemesterVO;


@Controller
public class SemesterController {



	@GetMapping(value = "admin/addSemester")
	public ModelAndView addSemester() {
		
		return new ModelAndView("admin/addSemester", "SemesterVO", new SemesterVO());
	}

	@PostMapping(value = "admin/saveSemester")
	public ModelAndView saveSemester() {

	
		return new ModelAndView("redirect:/admin/viewSemester");
	}

	@PostMapping(value = "admin/updateSemester")
	public ModelAndView updateSemester() {
		
		return new ModelAndView("redirect:/admin/viewSemester");

	}

	@GetMapping(value = "admin/viewSemester")
	public ModelAndView viewSemester() {
		
		return new ModelAndView("admin/viewSemester");
	}

	@GetMapping(value = "admin/deleteSemester")
	public ModelAndView deleteSemester() {

		

		return new ModelAndView("redirect:/admin/viewSemester");
	}

	@GetMapping(value = "admin/editSemester")
	public ModelAndView editSemester(@ModelAttribute SemesterVO semesterVO, @RequestParam int id) {

		

		return new ModelAndView("admin/editSemester", "SemesterVO", semesterVO);
	}

	
}
