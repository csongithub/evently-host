/**
 * 
 */
package com.app.evently.infra;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author chasisin
 *
 */
@Configuration
public class ApplicationPropertiesInitializer{
	
	//Application Configurations
	@Value("${spring.application.name}")
	public String spring_application_name;
	
	@Value("${server.port}")
	public String server_port;
	
	//Mongo DB Configurations
	@Value("${spring.data.mongodb.host}")
	public String spring_data_mongodb_host;
	
	@Value("${spring.data.mongodb.port}")
	public Integer spring_data_mongodb_port;
	
	@Value("${spring.data.mongodb.database}")
	public String spring_data_mongodb_database;
	
	@Bean
	public Boolean initialize() {
		ApplicationProperties applicationProperties = ApplicationProperties.getInstance();
		applicationProperties.setProperty(ApplicationProperties.APPLICATION_NAME, spring_application_name);
		applicationProperties.setProperty(ApplicationProperties.APPLICATION_PORT, server_port);
		applicationProperties.setProperty(ApplicationProperties.APPLICATION_MONGO_DB_HOST, spring_data_mongodb_host);
		applicationProperties.setProperty(ApplicationProperties.APPLICATION_MONGO_DB_PORT, spring_data_mongodb_port);
		applicationProperties.setProperty(ApplicationProperties.APPLICATION_DB_NAME, spring_data_mongodb_database);
		return Boolean.TRUE;
	}

}
