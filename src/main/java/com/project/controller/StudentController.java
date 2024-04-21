package com.project.controller;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

import com.project.model.DegreeVO;
import com.project.model.LoginVO;
import com.project.model.SemesterVO;
import com.project.model.StudentVO;
import com.project.service.DegreeService;
import com.project.service.LoginService;
import com.project.service.SemesterService;
import com.project.service.StudentService;
import com.project.utils.BaseMethods;


@Controller
public class StudentController {


	@Autowired
	private DegreeService degreeService;

	@Autowired
	private SemesterService semesterService;

	@Autowired
	private StudentService studentService;

	@Autowired
	private LoginService loginService;

	@Autowired
	private BaseMethods baseMethods;

	@GetMapping(value = "admin/addStudent")
	public ModelAndView addStudent() {
		List<DegreeVO> degreelist1 = degreeService.getDegree();
		List<SemesterVO> semesterlist1 = semesterService.getSemester();
		return new ModelAndView("admin/addStudent", "StudentVO", new StudentVO()).addObject("degreelist", degreelist1)
				.addObject("semesterlist", semesterlist1).addObject("type", "Add ").addObject("button", "Add ");
	}

	@GetMapping(value = "admin/verifyErNo")
	public ResponseEntity verifyEmail(String erNo) {
		boolean status = this.studentService.getByErNo(erNo);
		return new ResponseEntity(status, HttpStatus.OK);
	}

	@GetMapping(value = "admin/getSemesterOfStudent")
	public ResponseEntity getSemesterOfStudent(String studentId) {
		SemesterVO semester = this.studentService.getSemesterOfStudent(studentId);
		return new ResponseEntity(semester, HttpStatus.OK);
	}

	

	@PostMapping(value = "admin/saveStudent")
	public ModelAndView saveStudent(@ModelAttribute StudentVO studentVO) {

		LoginVO loginVO = studentVO.getLoginVO();

		if (loginVO.getId() == null) {
			boolean isEmailExists = this.loginService.getByEmailId(loginVO.getUsername());

			if (!isEmailExists) {
				loginVO.setEnabled("1");
				loginVO.setRole("ROLE_STUDENT");

				String firstName = studentVO.getFirstName();
				String lastName = studentVO.getLastName();
				String username = loginVO.getUsername();

				String password = this.baseMethods.generatePassword();
				String messageBody = this.baseMethods.generateMailBody(firstName + " " + lastName, "student", username,
						password);

				this.baseMethods.sendMail("CMS : Credentials", messageBody, username);
				loginVO.setPassword(password);
				this.loginService.save(loginVO);
				this.studentService.saveStudent(studentVO);

			}
		} else {
			List<LoginVO> loginList = this.loginService.getById(loginVO);
			loginVO = loginList.get(0);
			this.loginService.save(loginVO);
			this.studentService.saveStudent(studentVO);

		}

		return new ModelAndView("redirect:/admin/viewStudent");
	}

	

	@GetMapping(value = "admin/viewStudent")
	public ModelAndView viewStudent() {
		List<StudentVO> studentList = this.studentService.getStudent();
		// List<DegreeVO> degreeList = this.degreeService.getDegree();
		return new ModelAndView("admin/viewStudent", "studentList", studentList);
	}

	
	@GetMapping(value = "admin/deleteStudent")
	public ModelAndView deleteStudent(@ModelAttribute StudentVO studentVO, @RequestParam int id,
			@RequestParam int loginId, LoginVO loginVO) {

		loginVO.setId(loginId);

		List<LoginVO> loginList = this.loginService.getById(loginVO);
		List<StudentVO> studentList = this.studentService.findById(studentVO);

		loginVO = loginList.get(0);
		loginVO.setEnabled("0");

		studentVO = studentList.get(0);
		studentVO.setStatus(false);

		this.loginService.save(loginVO);
		this.studentService.saveStudent(studentVO);

		return new ModelAndView("redirect:/admin/viewStudent");
	}

	@GetMapping(value = "admin/editStudent")
	public ModelAndView editStudent(@ModelAttribute StudentVO studentVO, @RequestParam int id) {

		List<DegreeVO> degreelist1 = degreeService.getDegree();
		List<SemesterVO> semesterlist1 = semesterService.getSemester();
		List<StudentVO> studentList = this.studentService.findById(studentVO);

		studentVO = studentList.get(0);

		return new ModelAndView("admin/addStudent", "StudentVO", studentVO).addObject("degreelist", degreelist1)
				.addObject("semesterlist", semesterlist1).addObject("type", "Edit ").addObject("button", "Update");
	}

	
}
