package com.campinga.controller.action.mypage;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dao.MemberDao;
import com.campinga.dto.MemberVO;

public class DeleteMemberAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "camp.do?command=index";

		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");

		if (mvo == null) {
			url = "camp.do?command=loginForm";
		} else {
			MemberDao mdao = MemberDao.getInstance();
			mdao.deleteMember( mvo.getMid() );
	    	request.setAttribute("message", "Å»ÅðµÇ¾ú½À´Ï´Ù.");
	    	session.removeAttribute("loginUser");
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
