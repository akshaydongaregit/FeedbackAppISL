package com.tresk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tresk.service.AdminService;
import com.tresk.util.DynamicController;

@RestController
public class AdminController {

	@Autowired
	AdminService service;
	
	@RequestMapping(value="/admin/{serviceUrl}",method=RequestMethod.POST)
	public String classDynamicController(@PathVariable String serviceUrl,@RequestBody String req) {
		
		DynamicController<AdminService> dynamicController = new DynamicController<>(service);
		return dynamicController.serve(serviceUrl,req);
		
	}
	
}
