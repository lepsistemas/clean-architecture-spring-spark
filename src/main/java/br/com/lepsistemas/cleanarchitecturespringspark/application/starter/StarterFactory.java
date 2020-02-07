package br.com.lepsistemas.cleanarchitecturespringspark.application.starter;

import java.util.Properties;

import br.com.lepsistemas.cleanarchitecturespringspark.spark.SparkStarter;
import br.com.lepsistemas.cleanarchitecturespringspark.spring.SpringStarter;

public class StarterFactory {
	
	private static final String APP_STARTER = "app.starter";
	
	private Properties properties;
	
	public StarterFactory(Properties properties) {
		this.properties = properties;
	}

	public StarterStrategy getStarterStrategy() {
		String starter = (properties.get(APP_STARTER)).toString();
		
		if (starter.equalsIgnoreCase(Starter.SPRING.name())) {
			return new SpringStarter();
		}
		
		if (starter.equalsIgnoreCase(Starter.SPARK.name())) {
			return new SparkStarter();
		}
		
		throw new UnsupportedOperationException("Application starter not configured properly. Choose one between Spring and Spark.");
	}

}
