package com.campinga.controller.action.business;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dao.BusinessmanDao;
import com.campinga.dto.BusinessmanVO;

public class DeleteBusinessmanAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "camp.do?command=index";
		
		HttpSession session = request.getSession();
		BusinessmanVO bvo = (BusinessmanVO) session.getAttribute("loginBusinessman");

		if( bvo == null ) {
			url = "camp.do?command=loginForm";
		} else {
			BusinessmanDao bdao = BusinessmanDao.getInstance();
			bdao.deletebusinessman( bvo.getBid() );
			request.setAttribute("message", "Å»ÅðµÇ¾ú½À´Ï´Ù.");
			session.removeAttribute("loginBusinessman");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
