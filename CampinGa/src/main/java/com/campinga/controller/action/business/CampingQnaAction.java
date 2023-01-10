package com.campinga.controller.action.business;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dao.BusinessmanDao;
import com.campinga.dao.Camp_qnaDao;
import com.campinga.dto.BusinessmanVO;
import com.campinga.dto.Camp_qnaVO;
import com.campinga.util.Paging;

public class CampingQnaAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "business/mypage/qna.jsp";

		HttpSession session = request.getSession();
		BusinessmanVO bvo = (BusinessmanVO) session.getAttribute("loginBusinessman");

		if (bvo == null) {
			url = "camp.do?command=loginForm";
		} else {
			BusinessmanDao bdao = BusinessmanDao.getInstance();

			int page = 1;
			if (request.getParameter("page") != null) {
				page = Integer.parseInt(request.getParameter("page"));
				session.setAttribute("page", page);
			} else if (session.getAttribute("page") != null) {
				page = (Integer) session.getAttribute("page");
			} else {
				session.removeAttribute("page");
			}
			Paging paging = new Paging();
			paging.setPage(page);  
			int count = bdao.getAllCountForQna();
			paging.setTotalCount(count);

			int bseq = bdao.getBseq(bvo.getBid());

			Camp_qnaDao qdao = Camp_qnaDao.getInstance();
			ArrayList<Camp_qnaVO> qnalist = qdao.campQna(bseq, paging);
			request.setAttribute("paging", paging);
			request.setAttribute("bseq", bseq);
			request.setAttribute("qnalist", qnalist);
		}

		request.getRequestDispatcher(url).forward(request, response);


	}

}
