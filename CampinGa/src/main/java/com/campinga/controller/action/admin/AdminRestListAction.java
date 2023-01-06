package com.campinga.controller.action.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dao.AdminDao;
import com.campinga.dto.ReservationVO;
import com.campinga.util.Paging;

public class AdminRestListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "admin/campingrest/campingRestList.jsp";
		
		HttpSession session = request.getSession();
		String avo = (String)session.getAttribute("loginAdmin");
		if( avo == null) {
			url = "camp.do?command=admin";
		}else {
			
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
			
			AdminDao adao = AdminDao.getInstance();
			int count = adao.getAllCount("reservation", "reseq", key);
			paging.setTotalCount(count);
			
			ArrayList<ReservationVO> list = adao.selectRest( paging, key );
			request.setAttribute("restList", list);
			request.setAttribute("paging", paging);
			session.setAttribute("key2", key);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
