/**
 * 
 */
package com.app.evently.infra;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author chasisin
 *
 */
public class ApplicationProperties {
	
	private static ApplicationProperties _instance;
	private ConcurrentHashMap<String, Object> prop = new ConcurrentHashMap<String, Object>();
	
	
	public static final String APPLICATION_NAME =  "APPLICATION_NAME";
	public static final String APPLICATION_PORT = "APPLICATION_PORT";
	public static final String APPLICATION_MONGO_DB_HOST = "APPLICATION_MONGO_DB_HOST";
	public static final String APPLICATION_MONGO_DB_PORT = "APPLICATION_MONGO_DB_PORT";
	public static final String APPLICATION_DB_NAME = "APPLICATION_DB_NAME";
	
	private ApplicationProperties() {}
	
	
	public static ApplicationProperties getInstance() {
		if(_instance == null) {
			synchronized (ApplicationProperties.class){
				if(_instance == null) {
					_instance = new ApplicationProperties();
				}
				
			}
		}
		return _instance;
	}
	
	public void setProperty(String propertyName, Object propertyValue ) {
		prop.put(propertyName, propertyValue);
	}
	
	public Object getProperty(String propertyName) {
		if(prop.containsKey(propertyName)) {
			return prop.get(propertyName);
		}
		return null;
	}
}
