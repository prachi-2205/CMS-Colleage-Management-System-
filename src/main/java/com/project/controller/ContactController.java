package com.project.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;


@Controller
public class ContactController {

	@RequestMapping(value = "user/contact-style-two", method = RequestMethod.GET)
	public ModelAndView userContact() {

		return new ModelAndView("user/contact-style-two");
	}
}

	