package com.campinga.controller.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dao.NoticeDao;
import com.campinga.dto.NoticeVO;


public class AdminNoticeDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
        String url = "admin/notice/noticeDetail.jsp";
		
		int nseq = Integer.parseInt( request.getParameter("nseq") );
		
		HttpSession session = request.getSession();
		String avo = (String)session.getAttribute("loginAdmin");
		if( avo == null) { 
			url = "camp.do?command=admin"; 
		} else {
			NoticeDao ndao = NoticeDao.getInstance();
			NoticeVO nvo = ndao.getNotice(nseq);
			request.setAttribute("noticeVO", nvo);
		}
		request.getRequestDispatcher(url).forward(request, response);
		}

	

}
