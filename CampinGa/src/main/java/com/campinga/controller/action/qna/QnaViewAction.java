package com.campinga.controller.action.qna;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dao.Camp_qnaDao;
import com.campinga.dto.Camp_qnaVO;
import com.campinga.dto.MemberVO;

public class QnaViewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  String url = "camping/qna/qnaView.jsp";
	      
	      
	       HttpSession session = request.getSession();
	       MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
	       if (mvo == null) {
	          url = "camp.do?command=loginForm";
	       } else {
	          Camp_qnaDao qdao = Camp_qnaDao.getInstance();
	          ArrayList<Camp_qnaVO> qnalist = qdao.getQna( mvo.getMid() );
	          // Camp_qnaVO qvo = qdao.getQna( qseq );
	          
	          
	          request.setAttribute("qnalist", qnalist);
	       }
	       request.getRequestDispatcher(url).forward(request, response);


	}

}
