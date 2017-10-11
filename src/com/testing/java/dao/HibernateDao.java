package com.testing.java.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.testing.java.Circle;

public class HibernateDao {
	public int getCircleCount() {
		String sql = "select count(*) from Circle";
//		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		//int count = jdbcTemplateObject.query(sql, new BeanPropertyRowMapper(Circle.class));	
//		List<Circle> clist = jdbcTemplateObject.query(sql, new BeanPropertyRowMapper(
//					ctx.getBean("circle").getClass()
//				));	
		return 0;
	}
}
