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
		String url = "";
		int seq = 0; 
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");

		if (mvo == null) {
			url = "camp.do?command=loginForm";
		} else {
			FavoritesDao fdao = FavoritesDao.getInstance();
			if(!(request.getParameter("fseq") == null)) {
				seq = Integer.parseInt(request.getParameter("fseq"));
				fdao.deleteFavorites("fseq", seq);
				url = "camp.do?command=mypage";
			} else if(!(request.getParameter("bseq") == null)) {
				seq = Integer.parseInt(request.getParameter("bseq"));
				fdao.deleteFavorites("bseq", seq);
				url = "camp.do?command=campDetail";
			} else {
				System.out.println("seq∞° 0¿”");
			}
			
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
