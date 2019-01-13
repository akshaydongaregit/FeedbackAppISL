package com.tresk.service;

import com.tresk.dto.Clazz;

public interface BasicInfoService {

	public Clazz addClass(Clazz clazz);
	
	//dynamic controller methods
	public String addClass(String param);
	public String getClass(String param);
	public String getAllClasses(String param);
}
