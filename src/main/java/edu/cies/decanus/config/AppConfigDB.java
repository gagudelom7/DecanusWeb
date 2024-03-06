package edu.cies.decanus.config;

import org.springframework.jdbc.core.JdbcTemplate;

public interface AppConfigDB {

	public JdbcTemplate getTemplate();
	
}
