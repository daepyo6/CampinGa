package com.campinga.controller.action.admin;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dao.AdminDao;
import com.campinga.dto.NoticeVO;


public class AdminNoticeUpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "camp.do?command=adminNoticeDetail";
		HttpSession session = request.getSession();
		String avo = (String)session.getAttribute("loginAdmin");
		if( avo == null) url = "camp.do?command=admin"; 
		else {
			
			NoticeVO nvo = new NoticeVO();
			nvo.setNseq(Integer.parseInt( request.getParameter("nseq") ));
			nvo.setContent(request.getParameter("content"));
			nvo.setSubject(request.getParameter("subject"));
		  
		    AdminDao adao = AdminDao.getInstance();
		    adao.updateNotice(nvo);
		  
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}
