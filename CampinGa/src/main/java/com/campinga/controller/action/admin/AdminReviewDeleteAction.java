package com.campinga.controller.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campinga.controller.action.Action;
import com.campinga.dao.ReviewDao;

public class AdminReviewDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String[] rseq = request.getParameterValues("rseq");

		for (int i = 0; i < rseq.length; i++) {
			ReviewDao rdao = ReviewDao.getInstance();
			rdao.deleteReview(Integer.parseInt(rseq[i]));
		}
		response.sendRedirect("camp.do?command=adminReviewList");
	}

}
