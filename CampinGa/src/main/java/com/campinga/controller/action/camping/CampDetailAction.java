package com.campinga.controller.action.camping;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dao.CampDao;
import com.campinga.dao.Camp_qnaDao;
import com.campinga.dao.ReviewDao;
import com.campinga.dto.Camp_qnaVO;
import com.campinga.dto.CampingVO;
import com.campinga.dto.MemberVO;
import com.campinga.dto.ReviewVO;

public class CampDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "camping/campDetail.jsp";
		int bseq = Integer.parseInt(request.getParameter("bseq"));
		String rseqs = request.getParameter("rseq");
		String qseqs = request.getParameter("qseq");
		
		// 방정보 가져오기
		CampDao cdao = CampDao.getInstance();
		ArrayList<CampingVO> campingList = cdao.selectCampingList(bseq);
		
		
		// 리뷰 가져오기
		ReviewDao rdao = ReviewDao.getInstance();
		ArrayList<ReviewVO> reviewlist = rdao.selectReview(bseq);
		if (rseqs != null) {
			int rseqi = Integer.parseInt(rseqs);
			for (ReviewVO rvo : reviewlist) {
				if (rseqi == rvo.getRseq())
					request.setAttribute("updateRseq", rseqi);
			}
		}
		
		// QnA 가져오기
		Camp_qnaDao qdao = Camp_qnaDao.getInstance();
		ArrayList<Camp_qnaVO> qnalist = qdao.selectAllQna(bseq);
		if (qseqs != null) {
			int qseqi = Integer.parseInt(qseqs);
			for (Camp_qnaVO qvo : qnalist) {
				if (qseqi == qvo.getQseq())
					request.setAttribute("updateQseq", qseqi);
			}
		}
		request.setAttribute("bseq", bseq);
		request.setAttribute("campingList", campingList);
		request.setAttribute("qnalist", qnalist);
		request.setAttribute("reviewList", reviewlist);

		request.getRequestDispatcher(url).forward(request, response);
	}

}
