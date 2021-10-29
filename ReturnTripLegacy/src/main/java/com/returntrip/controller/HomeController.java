package com.returntrip.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.returntrip.service.JourneyService;
import com.returntrip.service.MemberService;

public class HomeController implements Controller {

	
	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, MemberService memberService, JourneyService journeyService) {
		
		HttpSession session = request.getSession();
		String path = request.getRequestURI();
		System.out.println("IN HOME CONTROLLER");
		System.out.println("path = " + path);
		if (path.equals("/home/logout")) {
			String test = null;
			System.out.println("test = null");
			session.setAttribute("login_member", test);
		}
		
		return "home.jsp";
		}

}
