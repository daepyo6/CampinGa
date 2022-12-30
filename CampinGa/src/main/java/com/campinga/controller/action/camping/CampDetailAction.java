package com.campinga.controller.action.camping;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dao.Camp_qnaDao;
import com.campinga.dao.ReviewDao;
import com.campinga.dto.Camp_qnaVO;
import com.campinga.dto.MemberVO;
import com.campinga.dto.ReviewVO;

public class CampDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "camping/campDetail.jsp";
		String rseqs = request.getParameter("rseq");
		ReviewDao rdao = ReviewDao.getInstance();
		ArrayList<ReviewVO> reviewlist = rdao.selectReview();
		if (rseqs != null) {
			int rseqi = Integer.parseInt(rseqs);
			for (ReviewVO rvo : reviewlist) {
				if (rseqi == rvo.getRseq())
					request.setAttribute("updateRseq", rseqi);
			}
		}
		Camp_qnaDao qdao = Camp_qnaDao.getInstance();
		ArrayList<Camp_qnaVO> qnalist = qdao.getQna();
		
		request.setAttribute("qnalist", qnalist);
		request.setAttribute("reviewList", reviewlist);

		request.getRequestDispatcher(url).forward(request, response);
	}

}
