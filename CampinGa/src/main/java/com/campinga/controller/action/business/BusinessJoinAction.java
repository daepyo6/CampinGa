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
		// address부분 후에 수정 필요(도/시에따라서 시/군이 변하도록 수정해야함)
		String caddress1 = request.getParameter("caddress1");
		if(caddress1.equals("1")) caddress1 = "서울시";
		else if(caddress1.equals("2")) caddress1 = "경기도";
		
		String caddress2 = request.getParameter("caddress2");
		if(caddress2.equals("1")) caddress1 = "가평군";
		else if(caddress2.equals("2")) caddress1 = "김포시";
		
		BusinessmanVO bvo = new BusinessmanVO();
		bvo.setBid(request.getParameter("id"));
		bvo.setName(request.getParameter("name"));
		bvo.setPwd(request.getParameter("pwd"));
		bvo.setCname(request.getParameter("cname"));
		bvo.setPhone(request.getParameter("phone"));
		bvo.setEmail(request.getParameter("email"));
		bvo.setCaddress3(request.getParameter("caddress3"));
		bvo.setCaddress1(caddress1);
		bvo.setCaddress2(caddress2);	
		
		BusinessmanDao bdao = BusinessmanDao.getInstance();
		bdao.insertBusiness(bvo);
		
		response.sendRedirect("camp.do?command=loginForm");
	}
}
