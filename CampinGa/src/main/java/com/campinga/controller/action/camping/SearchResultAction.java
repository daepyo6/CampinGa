package com.campinga.controller.action.camping;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campinga.controller.action.Action;
import com.campinga.dao.CampDao;
import com.campinga.dto.CampingVO;

public class SearchResultAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String key = request.getParameter("key");
		CampDao cdao = CampDao.getInstance();
		// 캠프 이름으로 검색
		ArrayList<CampingVO> list = cdao.selectName(key);
		request.setAttribute("campList", list);
		request.getRequestDispatcher("camping/campingList.jsp").forward(request, response);
	}
}
