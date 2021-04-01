package com.mypack.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mypack.dao.ContactRepository;
import com.mypack.entities.Contact;

public interface ContactServices {
		
public 	boolean saveOrEditContact(Contact contact);


public 	List<Contact> GetAllContact();

public Contact getById(Integer contactId);

public boolean DeleteContact(Integer contactId);

	
}
