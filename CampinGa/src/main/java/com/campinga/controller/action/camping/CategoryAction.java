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
		//All=1, auto=2, camping=3, caravane=4, campnic=5
		int category = Integer.parseInt(request.getParameter("kind"));
		String kind = "";
		CampDao cdao = CampDao.getInstance();
		if(category==1) {
			ArrayList<CampingVO> list = cdao.selectAll();
			request.setAttribute("campList", list);
			request.getRequestDispatcher("camping/campingList.jsp").forward(request, response);
		} else if(category==2) kind = "auto";
		else if(category==3) kind = "camping";
		else if(category==4) kind = "caravane";
		else if(category==5) kind = "campnic";
		
		ArrayList<CampingVO> list = cdao.selectCategory(kind);
		request.setAttribute("campList", list);
		request.getRequestDispatcher("camping/campingList.jsp").forward(request, response);
	}
}
