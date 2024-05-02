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

	@GetMapping(value = "faculty/addStudent")
	public ModelAndView facultyAddStudent() {

		List<DegreeVO> degreelist1 = degreeService.getDegree();
		List<SemesterVO> semesterlist1 = semesterService.getSemester();

		return new ModelAndView("faculty/addStudent", "StudentVO", new StudentVO()).addObject("degreelist", degreelist1)
				.addObject("semesterlist", semesterlist1).addObject("type", "Add ");
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

	@PostMapping(value = "faculty/saveStudent")
	public ModelAndView facultysaveStudent(@RequestParam MultipartFile file, @ModelAttribute StudentVO studentVO) {
		List<String> studentList = new ArrayList<String>();

		int degreeId = studentVO.getDegree().getId();
		int semesterId = studentVO.getSemester().getId();

		try {
			XSSFWorkbook wb = new XSSFWorkbook(file.getInputStream());
			Sheet sheet = wb.getSheetAt(0);

			Iterator<Row> iterator = sheet.iterator();

			while (iterator.hasNext()) {
				Row row = iterator.next();

				boolean isEmailExists = false;
				boolean isErnoExists = false;

				LoginVO loginVO = new LoginVO();
				StudentVO studentVO2 = new StudentVO();

				if (row.getRowNum() > 0) {
					Iterator<Cell> cells = row.iterator();

					while (cells.hasNext()) {
						Cell cell = cells.next();

						if (cell.getColumnIndex() == 4) {
							isEmailExists = this.loginService.getByEmailId(cell.getStringCellValue());
							if (isEmailExists) {
								studentList.add("<span style='color:red;'>" + cell.getStringCellValue()
										+ "</span> email already exists.");
							}

						}

						if (cell.getColumnIndex() == 6) {

							String erNo = "";

							if (cell.getCellType().toString().equals("NUMERIC")) {
								erNo = Double.toString(cell.getNumericCellValue());
							} else {
								erNo = cell.getStringCellValue();
							}

							StringTokenizer tokenizer = new StringTokenizer(erNo, ".");
							String enrollmentNumber = tokenizer.nextToken();
							isErnoExists = this.studentService.getByErNo(enrollmentNumber);
							if (isErnoExists) {
								studentList.add("<span style='color:red;'>" + enrollmentNumber
										+ "</span> enrollment number already exists.");
								continue;
							}

						}
						switch (cell.getColumnIndex()) {
						case 0:
							studentVO2.setFirstName(cell.getStringCellValue());
							break;
						case 1:
							studentVO2.setMiddleName(cell.getStringCellValue());
							break;
						case 2:
							studentVO2.setLastName(cell.getStringCellValue());
							break;
						case 3:
							if (cell.getCellType().toString().equals("NUMERIC")) {
								studentVO2.setPhoneNo(Double.toString(cell.getNumericCellValue()));
							} else {
								studentVO2.setPhoneNo(cell.getStringCellValue());
							}

							break;
						case 4:
							loginVO.setEnabled("1");
							loginVO.setRole("ROLE_STUDENT");
							loginVO.setUsername(cell.getStringCellValue());
							loginVO.setPassword(baseMethods.generatePassword());
							break;
						case 5:
							studentVO2.setGender(cell.getStringCellValue());
							break;
						case 6:
							String erNo;
							if (cell.getCellType().toString().equals("NUMERIC")) {
								erNo = Double.toString(cell.getNumericCellValue());
							} else {
								erNo = cell.getStringCellValue();
							}
							StringTokenizer tokenizer = new StringTokenizer(erNo, ".");
							String enrollmentNumber = tokenizer.nextToken();
							studentVO2.setEnrollmentNo(enrollmentNumber);
							break;
						case 7:
							studentVO2.setAddress(cell.getStringCellValue());
							break;
						default:
							break;
						}

					}

					if (isErnoExists || isEmailExists) {
						continue;
					}

					String messagetext = baseMethods.generateMailBody(
							studentVO2.getFirstName() + " " + studentVO2.getLastName(), "student",
							loginVO.getUsername(), loginVO.getPassword());

					// Send mail
					baseMethods.sendMail("CMS : Credentials", messagetext, loginVO.getUsername());

					this.loginService.save(loginVO);

					DegreeVO degreeVO = new DegreeVO();
					degreeVO.setId(degreeId);

					SemesterVO semesterVO = new SemesterVO();
					semesterVO.setId(semesterId);

					studentVO2.setDegree(degreeVO);
					studentVO2.setSemester(semesterVO);
					studentVO2.setLoginVO(loginVO);

					this.studentService.saveStudent(studentVO2);
				}
			}
			wb.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		List<DegreeVO> degreelist1 = degreeService.getDegree();
		List<SemesterVO> semesterlist1 = semesterService.getSemester();

		return new ModelAndView("faculty/addStudent", "StudentVO", new StudentVO()).addObject("degreelist", degreelist1)
				.addObject("semesterlist", semesterlist1).addObject("type", "Add ")
				.addObject("studentList", studentList);
	}

	@GetMapping(value = "admin/viewStudent")
	public ModelAndView viewStudent() {
		List<StudentVO> studentList = this.studentService.getStudent();
		// List<DegreeVO> degreeList = this.degreeService.getDegree();
		return new ModelAndView("admin/viewStudent", "studentList", studentList);
	}

	@GetMapping(value = "faculty/viewStudent")
	public ModelAndView facultyViewStudent(@RequestParam(required = false) Integer degreeId,
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

		List<StudentVO> studentList = this.studentService.getStudentByDegreeAndSemester(degreeId, semesterId);

		System.out.println(studentList.size());

		return new ModelAndView("faculty/viewStudent", "studentList", studentList).addObject("degreeList", degreeList)
				.addObject(map);
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

	@GetMapping(value = "faculty/getStudentByDegreeAndSemester")
	public ResponseEntity getStudentByDegreeAndSemester(@RequestParam int degreeId, @RequestParam int semesterId) {
		List<StudentVO> studentList = this.studentService.getStudentByDegreeAndSemester(degreeId, semesterId);
		return new ResponseEntity(studentList,HttpStatus.OK);
	}

}
