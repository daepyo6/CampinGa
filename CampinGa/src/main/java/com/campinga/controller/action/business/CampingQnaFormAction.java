package com.campinga.controller.action.business;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dao.Camp_qnaDao;
import com.campinga.dto.BusinessmanVO;
import com.campinga.dto.Camp_qnaVO;

public class CampingQnaFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "business/mypage/qnaForm.jsp";
		HttpSession session = request.getSession();
		BusinessmanVO bvo = (BusinessmanVO) session.getAttribute("loginBusinessman");
		if( bvo == null) { 
			url = "camp.do?command=loginForm"; 
		} else {

			String qseq = request.getParameter("qseq");
			Camp_qnaDao qdao = Camp_qnaDao.getInstance();
			Camp_qnaVO qvo = qdao.getQna(Integer.parseInt(qseq));
			request.setAttribute("qnaVO", qvo);
		}
		request.getRequestDispatcher(url).forward(request, response);

	}

}