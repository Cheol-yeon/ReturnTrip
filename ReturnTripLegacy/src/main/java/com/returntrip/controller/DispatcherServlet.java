package com.returntrip.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.returntrip.service.JourneyService;
import com.returntrip.service.MemberService;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("/")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private MemberService memberService = null;
	private JourneyService journeyService = null;

	private HandlerMapping mapper = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DispatcherServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		String path = request.getRequestURI();
		String viewName = null;
		// step #2. data processing ==> dispatch request to controller
		mapper = (HandlerMapping) getServletContext().getAttribute("mapper");
		Controller handler = mapper.getHandler(path);
		memberService = (MemberService) getServletContext().getAttribute("member_service");
		journeyService = (JourneyService) getServletContext().getAttribute("journey_service");

		HttpSession session = request.getSession();
		ServletContext context = session.getServletContext();

		if (handler != null) {
			viewName = handler.handleRequest(request, response, memberService, journeyService);
		}

		if (viewName == null) {
			viewName = "error.jsp";
		}

		// step #3. output processing results
		if (viewName != null && viewName != "ajax") {
			viewName = viewName.trim();
			viewName = "/WEB-INF/views/" + viewName;

			RequestDispatcher view = request.getRequestDispatcher(viewName);
			view.forward(request, response);

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
