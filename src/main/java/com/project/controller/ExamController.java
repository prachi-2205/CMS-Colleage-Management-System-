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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.AcademicVO;
import com.project.model.DegreeVO;
import com.project.model.ExamVO;
import com.project.model.SemesterVO;
import com.project.service.DegreeService;
import com.project.service.ExamService;
import com.project.service.SemesterService;

@Controller
public class ExamController {
	
	@Autowired
	private DegreeService degreeService;

	@Autowired
	private SemesterService semesterService;
	
	@Autowired
	private ExamService examService;
	
	
	@GetMapping(value = "user/exam")
	public ModelAndView userExam() {
		List<DegreeVO> degreelist = degreeService.getDegree();
		List<SemesterVO> semesterlist = semesterService.getSemester();
		return new ModelAndView("user/exam", "ExamVO", new ExamVO()).addObject("degreeList", degreelist)
				.addObject("semesterlist", semesterlist);
	}
	
	@GetMapping(value = "user/userViewExam")
	public ModelAndView userViewExam(@RequestParam(required = false) Integer degreeId,
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

		List<ExamVO> examList = this.examService.getExamByDegreeAndSemester(degreeId, semesterId);

		System.out.println(examList.size());

		return new ModelAndView("user/exam", "examList", examList).addObject("degreeList", degreeList)
				.addObject(map);
	}
	
	
	@PostMapping(value = "user/saveUserExam")
	public ModelAndView saveUserExam(@ModelAttribute ExamVO examVO, @RequestParam MultipartFile file,
			HttpServletRequest request) {

		if (examVO.getId() != null && examVO.getId() > 0) {
			List<ExamVO> examList = this.examService.findById(examVO);
			ExamVO examVO2 = examList.get(0);
			
			
			if(file.isEmpty()){
				
				examVO.setFileName(examVO2.getFileName());
				examVO.setFilePath(examVO2.getFilePath());
			}else{
			
	
			String path = request.getSession().getServletContext().getRealPath("/");
			String filePath = path + "documents\\exam\\";

			File f = new File(filePath + examVO2.getFileName());
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
			
			examVO.setFileName(fileName);
			examVO.setFilePath(filePath);
			}
		}else{

		String path = request.getSession().getServletContext().getRealPath("/");

		String fileName = file.getOriginalFilename();

		String filePath = path + "documents\\exam\\";

		try {
			byte barr[] = file.getBytes();

			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(filePath + "/" + fileName));

			bout.write(barr);
			bout.flush();
			bout.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		examVO.setFileName(fileName);
		examVO.setFilePath(filePath);
		}
		this.examService.saveExam(examVO);
		return new ModelAndView("redirect:/user/exam");
	}
	
	
	
	
	/*@RequestMapping(value = "user/exam", method = RequestMethod.GET)
	public ModelAndView userExam() {

		return new ModelAndView("user/exam");
	}*/

	@GetMapping(value = "admin/addExam")
	public ModelAndView addExam() {
		List<DegreeVO> degreelist = degreeService.getDegree();
		List<SemesterVO> semesterlist = semesterService.getSemester();
		return new ModelAndView("admin/addExam", "ExamVO", new ExamVO()).addObject("degreelist",
				degreelist).addObject("semesterlist",semesterlist).addObject("type", "Add ").addObject("button","Add ");
	}
	
	@GetMapping(value = "admin/getSemesterOfExam")
	public ResponseEntity getSemesterOfExam(String examId) {
		SemesterVO semester =this.examService.getSemesterOfExam(examId);
		return new ResponseEntity(semester,HttpStatus.OK);
	}

	@PostMapping(value = "admin/saveExam")
	public ModelAndView saveExam(@ModelAttribute ExamVO examVO, @RequestParam MultipartFile file,
			HttpServletRequest request) {
		
		if (examVO.getId() != null && examVO.getId()> 0 ) {
			
			List<ExamVO> examList = this.examService.findById(examVO);
			ExamVO examVO2 = examList.get(0);
			
			if(file.isEmpty()){
				
				examVO.setFileName(examVO2.getFileName());
				examVO.setFilePath(examVO2.getFilePath());

			}else{
				
				String path = request.getSession().getServletContext().getRealPath("/");
				String filePath = path + "documents\\exam\\";

				File f = new File(filePath + examVO2.getFileName());
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

				examVO.setFileName(fileName);
				examVO.setFilePath(filePath);

			}
		}else{

			String path = request.getSession().getServletContext().getRealPath("/");

			String fileName = file.getOriginalFilename();

			String filePath = path + "documents\\exam\\";

			try {
				byte barr[] = file.getBytes();

				BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(filePath + "/" + fileName));

				bout.write(barr);
				bout.flush();
				bout.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

			examVO.setFileName(fileName);
			examVO.setFilePath(filePath);
			
		}

		this.examService.saveExam(examVO);
		return new ModelAndView("redirect:/admin/viewExam");
	}
	
	@GetMapping(value = "admin/viewExam")
	public ModelAndView viewExam() {
		List<ExamVO> examList = this.examService.getExam();
		return new ModelAndView("admin/viewExam", "examList", examList);
	}
	
	@GetMapping(value = "admin/deleteExam")
	public ModelAndView deleteExam(@ModelAttribute ExamVO examVO, @RequestParam int id,HttpServletRequest request) {

		List<ExamVO> examList = this.examService.findById(examVO);
		examVO = examList.get(0);

		String path = request.getSession().getServletContext().getRealPath("/");
		String filePath = path + "documents\\exam\\";

		File f = new File(filePath + examVO.getFileName());
		f.delete();

		this.examService.deleteExam(examVO);           

		return new ModelAndView("redirect:/admin/viewExam");
	}
	
	@GetMapping(value = "admin/editExam")
	public ModelAndView editExam(@ModelAttribute ExamVO examVO, @RequestParam int id) {

		List<DegreeVO> degreelist = degreeService.getDegree();
		List<SemesterVO> semesterlist = semesterService.getSemester();
		List<ExamVO> examList = this.examService.findById(examVO);
		examVO = examList.get(0);

		return new ModelAndView("admin/addExam", "ExamVO", examVO).addObject("degreelist", degreelist)
				.addObject("semesterlist", semesterlist).addObject("type","Edit ").addObject("button","Update ");
	}

}
