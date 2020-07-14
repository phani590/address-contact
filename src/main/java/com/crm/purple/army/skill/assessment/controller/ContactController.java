package com.crm.purple.army.skill.assessment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.crm.purple.army.skill.assessment.entity.Contact;
import com.crm.purple.army.skill.assessment.service.ContactService;

@Controller
public class ContactController {
	@Autowired
    private ContactService service;
	
	@RequestMapping("/listContacts")
	public ModelAndView viewHomePage(Model model) {
	    List<Contact> listContacts = service.listAll();
	    ModelAndView mav = new ModelAndView("contact_list");
	    mav.addObject("listContacts", listContacts);
	     
	    return mav;
	}
	
	@RequestMapping("/newContact")
	public ModelAndView showNewContactPage() {
		  ModelAndView mav = new ModelAndView("contact");
		    mav.addObject("contact", new Contact());
		    return mav;
	}
	
	@RequestMapping(value = "/saveContact", method = RequestMethod.POST)
	public ModelAndView saveContact(@ModelAttribute("contact") Contact contact) {
	    service.save(contact);
	     
	    return new ModelAndView("redirect:/listContacts");
	}
	
	@RequestMapping("/editContact/{id}")
	public ModelAndView showEditContactPage(@PathVariable(name = "id") int id) {
	    ModelAndView mav = new ModelAndView("contact");
	    Contact contact = service.get(id);
	    mav.addObject("contact", contact);
	     
	    return mav;
	}
	
	@RequestMapping("/deleteContact/{id}")
	public ModelAndView deleteContact(@PathVariable(name = "id") int id) {
	    service.delete(id);
	    return new ModelAndView("redirect:/listContacts");
	}
}
