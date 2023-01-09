package com.campinga.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.dao.AdminDao;
import com.campinga.dao.NoticeDao;
import com.campinga.dto.NoticeVO;
import com.campinga.util.Paging;

public class NoticeListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String url = "notice/noticeList.jsp";
		NoticeDao ndao = NoticeDao.getInstance();
		int page = 1;
		HttpSession session = request.getSession();
		if(request.getParameter("page")!=null) {
			page=Integer.parseInt(request.getParameter("page"));
			session.setAttribute("page", page);
		}else if(session.getAttribute("page")!=null) {
			page = (Integer)session.getAttribute("page");
		}else {
			session.removeAttribute("page");
		}
		
		Paging paging = new Paging();
		paging.setPage(page);
		int count = ndao.getCount();
		paging.setTotalCount(count);		
		
		ArrayList<NoticeVO> list = ndao.selectAll(paging);
		request.setAttribute("noticeList", list);
		request.setAttribute("paging", paging);
		
		request.getRequestDispatcher(url).forward(request, response);
	}
}
