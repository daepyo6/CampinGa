package com.campinga.controller.action.business;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dao.Camp_qnaDao;
import com.campinga.dao.MemberDao;
import com.campinga.dao.ReservationDao;
import com.campinga.dto.BusinessmanVO;
import com.campinga.dto.Camp_qnaVO;
import com.campinga.dto.MemberVO;
import com.campinga.dto.ReservationVO;

public class BusinessmanMypageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "business/mypage/mypage.jsp";
		
		HttpSession session = request.getSession();
		BusinessmanVO bvo = (BusinessmanVO) session.getAttribute("loginBusinessman");
		
		if(bvo == null ) {
			url = "camp.do?command=loginForm";
		} else {
			
		}
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
