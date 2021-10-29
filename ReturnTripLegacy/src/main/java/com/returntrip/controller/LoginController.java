package com.returntrip.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.returntrip.entity.Member;
import com.returntrip.service.JourneyService;
import com.returntrip.service.MemberService;

public class LoginController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, MemberService memberService,
			JourneyService journeyService) {

		HttpSession session = request.getSession();
		String login_id = request.getParameter("login_id");
		String login_pw = request.getParameter("login_pw");

		System.out.println(login_id);
		System.out.println(login_pw);

		if (login_id == null) {
			return "login.jsp";
		} else if (login_id != null) {
			Member member = memberService.getMemberData(login_id);
			System.out.println(member.getName());

			session.setAttribute("login_member", member);
		}

		return "home.jsp";
	}

}
