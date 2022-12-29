package com.campinga.controller.action.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dao.MemberDao;
import com.campinga.dto.MemberVO;

public class JoinAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		MemberVO mvo = new MemberVO();
		mvo.setMid(request.getParameter("id"));
		mvo.setName(request.getParameter("name"));
		mvo.setPwd(request.getParameter("pwd"));
		mvo.setMphone(request.getParameter("phone"));
		mvo.setEmail(request.getParameter("email"));
		MemberDao mdao = MemberDao.getInstance();
		int rs =  mdao.insertMember(mvo);
		
		String url = "camp.do?command=loginForm";
		HttpSession session = request.getSession();
		
		if(rs==1) {
			session.setAttribute("message", "회원가입이 완료되었습니다. 로그인해주세요");			
		} else {
			session.setAttribute("message", "회원가입에 실패했습니다.");
			url = "camp.do?command=joinForm";
		}
		
		response.sendRedirect(url);
	}

}
