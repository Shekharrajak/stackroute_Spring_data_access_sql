package com.testing.java.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;

import com.mysql.jdbc.PreparedStatement;
import com.testing.java.Circle;

public class JdbcDaoImpl {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;	 
	
	@Autowired
	public void setDataSource(DataSource datasource) {
		this.dataSource = datasource;
		this.jdbcTemplateObject = new JdbcTemplate(this.dataSource);
	}
	
	public  void insertCircle(List<Circle> clist) {
		String sql = "insert into Circle(id, name) values(:id, :name)";
		
		List<Map<String, Object>> batchValues = new ArrayList<>(clist.size());
		
		for(Circle c: clist) {
			batchValues.add(
					new MapSqlParameterSource("id", c.getId())
						.addValue("name", c.getName())
						.getValues()
			);
			
		}
//		SqlParameterSource[] params = SqlParameterSourceUtils.createBatch(clist.toArray());
//		jdbcTemplateObject.batchUpdate(sql, batchValues.toArray(new Map[clist.size()]));
		int[] updateCounts = jdbcTemplateObject.batchUpdate(sql, new BatchPreparedStatementSetter() {

		    @Override
		    public int getBatchSize() {
		        return clist.size();
		    }

			@Override
			public void setValues(java.sql.PreparedStatement ps, int i) throws SQLException {
				ps.setInt(1, clist.get(i).getId());
		        ps.setString(2, clist.get(i).getName());
				
			}
		});
	}
	public List<Circle> getCircle() {
		String sql = "select * from Circle";
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		List<Circle> clist = jdbcTemplateObject.query(sql, new BeanPropertyRowMapper(Circle.class));	
//		List<Circle> clist = jdbcTemplateObject.query(sql, new BeanPropertyRowMapper(
//					ctx.getBean("circle").getClass()
//				));	
		return clist;
	}
}
