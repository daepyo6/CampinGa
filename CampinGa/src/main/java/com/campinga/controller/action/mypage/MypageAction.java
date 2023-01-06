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
		
		// �α��� ���������� ������ �α��� �������� �̵�
	    if(mvo == null) {
	    	url = "camp.do?command=loginForm";
	    } else {
	    	// �α��� ���������� ������
	    	// 1. ���������� �����´�.
	    	ReservationDao redao = ReservationDao.getInstance();
	    	ArrayList<ReservationVO> reList = redao.getReservateList(mvo.getMid());
	    	// 2. ���ã�� ������ �����´�.
	    	FavoritesDao fdao = FavoritesDao.getInstance();
	    	ArrayList<FavoritesVO> favorList = fdao.getFavoritesList(mvo.getMid());
	    	
	    	request.setAttribute("reList", reList);
	    	request.setAttribute("favorList", favorList);
	    }
	    request.getRequestDispatcher(url).forward(request, response);
	}

}
