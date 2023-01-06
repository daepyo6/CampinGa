package com.campinga.controller.action.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dao.AdminDao;
import com.campinga.dao.NoticeDao;
import com.campinga.dto.NoticeVO;

public class AdminNoticeListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "admin/notice/noticeList.jsp";
		
		HttpSession session = request.getSession();
		String adminId = (String) session.getAttribute("loginAdmin");
		if (adminId == null)
			url = "camp.do?command=adminLogin";
		else {
			AdminDao adao = AdminDao.getInstance();

		

			NoticeDao Ndao = NoticeDao.getInstance();
			ArrayList<NoticeVO> list = Ndao.selectAll();
			request.setAttribute("noticeList", list);

		}
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
