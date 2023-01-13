package com.campinga.controller.action.mypage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dao.FavoritesDao;
import com.campinga.dao.MemberDao;
import com.campinga.dao.ReservationDao;
import com.campinga.dto.FavoritesVO;
import com.campinga.dto.MemberVO;
import com.campinga.dto.ReservationVO;
import com.campinga.util.Paging;

public class MypageAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "member/mypage/mypage.jsp";
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		
		// 로그인 유저정보가 없으면 로그인 페이지로 이동
	    if(mvo == null) {
	    	url = "camp.do?command=loginForm";
	    } else {
	    	
	    	int page=1;
			if( request.getParameter("page")!=null) {
				page = Integer.parseInt( request.getParameter("page") );
				session.setAttribute("page", page);
			}else if( session.getAttribute("page")!=null) {
				page = (int) session.getAttribute("page");
			}else {
				session.removeAttribute("page");
			}
			
			Paging paging = new Paging();
			paging.setPage(page);
			
			MemberDao mdao = MemberDao.getInstance();
			int count = mdao.getAllCount("reservation", mvo.getMid());
			paging.setTotalCount(count);
			
			// 로그인 유저정보가 있으면
			// 1. 예약정보를 가져온다.
			ReservationDao redao = ReservationDao.getInstance();
			ArrayList<ReservationVO> reList = redao.getReservateList(paging, mvo.getMid());
			
			
			
			
			int page1=1;
			if( request.getParameter("page1")!=null) {
				page1 = Integer.parseInt( request.getParameter("page1") );
				session.setAttribute("page1", page1);
			}else if( session.getAttribute("page1")!=null) {
				page1 = (int) session.getAttribute("page1");
			}else {
				session.removeAttribute("page1");
			}
			
			Paging paging1 = new Paging();
			paging1.setPage(page1);
			
			int count1 = mdao.getAllCount("favorites", mvo.getMid());
			paging1.setTotalCount(count1);
			
	    	// 2. 즐겨찾기 정보를 가져온다.
	    	FavoritesDao fdao = FavoritesDao.getInstance();
	    	ArrayList<FavoritesVO> favorList = fdao.getFavoritesList(paging1, mvo.getMid());
	    	
	    	request.setAttribute("paging", paging);
	    	request.setAttribute("paging1", paging1);
	    	request.setAttribute("reList", reList);
	    	request.setAttribute("favorList", favorList);
	    }
	    request.getRequestDispatcher(url).forward(request, response);
	}

}
