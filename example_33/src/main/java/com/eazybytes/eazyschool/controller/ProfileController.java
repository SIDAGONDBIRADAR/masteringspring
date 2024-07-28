package com.eazybytes.eazyschool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.eazybytes.eazyschool.model.Address;
import com.eazybytes.eazyschool.model.Person;
import com.eazybytes.eazyschool.model.Profile;
import com.eazybytes.eazyschool.repository.PersonRepository;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller("profileControllerBean")
public class ProfileController {
	
	@Autowired
	PersonRepository personRepository;

	@RequestMapping("/displayProfile")
	public ModelAndView displayProfile(Model model, HttpSession session) {
		Person loggedInPerson = (Person) session.getAttribute("loggedInUser");
		Profile profile = new Profile();
		profile.setName(loggedInPerson.getName());
		profile.setEmail(loggedInPerson.getEmail());
		profile.setMobileNumber(loggedInPerson.getMobileNumber());
		if(loggedInPerson.getAddress() != null && loggedInPerson.getAddress().getAddressId() >0) {
			profile.setAddress1(loggedInPerson.getAddress().getAddress1());
			profile.setAddress2(loggedInPerson.getAddress().getAddress2());
			profile.setCity(loggedInPerson.getAddress().getCity());
			profile.setState(loggedInPerson.getAddress().getState());
			profile.setZipCode(loggedInPerson.getAddress().getZipCode());
		}
		ModelAndView modelAndView = new ModelAndView("profile.html");
		model.addAttribute("profile", profile);
		return modelAndView;
	}
	
	@RequestMapping(value = "/updateProfile",method = {RequestMethod.POST})
	public String updateProfile(@Valid @ModelAttribute("profile") Profile profile,HttpSession session,Errors errors) {
		if(errors.hasErrors()) {
			return "profile.html";
		}
		Person person = (Person) session.getAttribute("loggedInUser");
		
		person.setName(profile.getName());
		person.setEmail(profile.getEmail());
		person.setMobileNumber(profile.getMobileNumber());
		if(person.getAddress() == null || !(person.getAddress().getAddressId() >0)) {
			person.setAddress(new Address());
		}
			
		person.getAddress().setAddress1(profile.getAddress1());
		person.getAddress().setAddress2(profile.getAddress2());
		person.getAddress().setCity(profile.getCity());
		person.getAddress().setState(profile.getState());
		person.getAddress().setZipCode(profile.getZipCode());
			
		Person savedPerson = personRepository.save(person);
		session.setAttribute("loggedInUser",savedPerson);
		return "redirect:/displayProfile";
		
		
	}
	
}
