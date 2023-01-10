package com.campinga.controller.action.business;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campinga.controller.action.Action;

public class BusinessmanEditFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("business/mypage/updateInfo.jsp").forward(request, response);
		

	}

}
