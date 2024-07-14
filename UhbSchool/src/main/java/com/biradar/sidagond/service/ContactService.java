package com.biradar.sidagond.service;

import java.util.logging.Logger;

import org.springframework.stereotype.Service;

import com.biradar.sidagond.controller.ContactController;
import com.biradar.sidagond.model.Contact;

@Service
public class ContactService {

	private static final Logger log = Logger.getLogger(ContactService.class.getName());

	public boolean saveMessageDetails(Contact contact) {
		boolean isSaved = true;
		log.info(contact.toString());
		return isSaved;
	}

}
