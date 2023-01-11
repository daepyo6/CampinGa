package com.campinga.controller.action.business;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dao.CampDao;
import com.campinga.dto.BusinessmanVO;
import com.campinga.dto.CampingVO;

public class BusinessmanCampingtListInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "camp.do?command=businessmanCampingList";

		HttpSession session = request.getSession();
		BusinessmanVO bvo = (BusinessmanVO) session.getAttribute("loginBusinessman");
		
		if( bvo == null ) {
			url = "camp.do?command=loginForm";
		} else {
			BusinessmanVO bmvo = new BusinessmanVO();
			bmvo.setCname(request.getParameter("cname"));
			bmvo.setCaddress1(request.getParameter("caddress1"));
			bmvo.setCaddress2(request.getParameter("caddress2"));
			bmvo.setCaddress3(request.getParameter("caddress3"));
			bmvo.setCategory(request.getParameter("category"));
			bmvo.setFacilities(request.getParameter("facilities"));
			
			CampDao cdao = CampDao.getInstance();
			cdao.insertList(bmvo);
		}
		response.sendRedirect(url);

	}

}
