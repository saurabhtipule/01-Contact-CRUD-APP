package com.example.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Contact;
import com.example.service.ContactService;

@RestController
public class ContactController {

	@Autowired
	private ContactService service;

	@PostMapping(value = "/addContact")
	public ResponseEntity<String> createContact(@RequestBody Contact contact) {
		String msg = service.upsert(contact);
		return new ResponseEntity<String>(msg, HttpStatus.CREATED);
	}

	@GetMapping(value = "/contacts")
	public ResponseEntity<List<Contact>> getContacts() {
		List<Contact> list = service.getAllContacts();
		return new ResponseEntity<List<Contact>>(list, HttpStatus.OK);
	}

	@GetMapping(value = "/contact/{contactId}")
	public ResponseEntity<Contact> getContact(@PathVariable int contactId) {
		Contact contact = service.getContact(contactId);
		return new ResponseEntity<Contact>(contact, HttpStatus.OK);
	}

	@DeleteMapping(value = "/contact/{contactId}")
	public ResponseEntity<String> deleteContact(@PathVariable int contactId) {
		String msg = service.deleteContact(contactId);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}

}
