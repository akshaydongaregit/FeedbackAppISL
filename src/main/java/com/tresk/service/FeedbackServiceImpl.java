package com.tresk.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tresk.dao.FeedbackDao;

@Service
public class FeedbackServiceImpl implements FeedbackService{

	@Autowired
	FeedbackDao dao;
}
