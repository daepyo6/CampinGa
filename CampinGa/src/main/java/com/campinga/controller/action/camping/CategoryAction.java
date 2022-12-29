package com.campinga.controller.action.camping;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campinga.controller.action.Action;
import com.campinga.dao.CampDao;
import com.campinga.dto.CampingVO;

public class CategoryAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//auto=1, camping=2, caravane=3, campnic=4
		int category = Integer.parseInt(request.getParameter("category"));
		String kind = "";
		if(category==1) kind = "auto";
		else if(category==2) kind = "camping";
		else if(category==3) kind = "caravane";
		else if(category==4) kind = "campnic";
		CampDao cdao = CampDao.getInstance();
		ArrayList<CampingVO> list = cdao.selectCategory(kind);
		request.setAttribute("campList", list);
		request.getRequestDispatcher("camping/campingList.jsp").forward(request, response);
	}
}
