package com.springboot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WelcomeService {
	@Value("${welcome.message}")
	private String welcomeMessage;

	public String retriveWelcomeMessage() {
		return welcomeMessage;
	}
}