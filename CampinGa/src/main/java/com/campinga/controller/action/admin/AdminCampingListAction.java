package com.campinga.controller.action.admin;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dao.CampDao;
import com.campinga.dto.CampingVO;

public class AdminCampingListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String url = "admin/restaurant/restList.jsp";
		
		HttpSession session = request.getSession();
		String adminId = (String) session.getAttribute("loginAdmin");
		if (adminId == null)
			url = "camp.do?command=adminLogin";
		else {
			CampDao cdao = CampDao.getInstance();
			ArrayList<CampingVO> list = cdao.selectCamping();
			request.setAttribute("campingList", list);
		}
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
