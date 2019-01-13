package com.tresk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tresk.dao.AuthenticationDao;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

	@Autowired
	AuthenticationDao dao;
	
	@Override
	public String authenticateStudent(String param) {
		
		System.out.println("param : "+param);
		
		return dao.authenticateStudent(param);
	}

}
