package com.campinga.controller.action.qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dao.Camp_qnaDao;
import com.campinga.dto.Camp_qnaVO;
import com.campinga.dto.MemberVO;

public class InsertQnaAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int bseq = Integer.parseInt(request.getParameter("bseq"));
		String url = "camp.do?command=campDetail&bseq="+bseq;

		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		
		if (mvo == null) {
			url = "camp.do?command=loginForm";
		} else {
			Camp_qnaVO qvo = new Camp_qnaVO();
			qvo.setContent(request.getParameter("content"));
			qvo.setMid(mvo.getMid());
			qvo.setBseq(bseq);
			
			Camp_qnaDao qdao = Camp_qnaDao.getInstance();
			qdao.insertQna(qvo);
		}
		response.sendRedirect(url);
	}
}
