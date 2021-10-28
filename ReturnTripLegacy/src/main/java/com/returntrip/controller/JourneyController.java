package com.returntrip.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
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
		ServletContext context = request.getSession().getServletContext();
		Journey journey = new Journey();

		String place = request.getParameter("place");
		context.setAttribute("city", place);
		String selectBtn = request.getParameter("page");
		System.out.println("SELECT BTN = " + selectBtn);

		List<Journey> journeyList = journeyService.getJourneyDatas(place);
		System.out.println(journeyList);

		double journeySize = journeyList.size();
		System.out.println((int) journeySize);

		int Last_Page = (int) Math.ceil(journeySize / 5);
		System.out.println(Last_Page);

		if (selectBtn == null || place != null) {
			selectBtn = "1";
			journeyList.subList(1 + (Integer.parseInt(selectBtn) - 1) * 5 - 1, Integer.parseInt(selectBtn) + 4);
			System.out.println((Integer.parseInt(selectBtn) - 1) * 5);
			System.out.println((Integer.parseInt(selectBtn) * 5 - 1));
			System.out.println(journeyList);
		} else if (selectBtn != null && place != null) {
			journeyList.subList(1 + (Integer.parseInt(selectBtn) - 1) * 5 - 1, Integer.parseInt(selectBtn) + 4);
			System.out.println((Integer.parseInt(selectBtn) - 1) * 5);
			System.out.println((Integer.parseInt(selectBtn) * 5 - 1));
			System.out.println(journeyList);
		}

		context.setAttribute("Last_Page", Last_Page);
		context.setAttribute("journeySize", (int) journeySize);
		context.setAttribute("journeyList", journeyList);
//			List<Journey> list = journeyService.getJourneyDatas(place);
//			
//			request.setAttribute("list", list);

		return "searchResult.jsp";
	}

}
