package com.returntrip.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.returntrip.entity.Journey;
import com.returntrip.service.JourneyService;
import com.returntrip.service.MemberService;

public class JourneyController implements Controller {


	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, MemberService memService,
			JourneyService journeyService) {
		String viewName = null;
		String method = request.getMethod().toUpperCase();
		
		if(method.equals("GET")) {
			String place = request.getParameter("place");
			Journey journey = journeyService.getJourneyData(place);
			System.out.println(journey);
			request.setAttribute("journey", journey);
//			List<Journey> list = journeyService.getJourneyDatas(place);
//			
//			request.setAttribute("list", list);
			viewName ="journey.jsp";
		}
		return viewName;
	}

}
