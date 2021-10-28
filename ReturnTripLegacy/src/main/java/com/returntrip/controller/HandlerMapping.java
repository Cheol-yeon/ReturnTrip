package com.returntrip.controller;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {
	private Map<String, Controller> handlerMapper = null;
	
	public HandlerMapping() {
		handlerMapper = new HashMap<String, Controller>();
		
		handlerMapper.put("/home", new HomeController());
		handlerMapper.put("/join", new JoinController());
		handlerMapper.put("/login", new LoginController());
		handlerMapper.put("/journey", new JourneyController());

	}
	
	public Controller getHandler(String path) {
		System.out.println(path);
		return handlerMapper.get(path);
	}
}