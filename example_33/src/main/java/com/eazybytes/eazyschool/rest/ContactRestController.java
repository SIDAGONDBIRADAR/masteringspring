package com.eazybytes.eazyschool.rest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.eazybytes.eazyschool.constants.EazySchoolConstants;
import com.eazybytes.eazyschool.dto.Response;
import com.eazybytes.eazyschool.model.Contact;
import com.eazybytes.eazyschool.repository.ContactRepository;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping(path = "/api/contact", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public class ContactRestController {

	@Autowired
	ContactRepository contactRepository;

	@GetMapping("/getMessagesByStatus")
	@ResponseBody
	public List<Contact> getMessagesByStatus(@RequestParam("status") String status) {
		return contactRepository.findByStatus(status);

	}

	@GetMapping("/getAllMessagesByStatus")
	@ResponseBody
	public List<Contact> getAllMessagesByStatus(@RequestBody Contact contact) {
		if (contact != null && contact.getContactId() > 0) {
			return contactRepository.findByStatus(contact.getStatus());
		} else {
			return new ArrayList<>();
		}

	}

	@PostMapping("/saveMsg")
	public ResponseEntity<Response> saveMsg(@RequestHeader("invocationFrom") String invocationFrom,
			@RequestBody @Valid Contact contact) {
		log.info(String.format("Header invocationFrom = %s", invocationFrom));
		contactRepository.save(contact);
		Response response = new Response();
		response.setStatusCode("200");
		response.setStatusMsg("Message saved successfully");

		return ResponseEntity.status(HttpStatus.CREATED).header("isSaved", "true").body(response);
	}

	@DeleteMapping("/deleteMsg/{contactId}")
	public ResponseEntity<Response> deleteMsg(@PathVariable Integer contactId) {
		Response response = new Response();
		Contact dbContactMsg = contactRepository.findById(contactId).get();
		if (dbContactMsg != null && dbContactMsg.getContactId() > 0) {
			contactRepository.delete(dbContactMsg);
			response.setStatusCode("200");
			response.setStatusMsg("deleted Successfully ");
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PatchMapping("/closeMsg")
	public ResponseEntity<Response> closeMsg(@RequestBody Contact contact) {
		Response response = new Response();
		Contact dbContact = contactRepository.findByContactId(contact.getContactId());
		if (dbContact != null && dbContact.getContactId() > 0) {
			dbContact.setStatus(EazySchoolConstants.CLOSED);
			contactRepository.save(dbContact);

		} else {
			response.setStatusCode("400");
			response.setStatusMsg("Invalid contact Id ");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
		response.setStatusCode("200");
		response.setStatusMsg("Message Successfully closed");
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
