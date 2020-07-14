package com.crm.purple.army.skill.assessment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	@RequestMapping(value="/searchContacts",method = RequestMethod.POST)
	public ModelAndView viewSearchPage(@RequestParam String searchText) {
	    List<Contact> listContacts = service.searchContact(searchText);
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
	public String saveContact(@Valid @ModelAttribute("contact") Contact contact,BindingResult bindingResult,Model model) {
		if (bindingResult.hasErrors()) {
			    return "contact";
	      }
		
	    service.save(contact);
	     
	    return "redirect:/listContacts";
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
