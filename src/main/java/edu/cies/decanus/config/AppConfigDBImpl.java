package edu.cies.decanus.config;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class AppConfigDBImpl implements AppConfigDB{
  private DataSource dataSource;
	
	public AppConfigDBImpl(DataSource dataSource){
		this.dataSource=dataSource;
	}
	
	@Override
	public JdbcTemplate getTemplate() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(this.dataSource);
		return jdbcTemplate;
	}

}
