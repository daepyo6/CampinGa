package com.campinga.controller.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.controller.action.Action;
import com.campinga.dao.MemberDao;
import com.campinga.dto.MemberVO;


public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String user = request.getParameter("user");
		String mid = request.getParameter("id");
		String pwd = request.getParameter("pwd");
				
		String url="member/login.jsp";
		
		if(user.equals("1")) {
			MemberDao mdao = MemberDao.getInstance();
			MemberVO mvo = mdao.getMember( mid );
			
			if(mvo==null)
				request.setAttribute("message", "���� ���̵��Դϴ�");
			else if( mvo.getPwd() == null)
				request.setAttribute("message", "�ý��ۿ���. �������� �����ϼ���");
			else if( !mvo.getPwd().equals(pwd) )
				request.setAttribute("message", "��й�ȣ�� Ʋ�Ⱦ��");
			else if( mvo.getPwd().equals(pwd) ) {
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", mvo);
				url = "camp.do?command=index";
			}else
				request.setAttribute("message", "��Ÿ�� ������ �α����� �����߾��. �����ڿ��� �����ϼ���");
		} else {
			// bdao�� �α���
		}
		
		RequestDispatcher dp=request.getRequestDispatcher(url);
		dp.forward(request, response);

	}

}