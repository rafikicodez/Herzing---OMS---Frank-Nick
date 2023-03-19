package com.springboot.OMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.OMS.model.FrontService;
import com.springboot.OMS.service.FrontManagerService;

@Controller
public class FrontServiceController {
	
	@Autowired
	private FrontManagerService service;
	
	
	// display list of front services
	@GetMapping("/front")
	public String showFrontServiceManager(Model model) {
		model.addAttribute("listFrontServices", service.getAllFrontServices());
		
		return "front_service";
	}
	
	
	// display add front service form
	@GetMapping("/showNewFrontServiceForm")
	public String showNewFrontServiceForm(Model model) {
		// create model attribute to bind form data
		FrontService front_service = new FrontService();
		model.addAttribute("front_service", front_service);
		return "add_front_service";
	}
	
	
	// save front service
	@PostMapping("/saveFrontService")
	public String saveFrontService(@ModelAttribute("front_service") FrontService front_service) {
		// save product to database
		service.saveFrontService(front_service);
		return "redirect:/front";
	}
	
	
	@GetMapping("/showUpdateFrontService/{id}")
	public String showUpdateFrontService(@PathVariable(value="id") long id, Model model) {
		
		// get front service from the service
		FrontService front_service = service.getFrontServiceByID(id);
		
		// set front service as a model attribute to pre-populate the form
		model.addAttribute("front_service", front_service);
		return "update_front_service";
	}
	
	
	@GetMapping("/deleteFrontService/{id}")
	public String deleteFrontService(@PathVariable(value="id") long id, Model model) {
		
		// get front service from the service
		this.service.deleteFrontServiceByID(id);
		return "redirect:/front";
	}

}
