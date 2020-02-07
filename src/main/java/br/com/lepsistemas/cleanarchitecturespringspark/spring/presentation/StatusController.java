package br.com.lepsistemas.cleanarchitecturespringspark.spring.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/status")
public class StatusController {
	
	@GetMapping
	public String get() {
		return "OK";
	}

}
