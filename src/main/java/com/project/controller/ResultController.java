package com.project.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.DegreeVO;
import com.project.model.FacultyVO;
import com.project.model.ResultDetailsVO;
import com.project.model.ResultVO;
import com.project.model.SemesterVO;
import com.project.model.SubjectVO;
import com.project.service.DegreeService;
import com.project.service.FacultyService;
import com.project.service.ResultService;
import com.project.service.SemesterService;
import com.project.service.SubjectService;
import com.project.utils.BaseMethods;

@Controller
public class ResultController {

	@Autowired
	private DegreeService degreeService;

	@Autowired
	private SemesterService semesterService;

	@Autowired
	private ResultService resultService;

	@Autowired
	private SubjectService subjectService;

	@Autowired
	private BaseMethods baseMethods;

	@Autowired
	private FacultyService facultyService;

	@GetMapping(value = "faculty/getSemesterOfExam")
	public ResponseEntity getSemesterOfExam(String examId) {
		SemesterVO semester = this.resultService.getSemesterOfExam(examId);
		return new ResponseEntity(semester, HttpStatus.OK);
	}

	@GetMapping(value = "faculty/lockResult")
	public ResponseEntity lockResult(String resultId, ResultVO resultVO) {
		resultVO.setId(Integer.parseInt(resultId));
		List<ResultVO> ls = this.resultService.findById(resultVO);
		ResultVO resultVO2 = ls.get(0);
		resultVO2.setLockedByFaculty(true);
		this.resultService.saveResult(resultVO2);
		return new ResponseEntity(HttpStatus.OK);
	}

	@GetMapping(value = "admin/lockResult")
	public ResponseEntity lockResult1(String exam, int degree, int semester) {

		DegreeVO degreeVO = new DegreeVO();
		degreeVO.setId(degree);

		SemesterVO semesterVO = new SemesterVO();
		semesterVO.setId(semester);

		ResultVO resultVO = new ResultVO();
		resultVO.setDegree(degreeVO);
		resultVO.setExam(exam);
		resultVO.setSemester(semesterVO);

		List<ResultVO> ls = this.resultService.findResults(resultVO);

		System.out.println(ls.size());
		
		for (ResultVO resultVO2 : ls) {

			if (resultVO2.isLockedByFaculty()) {
				resultVO2.setLockedByAdmin(true);
			}

			this.resultService.saveResult(resultVO2);
		}

		return new ResponseEntity(ls, HttpStatus.OK);
	}

	@GetMapping(value = "faculty/updateStudentMark")
	public ResponseEntity updateStudentMark(String resultId, String marks) {
		ResultDetailsVO detailsVO = this.resultService.getResultById(resultId);
		detailsVO.setObtainedMarks(marks);
		this.resultService.saveResultDetails(detailsVO);
		return new ResponseEntity(HttpStatus.OK);
	}

	@GetMapping(value = "faculty/addResult")
	public ModelAndView addResult() {
		List<DegreeVO> degreelist1 = degreeService.getDegree();
		List<SemesterVO> semesterlist1 = semesterService.getSemester();
		List<SubjectVO> subjectlist1 = subjectService.getSubject();

		System.out.println(degreelist1.size());
		return new ModelAndView("faculty/addResult", "ResultVO", new ResultVO()).addObject("degreelist", degreelist1)
				.addObject("semesterlist", semesterlist1).addObject("subjectlist", subjectlist1)
				.addObject("type", "Add ").addObject("button", "Add ");
	}

	@RequestMapping(value = "user/result", method = RequestMethod.GET)
	public ModelAndView userResult() {
		List<DegreeVO> degreelist1 = degreeService.getDegree();
		return new ModelAndView("user/result").addObject("degreelist", degreelist1);
	}

	@PostMapping(value = "faculty/saveResult")
	public ModelAndView saveResult(@ModelAttribute ResultVO resultVO, FacultyVO facultyVO) {

		String userName = this.baseMethods.getUsername();
		List<FacultyVO> facultyList = this.facultyService.findByUserName(userName);

		facultyVO = facultyList.get(0);
		resultVO.setFacultyVO(facultyVO);
		this.resultService.saveResult(resultVO);

		List<ResultDetailsVO> resultDetailsList = resultVO.getResultDetailsList();

		for (ResultDetailsVO resultDetailsVO : resultDetailsList) {

			resultDetailsVO.setResultVO(resultVO);

			this.resultService.saveResultDetails(resultDetailsVO);
		}

		this.resultService.saveResult(resultVO);
		return new ModelAndView("redirect:/faculty/addResult");
	}

	@GetMapping(value = "user/getStudentResult")
	public ResponseEntity getStudentResult(@RequestParam int degreeId, @RequestParam int semesterId,
			@RequestParam String examTypeId) {
		List<ResultDetailsVO> resultList = this.resultService.getResultDetails(semesterId, 0, degreeId,
				baseMethods.getUsername(), examTypeId, "student");
		return new ResponseEntity(resultList, HttpStatus.OK);
	}

	@GetMapping(value = "faculty/getFacultyResult")
	public ResponseEntity getFacultyResult(@RequestParam int degreeId, @RequestParam int semesterId,
			@RequestParam int subjectId, @RequestParam String examTypeId) {
		List resultList = this.resultService.getResultDetails(semesterId, subjectId, degreeId,
				baseMethods.getUsername(), examTypeId, "faculty");
		return new ResponseEntity(resultList, HttpStatus.OK);
	}

	@GetMapping(value = "admin/getFacultyResult")
	public ResponseEntity getAdminFacultyResult(@RequestParam int degreeId, @RequestParam int semesterId,
			@RequestParam String examTypeId) {
		List<ResultDetailsVO> resultList = this.resultService.getResultDetails(semesterId, 0, degreeId,
				baseMethods.getUsername(), examTypeId, "");

		Map<Integer, List<ResultDetailsVO>> map = new HashMap();

		for (ResultDetailsVO detailsVO : resultList) {

			List<ResultDetailsVO> ls = map.get(detailsVO.getStudentVO().getId());

			if (ls != null && !ls.isEmpty()) {
				ls.add(detailsVO);
				map.put(detailsVO.getStudentVO().getId(), ls);
			} else {
				List lists = new ArrayList<ResultDetailsVO>();
				lists.add(detailsVO);
				map.put(detailsVO.getStudentVO().getId(), lists);
			}

		}
		return new ResponseEntity(map, HttpStatus.OK);
	}

	@GetMapping(value = "faculty/viewResult")
	public ModelAndView viewResult() {
		List<DegreeVO> degreelist1 = degreeService.getDegree();
		return new ModelAndView("faculty/viewResult", "degreelist", degreelist1);
	}

	@GetMapping(value = "admin/viewResult")
	public ModelAndView viewResultAdmin() {
		List<DegreeVO> degreelist1 = degreeService.getDegree();
		return new ModelAndView("admin/viewResult", "degreelist", degreelist1);
	}

	@GetMapping(value = "faculty/deleteResult")
	public ModelAndView deleteResult(@ModelAttribute ResultVO resultVO, @RequestParam int id,
			HttpServletRequest request) {

		List<ResultVO> resultList = this.resultService.findById(resultVO);
		resultVO = resultList.get(0);

		this.resultService.deleteResult(resultVO);

		return new ModelAndView("redirect:/faculty/viewResult");
	}

	@GetMapping(value = "faculty/editResult")
	public ModelAndView editResult(@ModelAttribute ResultVO resultVO, @RequestParam int id,
			HttpServletRequest request) {

		List<ResultVO> resultList = this.resultService.findById(resultVO);
		resultVO = resultList.get(0);

		List<DegreeVO> degreelist = degreeService.getDegree();
		List<SemesterVO> semesterlist = semesterService.getSemester();
		List<SubjectVO> subjectlist1 = subjectService.getSubject();

		System.out.println(degreelist.size());

		return new ModelAndView("faculty/addResult", "ResultVO", resultVO).addObject("degreelist", degreelist)
				.addObject("semesterlist", semesterlist).addObject("subjectlist", subjectlist1)
				.addObject("type", "Edit ").addObject("button", "Update ");
	}

}
