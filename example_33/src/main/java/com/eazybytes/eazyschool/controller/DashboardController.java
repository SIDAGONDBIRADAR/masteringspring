package com.eazybytes.eazyschool.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eazybytes.eazyschool.model.Person;
import com.eazybytes.eazyschool.repository.PersonRepository;

import jakarta.servlet.http.HttpSession;

@Slf4j
@Controller
public class DashboardController {

	@Autowired
	PersonRepository personRepository;
	
	@Autowired
	Environment environment;

//	@Value("${eazyschool.pageSize}")
//	private int defaultPageSize;
//
//	@Value("${eazyschool.contact.successMsg}")
//	private String successMessage;

	@RequestMapping("/dashboard")
	public String displayDashboard(Model model, Authentication authentication, HttpSession session) {
		Person person = personRepository.findByEmail(authentication.getName());
		model.addAttribute("username", person.getName());
		model.addAttribute("roles", authentication.getAuthorities().toString());
		if (person.getEazyClass() != null && person.getEazyClass().getName() != null) {
			model.addAttribute("enrolledClass", person.getEazyClass().getName());
		}
		// throw new RuntimeException("It's been a bad day!!");
		session.setAttribute("loggedInUser", person);
		return "dashboard.html";
	}

	public void logMessage() {
		log.info("Default page size with @value annotation is :" + environment.getProperty("eazyschool.pageSize"));
		log.info("Default success message with @value annotation is :" + environment.getProperty("eazyschool.contact.successMsg"));
		log.info(environment.getProperty("JAVA_HOME"));
	}

}
