package br.com.lepsistemas.cleanarchitecturespringspark.application;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import br.com.lepsistemas.cleanarchitecturespringspark.application.starter.StarterFactory;
import br.com.lepsistemas.cleanarchitecturespringspark.application.starter.StarterStrategy;

public class Application {
	
	private Properties properties = new Properties();
	
	public static void main(String[] args) {
		Application application = new Application();
		application.run(args);
	}
	
	public void run(String[] args) {
		loadProperties();
		StarterStrategy starter = new StarterFactory(properties).getStarterStrategy();
		starter.run(args);
	}
	
	private void loadProperties() {
		try {
			InputStream inStream = Application.class.getClassLoader().getResourceAsStream("application.properties");
			properties.load(inStream);
		} catch (IOException e) {
			throw new IllegalArgumentException("Application properties not configured.");
		}
	}

}
