package com.campinga.controller.action.review;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dao.ReviewDao;
import com.campinga.dto.MemberVO;
import com.campinga.dto.ReviewVO;


public class InsertReviewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String url = "camp.do?command=reviewForm";
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");    
	    
	   if (mvo == null) {
	    	url = "camp.do?command=loginForm";
	    
	    }else{
	    	ReviewVO rvo = new ReviewVO();
	    	rvo.setContent(request.getParameter("content"));
	    	rvo.setMid( rvo.getMid() );
	    	
	    	ReviewDao rdao = ReviewDao.getInstance();
	    	rdao.insertReview(rvo, mvo.getMid());
	    }
	    response.sendRedirect(url);

	}

}
