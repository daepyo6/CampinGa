package com.campinga.controller.action.mypage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dao.MemberDao;
import com.campinga.dto.MemberVO;

public class UpdateUserInfoAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "camp.do?command=mypage";
		
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO) session.getAttribute("loginUser");

	    if(mvo == null) {
	    	url = "camp.do?command=loginForm";
	    } else {
	    	mvo = new MemberVO();
	    	MemberDao mdao = MemberDao.getInstance();
	    	mvo.setMid(request.getParameter("mid"));
	    	mvo.setName(request.getParameter("name"));
	    	mvo.setMphone(request.getParameter("mphone"));
	    	mvo.setEmail(request.getParameter("email"));
	    	mdao.updateUserInfo(mvo);
	    }
	    request.getRequestDispatcher(url).forward(request, response);
	}

}
