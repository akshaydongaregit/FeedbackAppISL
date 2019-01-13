package com.tresk.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SQLQueryHelper {

	@Autowired
	JdbcTemplate jt;
	
	String queryTable="SQL_QUERY_MASTER";
	
	public String getQueryByName(String name) {
		String query="";
		
		query = jt.queryForObject("SELECT QUERY FROM "+queryTable+" where QUERY_NAME = ? ", new Object[]{name} ,String.class);
		
		return query;
	}
	
}
