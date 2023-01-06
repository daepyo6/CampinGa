package com.campinga.controller.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dao.AdminDao;

public class AdminNoticeWriteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "admin/notice/noticeWrite.jsp";
		
		HttpSession session = request.getSession();
		String loginAdmin = (String)session.getAttribute("loginAdmin");
		if( loginAdmin == null) { 
			url = "camp.do?command=admin";
		}else {
			  AdminDao adao = AdminDao.getInstance();
			
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}
