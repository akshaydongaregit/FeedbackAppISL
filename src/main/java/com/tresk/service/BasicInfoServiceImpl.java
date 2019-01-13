package com.tresk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tresk.dao.BasicInfoDao;
import com.tresk.dto.Clazz;

@Service
@org.springframework.transaction.annotation.Transactional
public class BasicInfoServiceImpl implements BasicInfoService{

	@Autowired
	BasicInfoDao dao;
	
	public Clazz addClass(Clazz clazz) {
		return dao.addClass(clazz);
	}

	@Override
	public String addClass(String param) {
		return dao.addClass(param);
	}

	@Override
	public String getClass(String param) {
		return dao.getClass(param);
	}

	@Override
	public String getAllClasses(String param) {
		return dao.getAllClasses(param);
	}
}
