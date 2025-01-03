package com.curso.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
/**
 * Clase de configuración de Spring que define los beans necesarios para la aplicación.
 * @author Sergio Castro
 * @version 1.0 2024/12/31
 */
@Configuration
public class AppConfig {
	
	@Bean
	RestTemplate restTemplate() {
		RestTemplate restTemplate = new RestTemplate(); 
		restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
		return restTemplate;
	}

}
