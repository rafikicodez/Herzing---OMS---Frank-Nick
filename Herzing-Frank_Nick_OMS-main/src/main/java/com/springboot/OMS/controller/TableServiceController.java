package com.springboot.OMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.OMS.model.TableService;
import com.springboot.OMS.service.TableManagerService;

@Controller
public class TableServiceController {
	
	@Autowired
	private TableManagerService tms;
	
	// display list of front services
	@GetMapping("/table")
	public String showTableServiceManager(Model model) {
		model.addAttribute("listTableServices", tms.getAllTableServices());
		return "table_manager";
	}
	
	
	// display add table service form
	@GetMapping("/showNewTableServiceForm")
	public String showNewTableServiceForm(Model model) {
		// create model attribute to bind form data
		TableService table_service = new TableService();
		model.addAttribute("table_service", table_service);
		return "add_table";
	}
	
	
	// save product
	@PostMapping("/saveTable")
	public String saveTable(@ModelAttribute("product") TableService table_service) {
		tms.saveTableService(table_service);
		return "redirect:/table";
	}
	
	
	@GetMapping("/showUpdateTable/{id}")
	public String showUpdateTable(@PathVariable(value="id") long id, Model model) {
		
		// get table service from the service
		TableService table_service = tms.getTableServiceByID(id);
		
		// set table service as a model attribute to pre-populate the form
		model.addAttribute("table_service", table_service);
		return "update_table";
	}
	
	
	@GetMapping("/deleteTable/{id}")
	public String deleteTable(@PathVariable(value="id") long id, Model model) {
		
		// call delete product method
		this.tms.deleteTableServiceByID(id);
		return "redirect:/table";
	}
		

}
