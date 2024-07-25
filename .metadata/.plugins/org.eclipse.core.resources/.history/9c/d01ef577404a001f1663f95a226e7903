package com.eazybytes.eazyschool.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.ApplicationScope;

import com.eazybytes.eazyschool.constants.EazySchoolConstants;
import com.eazybytes.eazyschool.model.Contact;
import com.eazybytes.eazyschool.repository.ContactRepository;

import lombok.extern.slf4j.Slf4j;

/*
@Slf4j, is a Lombok-provided annotation that will automatically generate an SLF4J
Logger static property in the class at compilation time.
* */
@Slf4j
@Service
@ApplicationScope
public class ContactService {

	@Autowired
	ContactRepository contactRepository;

	public boolean saveMessageDetails(Contact contact) {
		boolean isSaved = false;
		contact.setStatus(EazySchoolConstants.OPEN);
//		contact.setCreatedAt(LocalDateTime.now());
//		contact.setCreatedBy(EazySchoolConstants.ANNYMOUS);
		Contact savedContact = contactRepository.save(contact);

		if (savedContact.getContactId() > 0 && savedContact != null) {
			isSaved = true;
		}
		return isSaved;
	}

	public List<Contact> findMsgsWithOpenStatus() {
		List<Contact> openCOntacts = contactRepository.findByStatus(EazySchoolConstants.OPEN);
		return openCOntacts;
	}

	public boolean updateMessage(int contactId) {
		boolean isUpdated = false;
		Optional<Contact> dbContact = contactRepository.findById(contactId);
		dbContact.ifPresent(contact1 -> {
			contact1.setStatus(EazySchoolConstants.CLOSED);
//			contact1.setUpdatedAt(LocalDateTime.now());
//			contact1.setUpdatedBy(updatedBy);
		});
		Contact updatedContact = contactRepository.save(dbContact.get());
		if (updatedContact != null && updatedContact.getContactId() > 0)
			isUpdated = true;

		return isUpdated;
	}
}
