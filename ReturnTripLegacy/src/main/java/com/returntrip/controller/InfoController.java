package com.returntrip.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.returntrip.entity.Journey;
import com.returntrip.service.JourneyService;
import com.returntrip.service.MemberService;

public class InfoController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, MemberService memberService,
			JourneyService journeyService) {
		ServletContext context = request.getSession().getServletContext();
		String placeNumber = request.getParameter("placeNumber");
		
		Journey journey = new Journey();
		journey = journeyService.getJourneyData(placeNumber);
		
		context.setAttribute("journeyInfo", journey);
		
		return "journeyInfo.jsp";
	}

}
