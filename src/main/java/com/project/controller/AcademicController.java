package com.project.controller;

import java.io.BufferedOutputStream;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.AcademicVO;
import com.project.model.DegreeVO;
import com.project.model.SemesterVO;


@Controller
public class AcademicController {


	
	@GetMapping(value = "user/academic")
	public ModelAndView userAcademic() {
		
		return new ModelAndView("user/academic", "AcademicVO", new AcademicVO());
	}
	
	@GetMapping(value = "user/userViewAcademic")
	public ModelAndView userViewAcademic() {

	
		return new ModelAndView("user/academic");
	}
	
	
	@PostMapping(value = "user/saveUserAcademic")
	public ModelAndView saveUserAcademic() {

		return new ModelAndView("redirect:/user/academic");
	}
	
	
//	@SuppressWarnings({ "rawtypes", "unchecked" })
//	@GetMapping(value = "admin/getSemesterOfAcademic")
//	public ResponseEntity getSemesterOfAcademic(String academicId) {
//		
//		return new ResponseEntity(semester,HttpStatus.OK);
//	}

	@GetMapping(value = "admin/addAcademic")
	public ModelAndView addAcademic() {
		
		return new ModelAndView("admin/addAcademic", "AcademicVO", new AcademicVO());
	}

	@PostMapping(value = "admin/saveAcademic")
	public ModelAndView saveAcademic() {

		
		return new ModelAndView("redirect:/admin/viewAcademic");
	}

	@GetMapping(value = "admin/viewAcademic")
	public ModelAndView viewAcademic() {
		
		return new ModelAndView("admin/viewAcademic");
	}

	@GetMapping(value = "admin/editAcademic")
	public ModelAndView editAcademic() {

		
		return new ModelAndView("admin/addAcademic");
	}

	@GetMapping(value = "admin/deleteAcademic")
	public ModelAndView deleteAcademic() {

		

		return new ModelAndView("redirect:/admin/viewAcademic");
	}
}
