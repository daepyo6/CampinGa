package com.campinga.controller.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;

public class LogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser") != null)
			session.removeAttribute("loginUser");
		else if(session.getAttribute("loginBusinessman") != null)
			session.removeAttribute("loginBusinessman");
		
		RequestDispatcher dp = request.getRequestDispatcher("camp.do?command=index");
		dp.forward(request, response);
	}
}
