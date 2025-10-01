package com.hd.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hd.repo.USER_TABLE;
import com.zaxxer.hikari.HikariDataSource;


@Component
public class Mymodel 
{

	public JdbcTemplate Jdbctemplate;
	
	@Autowired
	public void setJdbctemplate(HikariDataSource Datasource) 
	{
		Jdbctemplate = new JdbcTemplate(Datasource);
	}
	
	
	public JsonObject user_detail(String message) 
	{	
		JsonObject detail = new JsonObject();
		
		try {
			
			
			System.out.println(message);
			
			System.out.println("---------------------------");
			 
			JsonObject js = new JsonObject();

			JsonParser parser = new JsonParser();
			 
			js = parser.parse(message).getAsJsonObject();
			
			String name = js.get("name").getAsString();
			String age = js.get("age").getAsString();
			
			System.out.println(name);
			
			System.out.println(age);
			
			String sql = "INSERT INTO USER_TABLE (username, user_age) VALUES (?, ?)";
				 																						
			Jdbctemplate.update(sql, name, age);
			
			detail.addProperty("name", name);
			detail.addProperty("status", "success");
			
		} catch (Exception e) {
			// TODO: handle exception
			
			System.err.println("Error while processing the request: " + e.getMessage());
            e.printStackTrace();
            
		}
		return detail;


	}
	
	
	
	private class user_mapper implements RowMapper<USER_TABLE>  
    {
		public USER_TABLE mapRow(ResultSet rs, int rowNum) throws SQLException
		{
			USER_TABLE Info = new USER_TABLE(); 
			
			Info.setUser_age(rs.getString("username"));
			Info.setUser_age(rs.getString("user_age"));

			return Info;
		}
    }
	
}
