package com.campinga.controller.action.business;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campinga.controller.action.Action;
import com.campinga.dao.BusinessmanDao;
import com.campinga.dto.BusinessmanVO;

public class BusinessJoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String caddress1 = request.getParameter("caddress1");
		String[] sido = {"","서울","부산","대구","인천","광주","대전","울산","강원",
				         "경기","경남","경북","전남","전북","제주","충남","충북"};
		caddress1 = sido[Integer.parseInt(caddress1)];		
		
		BusinessmanVO bvo = new BusinessmanVO();
		bvo.setBid(request.getParameter("id"));
		bvo.setName(request.getParameter("name"));
		bvo.setPwd(request.getParameter("pwd"));
		bvo.setCname(request.getParameter("cname"));
		bvo.setPhone(request.getParameter("phone"));
		bvo.setEmail(request.getParameter("email"));
		bvo.setCaddress3(request.getParameter("caddress3"));
		bvo.setCaddress2(request.getParameter("caddress2"));
		bvo.setCaddress1(caddress1);
		
		BusinessmanDao bdao = BusinessmanDao.getInstance();
		bdao.insertBusiness(bvo);
		
		response.sendRedirect("camp.do?command=loginForm");
	}
}
