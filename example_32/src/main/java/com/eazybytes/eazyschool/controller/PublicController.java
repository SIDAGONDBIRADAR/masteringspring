package com.eazybytes.eazyschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eazybytes.eazyschool.model.Person;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("public")
public class PublicController {

	@RequestMapping(value = "/register", method = { RequestMethod.GET })
	public String displayRegisterPage(Model model) {
		model.addAttribute("person", new Person());
		return "register.html";
	}
}
