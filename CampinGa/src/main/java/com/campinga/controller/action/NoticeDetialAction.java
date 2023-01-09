package com.campinga.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campinga.dao.NoticeDao;
import com.campinga.dto.NoticeVO;

public class NoticeDetialAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		  String url = "notice/noticeDetail.jsp";
	      
	      int nseq = Integer.parseInt( request.getParameter("nseq") );
	      
	      NoticeDao ndao = NoticeDao.getInstance();
	      NoticeVO nvo = ndao.getNotice(nseq);
	      request.setAttribute("noticeVO", nvo);
	      request.getRequestDispatcher(url).forward(request, response);
	}
}
