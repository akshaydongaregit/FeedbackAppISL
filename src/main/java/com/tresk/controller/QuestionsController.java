package com.tresk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import 
import com.tresk.service.QuestionsService;
import com.tresk.util.DynamicController;

@RestController
public class QuestionsController {

	@Autowired
	QuestionsService service;

	@RequestMapping(value="/question/{serviceUrl}",method=RequestMethod.POST)
	public String classDynamicController(@PathVariable String serviceUrl,@RequestBody String req) {

		DynamicController<QuestionsService> dynamicController = new DynamicController<>(service);
		return dynamicController.serve(serviceUrl,req);

	}
}
