package com.campinga.controller.action.review;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dao.ReviewDao;
import com.campinga.dto.MemberVO;
import com.campinga.dto.ReviewVO;

public class ReviewFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	      String url = "camping/review/reviewView.jsp";
	      HttpSession session = request.getSession();
	      MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
	      String rseqs = request.getParameter("rseq");
	      if (mvo == null) {
	         url = "camp.do?command=loginForm";
	      } else {
	         ReviewDao rdao = ReviewDao.getInstance();
	         ArrayList<ReviewVO> list = rdao.selectReview();
	         if (rseqs != null) {
	            int rseqi = Integer.parseInt(rseqs);
	            for (ReviewVO rvo : list) {
	               if (rseqi == rvo.getRseq())
	                  request.setAttribute("updateRseq", rseqi);
	            }
	         }
	         request.setAttribute("reviewList", list);
	         request.setAttribute("loginUser", mvo);
	      }
	      request.getRequestDispatcher(url).forward(request, response);

	}

}
