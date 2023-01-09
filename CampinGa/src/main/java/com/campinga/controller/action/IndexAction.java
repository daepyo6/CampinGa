package com.campinga.controller.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campinga.dao.CampDao;
import com.campinga.dto.CampingVO;

public class IndexAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// 새롭게 등록된 캠핑장 4곳을 시간순으로 뽑아 정렬
		CampDao cdao = CampDao.getInstance();
		ArrayList<CampingVO> newCampList = cdao.selectNewCampList(); 
		
		request.setAttribute("newCampList", newCampList);
		// 즐겨찾기 많이된 캠핑장을 순서로 정렬
		// "recoCampList"이름으로 camp 리스트 보내주세요.
		
		
		
		request.getRequestDispatcher("main.jsp").forward(request, response);

			
	}

}
