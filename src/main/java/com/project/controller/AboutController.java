package com.project.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;


@Controller
public class AboutController {

	@RequestMapping(value = "user/about", method = RequestMethod.GET)
	public ModelAndView userAbout() {

		return new ModelAndView("user/about");
	}
}

	