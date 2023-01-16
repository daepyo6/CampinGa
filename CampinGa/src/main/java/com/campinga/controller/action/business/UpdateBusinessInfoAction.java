package com.campinga.controller.action.business;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dao.BusinessmanDao;
import com.campinga.dto.BusinessmanVO;

public class UpdateBusinessInfoAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "camp.do?command=businessmanMypage";
		
		HttpSession session = request.getSession();
		BusinessmanVO bvo = (BusinessmanVO) session.getAttribute("loginBusinessman");
		int bseq = bvo.getBseq();
		if( bvo == null ) {
			url = "camp.do?command=loginForm";
		} else {
			bvo = new BusinessmanVO();
			BusinessmanDao bdao = BusinessmanDao.getInstance();
			bvo.setBseq(bseq);
			bvo.setBid(request.getParameter("bid"));
			bvo.setName(request.getParameter("name"));
			bvo.setPhone(request.getParameter("phone"));
			bvo.setEmail(request.getParameter("email"));
			bvo.setBseq(bvo.getBseq());
			bdao.updateUserInfo(bvo);
			
			session.setAttribute("loginBusinessman", bvo);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
