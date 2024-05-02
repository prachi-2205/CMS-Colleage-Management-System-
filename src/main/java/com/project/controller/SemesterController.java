package com.project.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.SemesterVO;
import com.project.service.SemesterService;
import com.project.model.DegreeVO;
import com.project.service.DegreeService;

@Controller
public class SemesterController {

	@Autowired
	private DegreeService degreeService;

	@Autowired
	private SemesterService semesterService;

	@GetMapping(value = "admin/addSemester")
	public ModelAndView addSemester() {
		List<DegreeVO> degreelist1 = degreeService.getDegree();
		return new ModelAndView("admin/addSemester", "SemesterVO", new SemesterVO())
				.addObject("degreelist", degreelist1).addObject("type", "Add ").addObject("button", "Add ");
	}

	@PostMapping(value = "admin/saveSemester")
	public ModelAndView saveSemester(@ModelAttribute SemesterVO semesterVO, HttpServletRequest request) {

		String[] semTime = request.getParameterValues("semTime");
		String[] semNo = request.getParameterValues("semNo");

		for (int i = 0; i < semTime.length; i++) {
			SemesterVO semesterVO2 = new SemesterVO();
			semesterVO2.setDegree(semesterVO.getDegree());
			semesterVO2.setSemesterNo(semNo[i]);
			semesterVO2.setSemesterTime(semTime[i]);
			this.semesterService.saveSemester(semesterVO2);
		}

		return new ModelAndView("redirect:/admin/viewSemester");
	}

	@PostMapping(value = "admin/updateSemester")
	public ModelAndView updateSemester(@ModelAttribute SemesterVO semesterVO) {
		this.semesterService.saveSemester(semesterVO);
		return new ModelAndView("redirect:/admin/viewSemester");

	}

	@GetMapping(value = "admin/viewSemester")
	public ModelAndView viewSemester() {
		List<SemesterVO> semesterList = this.semesterService.getSemester();
		return new ModelAndView("admin/viewSemester", "semesterList", semesterList);
	}

	@GetMapping(value = "admin/deleteSemester")
	public ModelAndView deleteSemester(@ModelAttribute SemesterVO semesterVO, @RequestParam int id) {

		List<SemesterVO> semesterList = this.semesterService.findById(semesterVO);

		semesterVO = semesterList.get(0);
		semesterVO.setStatus(false);

		this.semesterService.saveSemester(semesterVO);

		return new ModelAndView("redirect:/admin/viewSemester");
	}

	@GetMapping(value = "admin/editSemester")
	public ModelAndView editSemester(@ModelAttribute SemesterVO semesterVO, @RequestParam int id) {

		List<DegreeVO> degreelist1 = degreeService.getDegree();
		List<SemesterVO> semesterList = this.semesterService.findById(semesterVO);

		semesterVO = semesterList.get(0);

		return new ModelAndView("admin/editSemester", "SemesterVO", semesterVO).addObject("degreelist", degreelist1)
				.addObject("type", "Edit ").addObject("button", "Update ");
	}

	@GetMapping(value = { "admin/getSemesterByDegree", "faculty/getSemesterByDegree", "user/getSemesterByDegree" })
	public ResponseEntity<Object> getSemesterByDegree(@RequestParam int degreeId, DegreeVO degreeVO) {
		degreeVO.setId(degreeId);
		List<SemesterVO> semesterList = this.semesterService.findByDegree(degreeVO);
		return new ResponseEntity<Object>(semesterList, HttpStatus.OK);
	}
}
