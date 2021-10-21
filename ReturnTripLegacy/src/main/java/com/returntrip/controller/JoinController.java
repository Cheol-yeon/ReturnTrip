package com.returntrip.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.returntrip.entity.Member;
import com.returntrip.service.JourneyService;
import com.returntrip.service.MemberService;

public class JoinController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response, MemberService memberService,
			JourneyService journeyService) {

		Member member = new Member();

		String id = request.getParameter("joinId");
		String pwd = request.getParameter("joinPw");
		String pwdcheck = request.getParameter("joinPwCheck");
		String name = request.getParameter("joinName");
		String email = request.getParameter("joinEmail");

		System.out.println(id);
		System.out.println(pwd);
		System.out.println(pwdcheck);
		System.out.println(name);
		System.out.println(email);
		
		if (id == null) {
			return "join.jsp";
		} else if (pwd == pwdcheck || id != null) {
			System.out.println("else if");
			member.setId(id);
			member.setPwd(pwd);
			member.setName(name);
			member.setEmail(email);

			System.out.println("---------------------");
			System.out.println(member.getId());
			System.out.println(member.getPwd());
			System.out.println(member.getName());
			System.out.println(member.getEmail());
			System.out.println("---------------------");

			memberService.insertMember(member);
		}
		return "home.jsp";
	}

}
