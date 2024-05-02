package com.project.controller;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.DegreeVO;
import com.project.model.SemesterVO;
import com.project.model.SubjectVO;
import com.project.service.DegreeService;
import com.project.service.SemesterService;
import com.project.service.SubjectService;

@Controller
public class SubjectController {

	@Autowired
	private DegreeService degreeService;

	@Autowired
	private SemesterService semesterService;

	@Autowired
	private SubjectService subjectService;

	@RequestMapping(value = "/user/sub", method = RequestMethod.GET)
	public ModelAndView sub() {
		return new ModelAndView("user/blog-list");
	}

	@GetMapping(value = "admin/getSemesterOfSubject")
	public ResponseEntity getSemesterOfSubject(String subjectId) {
		SemesterVO semester = this.subjectService.getSemesterOfSubject(subjectId);
		return new ResponseEntity(semester, HttpStatus.OK);
	}

	@GetMapping(value = "admin/addSubject")
	public ModelAndView addSubject() {
		List<DegreeVO> degreelist1 = degreeService.getDegree();
		List<SemesterVO> semesterlist1 = semesterService.getSemester();
		return new ModelAndView("admin/addSubject", "SubjectVO", new SubjectVO()).addObject("degreelist", degreelist1)
				.addObject("semesterlist", semesterlist1).addObject("type", "Add ").addObject("button", "Add ");
	}

	@PostMapping(value = "admin/saveSubject")
	public ModelAndView saveSubject(@ModelAttribute SubjectVO subjectVO, HttpServletRequest request) {

		String[] subCode = request.getParameterValues("subCode");
		String[] subName = request.getParameterValues("subName");
		String[] subCredit = request.getParameterValues("subCredit");

		for (int i = 0; i < subCode.length; i++) {

			System.out.println(subName);
			
			SubjectVO subjectVO2 = new SubjectVO();
			subjectVO2.setDegree(subjectVO.getDegree());
			subjectVO2.setSemester(subjectVO.getSemester());
			subjectVO2.setSubjectCode(subCode[i]);
			subjectVO2.setSubjectCredit(subCredit[i]);
			subjectVO2.setSubjectName(subName[i]);

			this.subjectService.saveSubject(subjectVO2);
		}

		return new ModelAndView("redirect:/admin/viewSubject");
	}

	@PostMapping(value = "admin/updateSubject")
	public ModelAndView updateSubject(@ModelAttribute SubjectVO subjectVO) {
		this.subjectService.saveSubject(subjectVO);
		return new ModelAndView("redirect:/admin/viewSubject");
	}

	@GetMapping(value = "admin/viewSubject")
	public ModelAndView viewSubject() {
		List<SubjectVO> subjectList = this.subjectService.getSubject();
		return new ModelAndView("admin/viewSubject", "subjectList", subjectList);
	}

	@GetMapping(value = "admin/deleteSubject")
	public ModelAndView deleteSubject(@ModelAttribute SubjectVO subjectVO, @RequestParam int id) {

		List<SubjectVO> subjectList = this.subjectService.findById(subjectVO);

		subjectVO = subjectList.get(0);
		subjectVO.setStatus(false);

		this.subjectService.saveSubject(subjectVO);

		return new ModelAndView("redirect:/admin/viewSubject");
	}

	@GetMapping(value = "admin/editSubject")
	public ModelAndView editSubject(@ModelAttribute SubjectVO subjectVO, @RequestParam int id) {

		List<DegreeVO> degreelist1 = degreeService.getDegree();
		List<SemesterVO> semesterlist1 = semesterService.getSemester();
		List<SubjectVO> subjectList = this.subjectService.findById(subjectVO);

		subjectVO = subjectList.get(0);

		return new ModelAndView("admin/editSubject", "SubjectVO", subjectVO).addObject("degreelist", degreelist1)
				.addObject("semesterlist", semesterlist1).addObject("type", "Edit ").addObject("button", "Update ");
	}

	@GetMapping(value = "faculty/viewSubject")
	public ModelAndView facultyViewSubject(@RequestParam(required = false) Integer degreeId,
			@RequestParam(required = false) Integer semesterId) {

		List<DegreeVO> degreeList = this.degreeService.getDegree();

		ModelMap map = new ModelMap();

		if (degreeId != null && semesterId != null) {

			map.addAttribute("degreeId", degreeId);
			map.addAttribute("semesterId", semesterId);

		} else {

			DegreeVO degreeVO = degreeList.get(0);
			degreeId = degreeVO.getId();

			List<SemesterVO> semesterList = this.semesterService.findByDegree(degreeVO);
			SemesterVO semesterVO = semesterList.get(0);

			semesterId = semesterVO.getId();
		}

		List<SubjectVO> subjectList = this.subjectService.findByDegreeAndSemesterId(degreeId, semesterId);

		System.out.println(subjectList.size());

		return new ModelAndView("faculty/viewSubject", "subjectList", subjectList).addObject("degreeList", degreeList)
				.addObject(map);
	}

}
