package com.campinga.controller.action.camping;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campinga.controller.action.Action;
import com.campinga.dao.CampDao;
import com.campinga.dto.CampingVO;

public class MainSearchAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		CampDao cdao = CampDao.getInstance();
		ArrayList<CampingVO> list = cdao.selectAddress(address1, address2);
		request.setAttribute("campList", list);
		request.getRequestDispatcher("camping/campingList.jsp").forward(request, response);
	}

}
