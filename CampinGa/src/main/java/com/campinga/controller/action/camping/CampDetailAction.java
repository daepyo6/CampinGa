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
import com.campinga.dto.ReviewVO;
import com.campinga.util.Paging;

public class CampDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "camping/campDetail.jsp";
		int bseq = Integer.parseInt(request.getParameter("bseq"));
		String rseqs = request.getParameter("rseq");
		String qseqs = request.getParameter("qseq");
		CampDao cdao = CampDao.getInstance();
		CampingVO cvo = cdao.selectOne(bseq);
		
		Camp_qnaDao qdao = Camp_qnaDao.getInstance();
		// QnA paging
		int page1 = 1;
		HttpSession session = request.getSession();
		if(request.getParameter("page1")!=null) {
			page1=Integer.parseInt(request.getParameter("page1"));
			session.setAttribute("page1", page1);
		}else if(session.getAttribute("page1")!=null) {
			page1 = (Integer)session.getAttribute("page1");
		}else {
			session.removeAttribute("page1");
		}
		
		Paging paging1 = new Paging();
		paging1.setPage(page1);
		int count = qdao.getCount(bseq);
		paging1.setTotalCount(count);		
		
		ArrayList<Camp_qnaVO> qnalist = qdao.selectAllQna(bseq, paging1);
		if (qseqs != null) {			
			int qseqi = Integer.parseInt(qseqs);
			for (Camp_qnaVO qvo : qnalist) {
				if (qseqi == qvo.getQseq())
					request.setAttribute("updateQseq", qseqi);
			}
		}
		
		// Review paging
		ReviewDao rdao = ReviewDao.getInstance();		
		int page2 = 1;
		if(request.getParameter("page2")!=null) {
			page2=Integer.parseInt(request.getParameter("page2"));
			session.setAttribute("page2", page2);
		}else if(session.getAttribute("page2")!=null) {
			page2 = (Integer)session.getAttribute("page2");
		}else {
			session.removeAttribute("page2");
		}
		
		Paging paging2 = new Paging();
		paging2.setPage(page2);
		count = rdao.getCount(bseq);
		paging2.setTotalCount(count);	
		ArrayList<ReviewVO> reviewlist = rdao.selectReview(bseq,paging2);
		if (rseqs != null) {
			int rseqi = Integer.parseInt(rseqs);
			for (ReviewVO rvo : reviewlist) {
				if (rseqi == rvo.getRseq())
					request.setAttribute("updateRseq", rseqi);
			}
		}
		
		request.setAttribute("campMain", cvo);
		request.setAttribute("paging1", paging1);
		request.setAttribute("paging2", paging2);
		request.setAttribute("bseq", bseq);
		request.setAttribute("qnalist", qnalist);
		request.setAttribute("reviewList", reviewlist);

		request.getRequestDispatcher(url).forward(request, response);
	}

}
