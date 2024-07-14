package com.biradar.sidagond.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.biradar.sidagond.model.Contact;
import com.biradar.sidagond.service.ContactService;

@Controller
public class ContactController {

	private static final Logger log = Logger.getLogger(ContactController.class.getName());
	
	@Autowired
	ContactService contactService;

	@RequestMapping("/contact")
	public String displayContactPage() {
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
	public ModelAndView saveMessage(Contact contact) {
		contactService.saveMessageDetails(contact);
		return new ModelAndView("redirect:/contact");
	}
		
}
