package com.campinga.controller.action.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dao.AdminDao;
import com.campinga.dao.CampDao;
import com.campinga.dto.BusinessmanVO;
import com.campinga.dto.CampingVO;
import com.campinga.dto.ReservationVO;
import com.campinga.util.Paging;

public class AdminCampingListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "admin/camping/campingList.jsp";
		
		HttpSession session = request.getSession();
		String adminId = (String) session.getAttribute("loginAdmin");
		if (adminId == null)
			url = "camp.do?command=adminLogin";
		else {
			int page=1;
			
			if( request.getParameter("page")!=null) {
				page = Integer.parseInt( request.getParameter("page") );
				session.setAttribute("page", page);
			}else if( session.getAttribute("page")!=null) {
				page = (int) session.getAttribute("page");
			}else {
				session.removeAttribute("page");
			}
			String key="";
			if( request.getParameter("key")!=null) {
				key = request.getParameter("key");
				session.setAttribute("key", key);
			} else if( session.getAttribute("key")!=null ) {
				key = (String)session.getAttribute("key");
			} else {
				session.removeAttribute("key");
			}
			Paging paging = new Paging();
			paging.setPage(page);
			
			CampDao cdao = CampDao.getInstance();
			int count = cdao.getAllCount();
			paging.setTotalCount(count);

			ArrayList<BusinessmanVO> list = cdao.selectCamping( paging );
			request.setAttribute("campingList", list);
			request.setAttribute("paging", paging);
			session.setAttribute("key2", key);
		}
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
