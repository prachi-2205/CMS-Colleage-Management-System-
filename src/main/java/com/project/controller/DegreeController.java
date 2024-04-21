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
import com.project.service.SemesterService;
import com.project.service.SubjectService;


@Controller
public class DegreeController {


	@Autowired
	private DegreeService degreeService;

	@Autowired
	private SubjectService subjectService;

	@Autowired
	private SemesterService semesterService;

	@GetMapping(value = "admin/addDegree")
	public ModelAndView addDegree() {
		return new ModelAndView("admin/addDegree", "DegreeVO", new DegreeVO()).addObject("type", "Add ")
				.addObject("button", "Add ");
	}

	@PostMapping(value = "admin/saveDegree")
	public ModelAndView saveDegree(@ModelAttribute DegreeVO degreeVO) {
		this.degreeService.saveDegree(degreeVO);
		return new ModelAndView("redirect:/admin/viewDegree");
	}

	@GetMapping(value = "admin/viewDegree")
	public ModelAndView viewDegree() {
		List<DegreeVO> degreeList = this.degreeService.getDegree();
		return new ModelAndView("admin/viewDegree", "degreeList", degreeList);
	}

	@GetMapping(value = "user/viewCourses")
	public ModelAndView viewUserDegree() {
		List<DegreeVO> degreeList = this.degreeService.getDegree();
		return new ModelAndView("user/viewCourse", "degreeList", degreeList);
	}

	@GetMapping(value = "user/viewCourseDetails")
	public ModelAndView viewCourseDetails(@ModelAttribute DegreeVO degreeVO, @RequestParam int id) {
		degreeVO.setId(id);
		List<DegreeVO> degreeList = this.degreeService.findById(degreeVO);
		List<SubjectVO> subjectList = this.subjectService.findByDegreeId(id);
		List<SemesterVO> semesterList = this.semesterService.findByDegree(degreeVO);
		
		System.out.println(subjectList.size());
		System.out.println(semesterList.size());
		
		return new ModelAndView("user/viewCourseDetails", "degreeVO", degreeList.get(0))
				.addObject("subjectList", subjectList).addObject("semesterList", semesterList);
	}

	@GetMapping(value = "admin/deleteDegree")
	public ModelAndView deleteDegree(@ModelAttribute DegreeVO degreeVO, @RequestParam int id) {

		List<DegreeVO> degreeList = this.degreeService.findById(degreeVO);

		degreeVO = degreeList.get(0);
		degreeVO.setStatus(false);

		this.degreeService.saveDegree(degreeVO);

		return new ModelAndView("redirect:/admin/viewDegree");
	}

	@GetMapping(value = "admin/editDegree")
	public ModelAndView editDegree(@ModelAttribute DegreeVO degreeVO, @RequestParam int id) {
		List<DegreeVO> degreeList = this.degreeService.findById(degreeVO);
		degreeVO = degreeList.get(0);
		return new ModelAndView("admin/addDegree", "DegreeVO", degreeVO).addObject("type", "Edit ").addObject("button",
				"Update ");
	}

}
