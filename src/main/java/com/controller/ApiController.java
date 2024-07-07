package com.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/r4j")
public class ApiController {
	
	public static final String SERVICE_NAME = "myService";
	private RestTemplate restTemplate = new RestTemplate();
	
	@SuppressWarnings("unchecked")
	@GetMapping("/get")
	@CircuitBreaker(name=SERVICE_NAME, fallbackMethod = "getFallbackResponse")
	public ArrayList<Object> getResponse()
	{
		return restTemplate.getForObject("http://localhost:9000/login/getusers", ArrayList.class);
	}
	
	public ArrayList<Object> getFallbackResponse(Exception e)
	{
		return new ArrayList<>(Arrays.asList("Try","Again","Later"));
	}
}
