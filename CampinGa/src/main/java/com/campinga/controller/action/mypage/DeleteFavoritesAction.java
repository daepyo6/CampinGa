package com.campinga.controller.action.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dao.FavoritesDao;
import com.campinga.dao.MemberDao;
import com.campinga.dto.MemberVO;

public class DeleteFavoritesAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "camp.do?command=mypage";
		int fseq = Integer.parseInt(request.getParameter("fseq"));

		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");

		if (mvo == null) {
			url = "camp.do?command=loginForm";
		} else {
			FavoritesDao fdao = FavoritesDao.getInstance();
			fdao.deleteFavorites(fseq);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
