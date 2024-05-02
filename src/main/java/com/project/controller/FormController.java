package com.project.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.project.model.DegreeVO;
import com.project.model.ExamVO;
import com.project.model.FormVO;
import com.project.model.SemesterVO;
import com.project.service.FormService;

@Controller
public class FormController {

	@Autowired
	private FormService formService;

	@GetMapping(value = "user/form")
	public ModelAndView userForm() {
		List<FormVO> formList = this.formService.getForm();
		return new ModelAndView("user/form","formList",formList);
	}
	
	
	@GetMapping(value = "admin/addForm")
	public ModelAndView addForm() {
		return new ModelAndView("admin/addForm", "FormVO", new FormVO()).addObject("type", "Add ").addObject("button","Add ");
	} 
		
	@PostMapping(value = "admin/saveForm")
	public ModelAndView saveForm(@ModelAttribute FormVO formVO, @RequestParam MultipartFile file,
			HttpServletRequest request) {

		if (formVO.getId() != null && formVO.getId()> 0) {
			List<FormVO> formList = this.formService.findById(formVO);
			FormVO formVO2 = formList.get(0);
			
				if(file.isEmpty()){
				
					formVO.setFileName(formVO2.getFileName());
					formVO.setFilePath(formVO2.getFilePath());
				}else{

			String path = request.getSession().getServletContext().getRealPath("/");
			String filePath = path + "documents\\form\\";

			File f = new File(filePath + formVO2.getFileName());
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
			
			formVO.setFileName(fileName);
			formVO.setFilePath(filePath);
			
		}
		}else{

		String path = request.getSession().getServletContext().getRealPath("/");

		String fileName = file.getOriginalFilename();

		String filePath = path + "documents\\form\\";

		try {
			byte barr[] = file.getBytes();

			BufferedOutputStream bout = new BufferedOutputStream(new FileOutputStream(filePath + "/" + fileName));

			bout.write(barr);
			bout.flush();
			bout.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		formVO.setFileName(fileName);
		formVO.setFilePath(filePath);
		}
		this.formService.saveForm(formVO);
		return new ModelAndView("redirect:/admin/viewForm");
	
	}
	@GetMapping(value = "admin/viewForm")
	public ModelAndView viewForm() {
		List<FormVO> formList = this.formService.getForm();
		return new ModelAndView("admin/viewForm","formList",formList);
	}
	
	@GetMapping(value = "admin/editForm")
	public ModelAndView editForm(@ModelAttribute FormVO formVO, @RequestParam int id,
			HttpServletRequest request) {

		List<FormVO> formList = this.formService.findById(formVO);
		formVO = formList.get(0);

		return new ModelAndView("admin/addForm", "FormVO", formVO).addObject("type","Edit ").addObject("button","Update ");
	}
	
	@GetMapping(value = "admin/deleteForm")
	public ModelAndView deleteForm(@ModelAttribute FormVO formVO, @RequestParam int id,HttpServletRequest request) {

		List<FormVO> formList = this.formService.findById(formVO);
		formVO = formList.get(0);

		String path = request.getSession().getServletContext().getRealPath("/");
		String filePath = path + "documents\\form\\";

		File f = new File(filePath + formVO.getFileName());
		f.delete();

		this.formService.deleteForm(formVO);           

		return new ModelAndView("redirect:/admin/viewForm");
	}
}
