package com.project.controller;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
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
import com.project.model.LoginVO;
import com.project.service.DegreeService;
import com.project.service.LoginService;
import com.project.utils.BaseMethods;

@Controller
public class LoginController {
	Random random=new Random(1111);

	@Autowired
	private DegreeService degreeService;
	
	@Autowired
	private LoginService loginService;
	
	
	@Autowired
	private BaseMethods baseMethods;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView loadLogin() {

		List<DegreeVO> degreeList = this.degreeService.getDegree();
		return new ModelAndView("index", "degreeList", degreeList);
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/admin/index", method = RequestMethod.GET)
	public ModelAndView adminIndex() {
		List degreeCount = loginService.getDegreeCount();
		List facultyCount = loginService.getFacultyCount();
		List studentCount = loginService.getStudentCount();
		List list = loginService.getStudentCountPerDegree();

		System.out.println(degreeCount);
		System.out.println(facultyCount);
		System.out.println(studentCount);
		System.out.println(list);

		return new ModelAndView("admin/index").addObject("degreeCount", degreeCount.get(0)).addObject("list", list)
				.addObject("facultyCount", facultyCount.get(0)).addObject("studentCount", studentCount.get(0));
	}

	@RequestMapping(value = "/faculty/index", method = RequestMethod.GET)
	public ModelAndView facultyIndex() {

		return new ModelAndView("faculty/index");
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping(value = "/user/index", method = RequestMethod.GET)
	public ModelAndView userIndex() {
		List degreeCount = loginService.getDegreeCount();
		List facultyCount = loginService.getFacultyCount();
		List studentCount = loginService.getStudentCount();
		List<DegreeVO> degreeList = this.degreeService.getDegree();
		return new ModelAndView("user/index", "degreeList", degreeList).addObject("degreeCount", degreeCount.get(0)).addObject("facultyCount", facultyCount.get(0)).addObject("studentCount", studentCount.get(0));
	}

	@RequestMapping(value = "/logout", method = { RequestMethod.POST, RequestMethod.GET })
	public String viewUserDetails(ModelMap model, HttpServletResponse response, HttpServletRequest request) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (auth != null) {
			new SecurityContextLogoutHandler().logout(request, response, auth);
			request.getSession().invalidate();
			request.getSession().setAttribute("tempStatus", "success");
			request.getSession().setAttribute("statusText", "Logout Successfully!");
		}
		return  "/";
	}
	
	//USER CHANGE PASSWORD
	@GetMapping(value = "/user/password")
	public ModelAndView password() {
		return new ModelAndView("user/password");
	}
	
	@PostMapping(value = "/user/savechangepassword")
	public ModelAndView savechangepassword(@RequestParam String confirmpassword,@RequestParam String oldpassword) {
		
		boolean flag = false;
		String getuserName = BaseMethods.getUsername();		
		List<LoginVO> LoginList = this.loginService.getUserName(getuserName);	
		LoginVO loginvo = LoginList.get(0);
		Integer getid  = loginvo.getId();
		
			if(loginvo.getPassword().equals(oldpassword))
			{
				flag = true;
			}
			else
			{
				flag = false;
			}
		
		if(flag == true)
		{
			String messageBody = this.baseMethods.generateMailBody1(getuserName,confirmpassword);
			this.baseMethods.sendMail("CMS : Credentials", messageBody, getuserName);
			loginvo.setId(getid);
			loginvo.setPassword(confirmpassword);
			this.loginService.save(loginvo);
			return new ModelAndView("redirect:/user/index");	
		}
		else
		{
			return new ModelAndView("user/password").addObject("check","wrong");
		}	
	}
	
	//ADMIN CHANGE PASSWORD
	@GetMapping(value = "/admin/adminPassword")
	public ModelAndView adminPassword() {
		return new ModelAndView("admin/adminPassword");
	}
	
	@PostMapping(value = "/admin/savechangepassword")
	public ModelAndView saveadminchangepassword(@RequestParam String confirmpassword,@RequestParam String oldpassword) {
		
		boolean flag = false;
		String getuserName = BaseMethods.getUsername();		
		List<LoginVO> LoginList = this.loginService.getUserName(getuserName);	
		LoginVO loginvo = LoginList.get(0);
		Integer getid  = loginvo.getId();
		
			if(loginvo.getPassword().equals(oldpassword))
			{
				flag = true;
			}
			else
			{
				flag = false;
			}
		
		if(flag == true)
		{
			String messageBody = this.baseMethods.generateMailBody1(getuserName,confirmpassword);
			this.baseMethods.sendMail("CMS : Credentials", messageBody, getuserName);
			loginvo.setId(getid);
			loginvo.setPassword(confirmpassword);
			this.loginService.save(loginvo);
			return new ModelAndView("redirect:/admin/index");	
		}
		else
		{
			return new ModelAndView("admin/adminPassword").addObject("check","wrong");
		}	
	}
	
	//FACULTY CHANGE PASSWORD
		@GetMapping(value = "/faculty/facultyPassword")
		public ModelAndView facultyPassword() {
			return new ModelAndView("faculty/facultyPassword");
		}
		
		@PostMapping(value = "/faculty/savechangepassword")
		public ModelAndView savefacultychangepassword(@RequestParam String confirmpassword,@RequestParam String oldpassword) {
			
			boolean flag = false;
			String getuserName = BaseMethods.getUsername();		
			List<LoginVO> LoginList = this.loginService.getUserName(getuserName);	
			LoginVO loginvo = LoginList.get(0);
			Integer getid  = loginvo.getId();
			
				if(loginvo.getPassword().equals(oldpassword))
				{
					flag = true;
				}
				else
				{
					flag = false;
				}
			
			if(flag == true)
			{
				String messageBody = this.baseMethods.generateMailBody1(getuserName,confirmpassword);
				this.baseMethods.sendMail("CMS : Credentials", messageBody, getuserName);
				loginvo.setId(getid);
				loginvo.setPassword(confirmpassword);
				this.loginService.save(loginvo);
				return new ModelAndView("redirect:/faculty/index");	
			}
			else
			{
				return new ModelAndView("faculty/facultyPassword").addObject("check","wrong");
			}	
		}
	
	
	//GO TO THE FORGET PAGE..
	@GetMapping(value = "/forgetpw")
	public ModelAndView forgetpw() {
		return new ModelAndView("forgetpw");
	}
	
	//TO SEND OTP..
	@PostMapping(value = "/otp")
	public ModelAndView sendotp(@RequestParam("email")String email ,HttpSession session,@ModelAttribute LoginVO loginVO) {
		//generating otp
		int otp =random.nextInt(999999);
		//write code for send otp	
		//check karva database ma 6 k nai emailid
		List<LoginVO> getusername = this.loginService.getUserName(email);
		boolean ans  = getusername.isEmpty();
		
		session.setAttribute("myotp",otp);
		session.setAttribute("email",email);
		
		if (ans == true){
			return new ModelAndView("forgetpw").addObject("set", "con");
			
		}else
		{
			String messageBody = this.baseMethods.generateMailBody(email,otp);
			this.baseMethods.sendMail("CMS : Credentials", messageBody, email);	
			return new ModelAndView("otp");
		}
		

	}
	
	//CHECK IF OTP IS RIGHT OR WRONG
	@PostMapping("/verify-otp")
	public ModelAndView verifyOTP(@RequestParam("otp") int otp,HttpSession session)
	{
		int myOtp=(Integer) session.getAttribute("myotp");
		if(myOtp==otp)
		{
			return new ModelAndView("password_change_form"); 
		}else
		{
			return new ModelAndView("otp").addObject("check","wrong");
		}	
	}
	
	//New password in Forget
	@PostMapping("/ChangePassword")
	public ModelAndView ChangePassword(@RequestParam("newpassword") String newpassword,HttpSession session, LoginVO loginVO)
	{
		
		String email=(String)session.getAttribute("email");		
		String messageBody = this.baseMethods.generateMailBody1(email,newpassword);
		this.baseMethods.sendMail("CMS : Credentials", messageBody, email);
		List<LoginVO> LoginList = this.loginService.getUserName(email);	
		LoginVO loginvo = LoginList.get(0);
		loginvo.setPassword(newpassword);
		this.loginService.save(loginvo);	
		
		return new ModelAndView("login").addObject("set", "con");
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView load() {

		return new ModelAndView("login");
	}
	
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView load2() {

		List<DegreeVO> degreeList = this.degreeService.getDegree();
		return new ModelAndView("index", "degreeList", degreeList);
	}
	
	@RequestMapping(value = "/contact-style-two", method = RequestMethod.GET)
	public ModelAndView load3() {

		return new ModelAndView("contact-style-two");
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView load403() {

		return new ModelAndView("login");
	}

}