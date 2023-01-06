package com.campinga.controller.action.mypage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dao.FavoritesDao;
import com.campinga.dao.ReservationDao;
import com.campinga.dto.FavoritesVO;
import com.campinga.dto.MemberVO;
import com.campinga.dto.ReservationVO;

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
	    	// 로그인 유저정보가 있으면
	    	// 1. 예약정보를 가져온다.
	    	ReservationDao redao = ReservationDao.getInstance();
	    	ArrayList<ReservationVO> reList = redao.getReservateList(mvo.getMid());
	    	// 2. 즐겨찾기 정보를 가져온다.
	    	FavoritesDao fdao = FavoritesDao.getInstance();
	    	ArrayList<FavoritesVO> favorList = fdao.getFavoritesList(mvo.getMid());
	    	
	    	request.setAttribute("reList", reList);
	    	request.setAttribute("favorList", favorList);
	    }
	    request.getRequestDispatcher(url).forward(request, response);
	}

}
