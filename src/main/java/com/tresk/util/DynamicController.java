package com.tresk.util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class DynamicController<T>{

	T service;
	
	public DynamicController() {
		
	}
	
	public DynamicController(T service) {
		super();
		this.service = service;
	}

	public String serve(String serviceUrl,String req) {
		
		try{			
			Method method = service.getClass().getDeclaredMethod(serviceUrl, String.class);
			String result = (String) method.invoke(service,req);
			return result;
		}catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | SecurityException e) {
			e.printStackTrace();
			return "No Service Exists for : "+serviceUrl;
		}
		
	}
}
