package com.campinga.controller.action.camping;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campinga.controller.action.Action;
import com.campinga.dao.CampDao;
import com.campinga.dto.BusinessmanVO;
import com.campinga.dto.CampingVO;

public class CategoryAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String url = "camping/campingList.jsp";
		ArrayList<BusinessmanVO> list = null;
		// All=1, ����ķ��=2, ķ��=3, ī���=4, ķ����=5
		int category = Integer.parseInt(request.getParameter("kind"));
		String kind = "";
		CampDao cdao = CampDao.getInstance();
		if (category == 1) {
			list = cdao.selectAll();
			request.setAttribute("campList", list);
		} else if (category == 2) {
			kind = "����ķ��";
			list = cdao.selectCategory(kind);
		} else if (category == 3) {
			kind = "ķ��";
			list = cdao.selectCategory(kind);
		} else if (category == 4) {
			kind = "ī���";
			list = cdao.selectCategory(kind);
		} else if (category == 5) {
			kind = "ķ����";
			list = cdao.selectCategory(kind);
		}
		request.setAttribute("campList", list);
		request.getRequestDispatcher(url).forward(request, response);
	}
}
