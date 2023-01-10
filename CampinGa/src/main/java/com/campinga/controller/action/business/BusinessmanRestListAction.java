package com.campinga.controller.action.business;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dao.ReservationDao;
import com.campinga.dto.BusinessmanVO;
import com.campinga.dto.ReservationVO;

public class BusinessmanRestListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "business/reservation/businessmanRestList.jsp";
		
		HttpSession session = request.getSession();
		BusinessmanVO bvo = (BusinessmanVO) session.getAttribute("loginBusinessman");
		
		if( bvo == null ) {
			url = "camp.do?command=loginForm";
		} else {
			ReservationDao redao = ReservationDao.getInstance();
			ArrayList<ReservationVO> reList = redao.getBusinessRestList(bvo.getBid());
			request.setAttribute("reList", reList);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
