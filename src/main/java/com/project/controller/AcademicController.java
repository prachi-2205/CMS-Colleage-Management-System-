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
import com.project.service.AcademicService;
import com.project.service.DegreeService;
import com.project.service.SemesterService;


@Controller
public class AcademicController {


	@Autowired
	private DegreeService degreeService;

	@Autowired
	private SemesterService semesterService;

	@Autowired
	private AcademicService academicService;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping(value = "admin/getSemesterOfAcademic")
	public ResponseEntity getSemesterOfAcademic(String academicId) {
		SemesterVO semester =this.academicService.getSemesterOfAcademic(academicId);
		return new ResponseEntity(semester,HttpStatus.OK);
	}

	@GetMapping(value = "admin/addAcademic")
	public ModelAndView addAcademic() {
		List<DegreeVO> degreelist = degreeService.getDegree();
		List<SemesterVO> semesterlist = semesterService.getSemester();
		return new ModelAndView("admin/addAcademic", "AcademicVO", new AcademicVO()).addObject("degreelist", degreelist)
				.addObject("semesterlist", semesterlist).addObject("type", "Add ").addObject("button", "Add ");
	}

	@PostMapping(value = "admin/saveAcademic")
	public ModelAndView saveAcademic(@ModelAttribute AcademicVO academicVO, @RequestParam MultipartFile file,
			HttpServletRequest request) {

		if (academicVO.getId() != null && academicVO.getId() > 0) {
			List<AcademicVO> academicList = this.academicService.findById(academicVO);
			AcademicVO academicVO2 = academicList.get(0);
			
			
			if(file.isEmpty()){
				
				academicVO.setFileName(academicVO2.getFileName());
				academicVO.setFilePath(academicVO2.getFilePath());
			}else{
			
	
			String path = request.getSession().getServletContext().getRealPath("/");
			String filePath = path + "documents\\academic\\";

			File f = new File(filePath + academicVO2.getFileName());
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
			
			academicVO.setFileName(fileName);
			academicVO.setFilePath(filePath);
			}
		}else{

		String path = request.getSession().getServletContext().getRealPath("/");

		String fileName = file.getOriginalFilename();

		String filePath = path + "documents\\academic\\";

		try {
			byte barr[] = file.getBytes();

			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(filePath + "/" + fileName));

			bout.write(barr);
			bout.flush();
			bout.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		academicVO.setFileName(fileName);
		academicVO.setFilePath(filePath);
		}
		this.academicService.saveAcademic(academicVO);
		return new ModelAndView("redirect:/admin/viewAcademic");
	}

	@GetMapping(value = "admin/viewAcademic")
	public ModelAndView viewAcademic() {
		List<AcademicVO> academicList = this.academicService.getAcademic();
		return new ModelAndView("admin/viewAcademic", "academicList", academicList);
	}

	@GetMapping(value = "admin/editAcademic")
	public ModelAndView editAcademic(@ModelAttribute AcademicVO academicVO, @RequestParam int id,
			HttpServletRequest request) {

		List<AcademicVO> academicList = this.academicService.findById(academicVO);
		academicVO = academicList.get(0);

		List<DegreeVO> degreelist = degreeService.getDegree();
		List<SemesterVO> semesterlist = semesterService.getSemester();
		return new ModelAndView("admin/addAcademic", "AcademicVO", academicVO).addObject("degreelist", degreelist)
				.addObject("semesterlist", semesterlist).addObject("type", "Edit ").addObject("button", "Update ");
	}

	@GetMapping(value = "admin/deleteAcademic")
	public ModelAndView deleteAcademic(@ModelAttribute AcademicVO academicVO, @RequestParam int id,
			HttpServletRequest request) {

		List<AcademicVO> academicList = this.academicService.findById(academicVO);
		academicVO = academicList.get(0);

		String path = request.getSession().getServletContext().getRealPath("/");
		String filePath = path + "documents\\academic\\";

		File f = new File(filePath + academicVO.getFileName());
		f.delete();

		this.academicService.deleteAcademic(academicVO);

		return new ModelAndView("redirect:/admin/viewAcademic");
	}
}
