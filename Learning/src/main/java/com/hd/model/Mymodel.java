package com.hd.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.zaxxer.hikari.HikariDataSource;

public class Mymodel 
{

	public JdbcTemplate Jdbctemplate;
	
	@Autowired
	public void setJdbctemplate(HikariDataSource Datasource) 
	{
		Jdbctemplate = new JdbcTemplate(Datasource);
	}
	
	public void user_detail(String message) 
	{		
		System.out.println(message);
		
		System.out.println("---------------------------");
		 
		JsonObject js = new JsonObject();

		JsonParser parser = new JsonParser();
		 
		js = parser.parse(message).getAsJsonObject();
		
		String name;
	}
}
