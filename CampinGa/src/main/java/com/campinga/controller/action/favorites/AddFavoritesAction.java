package com.campinga.controller.action.favorites;

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

public class AddFavoritesAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "camp.do?command=campDetail";
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");
		int bseq = Integer.parseInt(request.getParameter("bseq"));
		
	    if(mvo == null) {
	    	url = "camp.do?command=loginForm";
	    } else {
	    	FavoritesVO fvo = new FavoritesVO();
	    	fvo.setMid(mvo.getMid());
	    	fvo.setBseq(bseq);
	    	
	    	FavoritesDao fdao = FavoritesDao.getInstance();
	    	fdao.insertFavorites(fvo);
	    	request.setAttribute("favorVO", fvo);
	    	
	    }
	    request.getRequestDispatcher(url).forward(request, response);
	}

}
