package com.biradar.sidagond.service;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.biradar.sidagond.controller.ContactController;
import com.biradar.sidagond.model.Contact;

@Service
//@SessionScope
//@ApplicationScope
public class ContactService {

	private static final Logger log = Logger.getLogger(ContactService.class.getName());
	
//	public ContactService() {
//		System.out.println("Constact Service initialized ");
//	}

	private int count=0;
	public boolean saveMessageDetails(Contact contact) {
		count=count+1;
		boolean isSaved = true;
		log.info(contact.toString());
		System.out.println("Student created "+count);
		return isSaved;
	}

}
