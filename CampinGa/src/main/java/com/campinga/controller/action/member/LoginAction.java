package com.campinga.controller.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dto.MemberVO;


public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String mid = request.getParameter("mid");
		String pwd = request.getParameter("pwd");
		
		MemberDao mdao = MemberDao.getInstance();
		MemberVO mvo = mdao.getMember( mid );

		// getMember 메서드를 만들고 , 리턴상황에 맞는 if 문을 이용해서 로그인을 구현하세요. 
		// 최종 목적지는 main.jsp 입니다 
		String url="member/login.jsp";
		
		if(mvo==null)
			request.setAttribute("message", "없는 아이디입니다");
		else if( mvo.getPwd() == null)
			request.setAttribute("message", "시스템오류. 관리에게 문의하세요");
		else if( !mvo.getPwd().equals(pwd) )
			request.setAttribute("message", "비밀번호가 틀렸어요");
		else if( mvo.getPwd().equals(pwd) ) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", mvo);
			url = "camp.do?command=index";
		}else
			request.setAttribute("message", "기타의 이유로 로그인이 실패했어요. 관리자에게 문의하세요");

		RequestDispatcher dp=request.getRequestDispatcher(url);
		dp.forward(request, response);

	}

}
