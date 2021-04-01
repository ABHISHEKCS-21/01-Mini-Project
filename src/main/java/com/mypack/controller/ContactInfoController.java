package com.mypack.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.mypack.entities.Contact;
import com.mypack.services.ContactServices;

@Controller
public class ContactInfoController {

	private ContactServices service;

	public ContactInfoController(ContactServices service) {
		super();
		this.service = service; 
	}

	/*
	 * This Method is used to Display contact form...
	 */

	@GetMapping("/load-form")
	public String loadForm(Model model) {

		Contact conObj = new Contact();

		// Sending Data from Controller to UI...
		model.addAttribute("contact", conObj);
 
		// Return Logical View...
		return "contact";
	}

	@PostMapping("/saveContact")
	public String HandleSubmitButton(Contact contact, Model model) {
		System.out.println(contact);

		boolean isSave = service.saveOrEditContact(contact);

		if (isSave) {
			model.addAttribute("succMsg", "Contact Saved Sucessfully!!!");
		} else {
			model.addAttribute("failMsg", "Opps Something Went Rong??? ");

		}

		return "contact";
	}
	
	
 @GetMapping("view-contacts")
	public String ViewContactHyperlink( Model model) {
	 
	 List<Contact> allContact = service.GetAllContact();
	 
	 model.addAttribute("contacts",allContact);
	 
		return "contacts-display";
	}

}
