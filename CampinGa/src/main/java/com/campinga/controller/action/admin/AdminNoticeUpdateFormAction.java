package com.campinga.controller.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dao.NoticeDao;
import com.campinga.dto.NoticeVO;

public class AdminNoticeUpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "admin/notice/noticeUpdate.jsp";
		
		HttpSession session = request.getSession();
		String avo = (String)session.getAttribute("loginAdmin");
		if( avo == null) { 
			url = "shop.do?command=admin"; 
		}else {
			
			int nseq = Integer.parseInt( request.getParameter("nseq") );
			
			NoticeDao ndao = NoticeDao.getInstance();
			NoticeVO nvo = ndao.getNotice(nseq);
			
			request.setAttribute("noticeVO", nvo);
			
			
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}
