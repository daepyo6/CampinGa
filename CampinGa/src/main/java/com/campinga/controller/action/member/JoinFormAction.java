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
		String url = "camp.do?command=contractForm";
		request.getRequestDispatcher(url).forward(request, response);
	}
}
