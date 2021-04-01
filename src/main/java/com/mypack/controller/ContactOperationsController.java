package com.mypack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mypack.entities.Contact;
import com.mypack.services.ContactServices;

@Controller
public class ContactOperationsController {
	
	private ContactServices service;
	
	@Autowired
	public ContactOperationsController(ContactServices service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/edit")
	public String editContact( @RequestParam("cid") Integer contactId,Model model) {
		
		Contact ContactObj = service.getById(contactId);
		model.addAttribute("contact", ContactObj);
		
		return"contact";
	}
	
	@GetMapping("/delete")
	public String deleteContact(@RequestParam("cid") Integer contactId,Model model) {
		boolean isDeleted = service.DeleteContact(contactId);
		if (isDeleted) {
			
			model.addAttribute("succsMsg", "Contact Deleted Sucessfully!!");
		} else {
				model.addAttribute("failMsg", "Contact Not deleted.");
		}
		return "redirect:view-contacts";
	}
	
	

}
