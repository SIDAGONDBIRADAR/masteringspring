package com.biradar.sidagond.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties.Error;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.biradar.sidagond.model.Contact;
import com.biradar.sidagond.service.ContactService;

import jakarta.validation.Valid;

@Controller
public class ContactController {

	private static final Logger log = Logger.getLogger(ContactController.class.getName());
	
	@Autowired
	ContactService contactService;

	@RequestMapping("/contact")
	public String displayContactPage(Model model) {
		model.addAttribute("contact",new Contact());
		return "contact.html";
	}

	/*
	@RequestMapping(value = "/saveMsg", method = RequestMethod.POST)
	public ModelAndView saveMessage(@RequestParam String name, @RequestParam String mobileNum,
			@RequestParam String email, @RequestParam String subject, @RequestParam String message) {

		log.info("Name :" + name);
		log.info("Mobile Number :" + mobileNum);
		log.info("Email :" + email);
		log.info("Subject :" + subject);
		log.info("Message :" + message);
		return new ModelAndView("redirect:/contact");
	}
	*/
	
	@RequestMapping(value = "/saveMsg",method = RequestMethod.POST)
	public String saveMessage(@Valid @ModelAttribute("contact") Contact contact,Errors error) {
		if(error.hasErrors()) {
			log.info("Error occured while validating Contact page"+error.toString());
			return "contact.html";
		}
		contactService.saveMessageDetails(contact);
		return "redirect:/contact";
	}
		
}
