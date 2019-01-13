package com.tresk.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AuthenticationDaoImpl implements AuthenticationDao{

	@Override
	public String authenticateStudent(String param) {
		
		return "true";
	}

	
}
