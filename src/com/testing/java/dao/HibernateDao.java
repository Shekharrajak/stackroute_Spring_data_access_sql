package com.testing.java.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import com.testing.java.Circle;

import org.hibernate.SessionFactory;
import org.hibernate.Query;


@Repository
public class HibernateDao {
	@Autowired
	private SessionFactory sessionFactory;
	public int getCircleCount() {
		String sql = "select count(*) from Circle";
//		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		//int count = jdbcTemplateObject.query(sql, new BeanPropertyRowMapper(Circle.class));	
//		List<Circle> clist = jdbcTemplateObject.query(sql, new BeanPropertyRowMapper(
//					ctx.getBean("circle").getClass()
//				));	
		Query query = getSessionFactory().openSession().createQuery(sql);
		int count = ((Long)query.uniqueResult()).intValue();
		return 0;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
