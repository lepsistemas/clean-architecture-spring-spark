package br.com.lepsistemas.cleanarchitecturespringspark.application.starter;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

import java.util.Properties;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import br.com.lepsistemas.cleanarchitecturespringspark.application.starter.StarterFactory;
import br.com.lepsistemas.cleanarchitecturespringspark.application.starter.StarterStrategy;
import br.com.lepsistemas.cleanarchitecturespringspark.spring.SpringStarter;

@ExtendWith(MockitoExtension.class)
public class StarterFactoryTest {
	
	private static final String APP_STARTER = "app.starter";
	
	@Mock
	private Properties properties;
	
	@Test
	public void should_create_spring_starter_strategy() {
		when(properties.get(APP_STARTER)).thenReturn("spring");
		
		StarterStrategy starter = new StarterFactory(properties).getStarterStrategy();
		
		assertThat(starter).isInstanceOf(SpringStarter.class);
	}
	
	@Test
	public void should_throw_exception_when_trying_to_start_with_other_than_spring_or_spark() {
		when(properties.get(APP_STARTER)).thenReturn("quarkus");
		
		assertThatThrownBy(() -> {
			new StarterFactory(properties).getStarterStrategy();
		})
		.isInstanceOf(UnsupportedOperationException.class)
		.hasMessage("Application starter not configured properly. Choose one between Spring and Spark.");
	}

}
