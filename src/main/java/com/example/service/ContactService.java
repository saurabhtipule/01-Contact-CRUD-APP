package com.example.service;

import java.util.List;

import com.example.model.Contact;

public interface ContactService {

	public String upsert(Contact contact);

	public List<Contact> getAllContacts();

	public Contact getContact(int contactId);

	public String deleteContact(int contactId);

}
