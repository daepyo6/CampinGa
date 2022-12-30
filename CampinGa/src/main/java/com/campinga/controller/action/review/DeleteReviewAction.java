package com.campinga.controller.action.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campinga.controller.action.Action;
import com.campinga.dao.ReviewDao;

public class DeleteReviewAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	      String rseq = request.getParameter("rseq");
	      
	      ReviewDao rdao = ReviewDao.getInstance();
	      rdao.deleteReview( Integer.parseInt(rseq) );
	     
	      response.sendRedirect("camp.do?command=reviewForm");

	}

}
