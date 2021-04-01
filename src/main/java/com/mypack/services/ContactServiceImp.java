package com.mypack.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.mypack.dao.ContactRepository;
import com.mypack.entities.Contact;

@Service
@Configuration
public class ContactServiceImp implements ContactServices {

	ContactRepository contactRepository;

	@Autowired
	public void setContactRepository(ContactRepository contactRepository) {
		this.contactRepository = contactRepository;
	}

	@Override
	public boolean saveOrEditContact(Contact contact) {
		Contact saveObj = contactRepository.save(contact);
		/*
		 * First Method---------------------------------------------------------
		 * if(saveObj.getContactId()!=null){ return true; } else{ return false; }
		 */
		// 2nd Method------------------------------------------------------------
		// return saveObj.getContactId()!=null? true:false;

		return saveObj.getContactId() != null;

	}

	@Override
	public List<Contact> GetAllContact() {
		/*
		 * List<Contact> findAll = contactRepository.findAll(); return findAll;
		 */
		return contactRepository.findAll();
	}

	@Override
	public Contact getById(Integer contactId) {
		Optional<Contact> findById = contactRepository.findById(contactId);
		if (findById.isPresent()) 
		{
			return findById.get();
		}
		return null;
	}

	@Override
	public boolean DeleteContact(Integer contactId) {
		boolean isDeleted=false;
		try {
			contactRepository.deleteById(contactId);
			 isDeleted=true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return isDeleted;
	}

}
