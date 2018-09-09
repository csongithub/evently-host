/**

 * 
 */
package com.app.evently.infra;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import com.mongodb.MongoClient;

/**
 * @author chasisin
 *
 */
public class EventlyMongoConfig {
	
	private static EventlyMongoConfig _instance;
	
	private MongoOperations mongoOperation = null;
	
	
	private EventlyMongoConfig() {
		
	}
	
	public static EventlyMongoConfig getInstance() {
		if(_instance == null) {
			synchronized (EventlyMongoConfig.class) {
				if(_instance == null) {
					_instance = new EventlyMongoConfig();
				}
			}
		}
		return _instance;
	}
	
	public MongoOperations getMongoOperation() {
		if(mongoOperation == null) {
			ApplicationProperties applicationProperties = ApplicationProperties.getInstance();
			String mongoHost = (String)applicationProperties.getProperty(ApplicationProperties.APPLICATION_MONGO_DB_HOST);
			Integer mongoPort = (Integer)applicationProperties.getProperty(ApplicationProperties.APPLICATION_MONGO_DB_PORT);
			String dbName = (String)applicationProperties.getProperty(ApplicationProperties.APPLICATION_DB_NAME);
			MongoTemplate mongoTemplate = new MongoTemplate(new MongoClient(mongoHost, mongoPort), dbName);
			mongoOperation =  (MongoOperations)mongoTemplate;
		}
		return mongoOperation;
	}

}
