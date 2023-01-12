package com.campinga.controller.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campinga.controller.action.Action;

public class JoinFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String user = request.getParameter("user");
		String url = "camp.do?command=index";
		if(user.equals("1")) {
			url = "member/joinForm.jsp";
		} else if(user.equals("2")) {
			url = "business/joinForm.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
