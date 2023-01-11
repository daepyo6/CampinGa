package com.campinga.controller.action.camping;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dao.BusinessmanDao;
import com.campinga.dao.CampDao;
import com.campinga.dao.Camp_qnaDao;
import com.campinga.dao.FavoritesDao;
import com.campinga.dao.ReviewDao;
import com.campinga.dto.BusinessmanVO;
import com.campinga.dto.Camp_qnaVO;
import com.campinga.dto.CampingVO;
import com.campinga.dto.FavoritesVO;
import com.campinga.dto.ReviewVO;
import com.campinga.util.Paging;

public class CampDetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "camping/campDetail.jsp";
		int bseq = Integer.parseInt(request.getParameter("bseq"));
		
		// 즐겨찾기 정보 가져오기
		FavoritesDao fdao = FavoritesDao.getInstance();
		String check_fav = fdao.checkFav(bseq);
		
		// 캠핑장 정보 가져오기
		BusinessmanDao bdao = BusinessmanDao.getInstance();
		BusinessmanVO bvo = bdao.selectOne(bseq);
		
		// 방정보 가져오기
		CampDao cdao = CampDao.getInstance();
		ArrayList<CampingVO> campingList = cdao.selectCampingList(bseq);
		
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
		
		Camp_qnaDao qdao = Camp_qnaDao.getInstance();
		int count = qdao.getCount(bseq);
		paging1.setTotalCount(count);		
		
		ArrayList<Camp_qnaVO> qnalist = qdao.selectAllQna(bseq, paging1);
		if (request.getParameter("qseq") != null) {			
			int qseq = Integer.parseInt(request.getParameter("qseq"));
			for (Camp_qnaVO qvo : qnalist) {
				if (qseq == qvo.getQseq())
					request.setAttribute("updateQseq", qseq);
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
		if (request.getParameter("rseq") != null) {
			int rseq = Integer.parseInt(request.getParameter("rseq"));
			for (ReviewVO rvo : reviewlist) {
				if (rseq == rvo.getRseq())
					request.setAttribute("updateRseq", rseq);
			}
		}
		
		request.setAttribute("paging1", paging1);
		request.setAttribute("paging2", paging2);
		request.setAttribute("bseq", bseq);
		request.setAttribute("chk_fav", check_fav);
		request.setAttribute("campMain", bvo);
		request.setAttribute("campingList", campingList);
		request.setAttribute("qnalist", qnalist);
		request.setAttribute("reviewList", reviewlist);

		request.getRequestDispatcher(url).forward(request, response);
	}

}
