package com.tresk.dao;

import com.tresk.util.JsonUtil;
import com.tresk.util.SQLQueryHelper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionsDaoImpl implements QuestionsDao{

    @Autowired
	private JdbcTemplate jt;
	@Autowired
	private SQLQueryHelper helper;

	@Override
	public String getAllQuestions(String param) {
		Object[] inputs = JsonUtil.objectArrayOf(param);
		String result = JsonUtil.jsonOf(jt.queryForList(helper.getQueryByName("GET_ALL_CLASSES"),inputs));
		return result;
	}

	@Override
	public String insertQuestionStructure(String param) {
		Object[] inputs = JsonUtil.objectArrayOf(param);
		jt.update(helper.getQueryByName("INSERT_QUESTION_STRUCTURE"),inputs);
	    return "true";
	}

	@Override
	public String insertQuestion(String param) {
		Object[] inputs = JsonUtil.objectArrayOf(param);
		jt.update(helper.getQueryByName("INSERT_QUESTION"),inputs);
	    return "true";
	}

}
