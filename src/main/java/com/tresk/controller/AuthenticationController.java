package com.tresk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tresk.service.AuthenticationService;

@RestController
public class AuthenticationController {

	@Autowired
	AuthenticationService service;
	
	@RequestMapping(value="/authenticateStudent",method=RequestMethod.POST)
	public String authenticateStudent(@RequestBody String body)
	{
		return service.authenticateStudent(body);
	}
}
