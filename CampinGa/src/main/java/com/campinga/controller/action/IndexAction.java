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
		
		// ���Ӱ� ��ϵ� ķ���� 4���� �ð������� �̾� ����
		CampDao cdao = CampDao.getInstance();
		ArrayList<CampingVO> newCampList = cdao.selectNewCampList(); 
		
		request.setAttribute("newCampList", newCampList);
		// ���ã�� ���̵� ķ������ ������ ����
		// "recoCampList"�̸����� camp ����Ʈ �����ּ���.
		
		
		
		request.getRequestDispatcher("main.jsp").forward(request, response);

			
	}

}
