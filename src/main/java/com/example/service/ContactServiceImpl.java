package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ContactRepository;
import com.example.model.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository repo;

	@Override
	public String upsert(Contact contact) {
		repo.save(contact);
		return "SUCCESS";
	}

	@Override
	public List<Contact> getAllContacts() {
		List<Contact> list = repo.findAll();
		return list;
	}

	@Override
	public Contact getContact(int contactId) {
		Optional<Contact> optional = repo.findById(contactId);
		if (optional.isPresent()) {
			Contact contact = optional.get();
			if(contact.getActiveSw().equals("Y"))
			 return contact;
		}
		return new Contact();
	}

	@Override
	public String deleteContact(int contactId) {
		Optional<Contact> optional = repo.findById(contactId);
		if(optional.isPresent())
		{
			Contact contact = optional.get();
			contact.setActiveSw("N");
			repo.save(contact);
		}
		return "SUCCESS";
	}

}
