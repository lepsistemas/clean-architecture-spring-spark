package br.com.lepsistemas.cleanarchitecturespringspark.spark;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import br.com.lepsistemas.cleanarchitecturespringspark.application.Application;
import br.com.lepsistemas.cleanarchitecturespringspark.application.starter.StarterStrategy;
import spark.Spark;

public class SparkStarter implements StarterStrategy {
	
	private Properties properties = new Properties();
	private Routes routes = new Routes();
	
	@Override
	public void run(String[] args) {
		loadProperties();
		Spark.port(Integer.valueOf(properties.get("server.port").toString()));
		routes.create();
	}
	
	private void loadProperties() {
		try {
			InputStream inStream = Application.class.getClassLoader().getResourceAsStream("spark.properties");
			properties.load(inStream);
		} catch (IOException e) {
			throw new IllegalArgumentException("Application properties not configured.");
		}
	}

}
