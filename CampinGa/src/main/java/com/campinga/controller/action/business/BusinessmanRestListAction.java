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
import com.campinga.util.Paging;

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
			
			int page = 1;
			if (request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
				session.setAttribute("page", page);
			} else if (session.getAttribute("page") != null) {
				page = (Integer) session.getAttribute("page");
			} else {
				session.removeAttribute("page");
			}
			Paging paging = new Paging();
			paging.setPage(page);  
			int count = redao.getCount(bvo.getBid());
			paging.setTotalCount(count);

			ArrayList<ReservationVO> reList = redao.getBusinessRestList(bvo.getBid(), paging);
			request.setAttribute("paging", paging);
			request.setAttribute("reList", reList);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
