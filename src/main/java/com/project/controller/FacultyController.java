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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.AcademicVO;
import com.project.model.DegreeVO;
import com.project.model.ExamVO;
import com.project.model.FacultyVO;
import com.project.model.LoginVO;
import com.project.model.SemesterVO;
import com.project.service.FacultyService;
import com.project.service.LoginService;
import com.project.utils.BaseMethods;

@Controller
public class FacultyController {

	@Autowired
	private FacultyService facultyService;

	@Autowired
	private LoginService loginService;

	@Autowired
	private BaseMethods baseMethods;
	
	

	@GetMapping(value = "admin/addFaculty")
	public ModelAndView addFaculty() {
		return new ModelAndView("admin/addFaculty", "FacultyVO", new FacultyVO()).addObject("type", "Add ")
				.addObject("button", "Add ");
	}

	@GetMapping(value = "admin/verifyEmail")
	public ResponseEntity verifyEmail(String email) {
		boolean status = this.loginService.getByEmailId(email);
		return new ResponseEntity(status, HttpStatus.OK);
	}

	@PostMapping(value = "admin/saveFaculty")
	public ModelAndView saveFaculty(@ModelAttribute FacultyVO facultyVO, @RequestParam MultipartFile file,
			HttpServletRequest request) {

		LoginVO loginVO = facultyVO.getLoginVO();

		if (loginVO.getId() == null) {

			loginVO.setEnabled("1");
			loginVO.setRole("ROLE_FACULTY");

			String firstName = facultyVO.getFirstName();
			String lastName = facultyVO.getLastName();
			String username = loginVO.getUsername();

			String password = this.baseMethods.generatePassword();
			String messageBody = this.baseMethods.generateMailBody(firstName + " " + lastName, "faculty", username,
					password);
			this.baseMethods.sendMail("CMS : Credentials", messageBody, username);
			loginVO.setPassword(password);

		} else {
			List<LoginVO> loginList = this.loginService.getById(loginVO);
			loginVO = loginList.get(0);
		}
		
	
		if (facultyVO.getId() != null && facultyVO.getId() > 0) {
			List<FacultyVO> facultyList = this.facultyService.findById(facultyVO);
			FacultyVO facultyVO2 = facultyList.get(0);
			
			
			if(file.isEmpty()){
				
				facultyVO.setFileName(facultyVO2.getFileName());
				facultyVO.setFilePath(facultyVO2.getFilePath());
			}else{
			
	
			String path = request.getSession().getServletContext().getRealPath("/");
			String filePath = path + "documents\\faculty\\";

			File f = new File(filePath + facultyVO2.getFileName());
			f.delete();
			// Save File
			
			String fileName = file.getOriginalFilename();
			try {
				byte barr[] = file.getBytes();

				BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(filePath + "/" + fileName));

				bout.write(barr);
				bout.flush();
				bout.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			facultyVO.setFileName(fileName);
			facultyVO.setFilePath(filePath);
			}
		}else{

		String path = request.getSession().getServletContext().getRealPath("/");

		String fileName = file.getOriginalFilename();

		String filePath = path + "documents\\faculty\\";

		try {
			byte barr[] = file.getBytes();

			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(filePath + "/" + fileName));

			bout.write(barr);
			bout.flush();
			bout.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		facultyVO.setFileName(fileName);
		facultyVO.setFilePath(filePath);
		}
		
		this.loginService.save(loginVO);

		facultyVO.setLoginVO(loginVO);
		this.facultyService.saveFaculty(facultyVO);
		return new ModelAndView("redirect:/admin/viewFaculty");
	}

	@GetMapping(value = "admin/viewFaculty")
	public ModelAndView viewFaculty() {
		List<FacultyVO> facultyList = this.facultyService.getFaculty();
		return new ModelAndView("admin/viewFaculty", "facultyList", facultyList);
	}
	
	@GetMapping(value = "user/teacher")
	public ModelAndView viewTeacher() {
		List<FacultyVO> facultyList = this.facultyService.getFaculty();
		return new ModelAndView("user/teacher", "facultyList", facultyList);
	}
	
	

	@GetMapping(value = "admin/deleteFaculty")
	public ModelAndView deleteFaculty(@ModelAttribute FacultyVO facultyVO, @RequestParam int id,
			@RequestParam int loginId, LoginVO loginVO) {

		loginVO.setId(loginId);

		List<FacultyVO> facultyList = this.facultyService.findById(facultyVO);
		List<LoginVO> loginList = this.loginService.getById(loginVO);

		loginVO = loginList.get(0);
		loginVO.setEnabled("0");

		facultyVO = facultyList.get(0);
		facultyVO.setStatus(false);

		this.loginService.save(loginVO);
		this.facultyService.saveFaculty(facultyVO);

		return new ModelAndView("redirect:/admin/viewFaculty");
	}

	@GetMapping(value = "user/teacher-profile")
	public ModelAndView teacherprofile(@ModelAttribute FacultyVO facultyVO, @RequestParam int id) {

		List<FacultyVO> facultyList = this.facultyService.findById(facultyVO);

		facultyVO = facultyList.get(0);

		return new ModelAndView("user/teacherProfile", "facultyVO", facultyVO);
	}
	
	@GetMapping(value = "admin/editFaculty")
	public ModelAndView editFaculty(@ModelAttribute FacultyVO facultyVO, @RequestParam int id) {

		List<FacultyVO> facultyList = this.facultyService.findById(facultyVO);
		facultyVO = facultyList.get(0);

		return new ModelAndView("admin/addFaculty", "FacultyVO", facultyVO).addObject("type", "Edit ")
				.addObject("button", "Update ");
	}
}
