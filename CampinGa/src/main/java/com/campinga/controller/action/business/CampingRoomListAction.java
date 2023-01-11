package com.campinga.controller.action.business;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dao.BusinessmanDao;
import com.campinga.dao.CampDao;
import com.campinga.dto.BusinessmanVO;
import com.campinga.dto.CampingVO;

public class CampingRoomListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "business/room/campingRoomList.jsp";

		HttpSession session = request.getSession();
		BusinessmanVO bvo = (BusinessmanVO) session.getAttribute("loginBusinessman");
		
		if(bvo == null){
			url = "camp.do?command=loginForm";
		} else {
			int bseq = bvo.getBseq();
			CampDao cdao = CampDao.getInstance();
			ArrayList<CampingVO> campingList = cdao.selectCampingList(bseq);
			request.setAttribute("campingList", campingList);
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}
