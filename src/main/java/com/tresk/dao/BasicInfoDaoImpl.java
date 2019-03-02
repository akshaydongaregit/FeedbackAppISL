package com.tresk.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.tresk.dto.Clazz;
import com.tresk.util.JsonUtil;
import com.tresk.util.SQLQueryHelper;

@Repository
public class BasicInfoDaoImpl implements BasicInfoDao{

	@PersistenceContext //(type=PersistenceContextType.EXTENDED)
	private EntityManager em ;

	@Autowired
	private JdbcTemplate jt;
	@Autowired
	private SQLQueryHelper helper;

	public Clazz addClass(Clazz clazz) {

		System.out.println(helper.getQueryByName("INSERT_CLASS"));
		jt.update(helper.getQueryByName("INSERT_CLASS"),new Object[]{clazz.getClassId(),clazz.getClassName(),clazz.getIsActive()});

		return clazz;
	}

	//dynamic methods
	@Override
	public String addClass(String param) {
		System.out.println(param);
		Object[] inputs = JsonUtil.objectArrayOf(param);
		jt.update(helper.getQueryByName("INSERT_CLASS"),inputs);

		return param;
	}

	@Override
	public String getClass(String param) {

		Object[] inputs = JsonUtil.objectArrayOf(param);
		String result = JsonUtil.jsonOf(jt.queryForList(helper.getQueryByName("GET_CLASS"),inputs));

		return result;
	}

	@Override
	public String getAllClasses(String param) {

		Object[] inputs = JsonUtil.objectArrayOf(param);
		String result = JsonUtil.jsonOf(jt.queryForList(helper.getQueryByName("GET_ALL_CLASSES"),inputs));
		return result;
	}

}
