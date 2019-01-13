package com.tresk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tresk.dao.QuestionsDao;

@Service
public class QuestionsServiceImpl implements QuestionsService{

	@Autowired
	QuestionsDao dao;
}
