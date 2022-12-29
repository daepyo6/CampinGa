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
			session.setAttribute("message", "ȸ�������� �Ϸ�Ǿ����ϴ�. �α������ּ���");			
		} else {
			session.setAttribute("message", "ȸ�����Կ� �����߽��ϴ�.");
			url = "camp.do?command=joinForm";
		}
		
		response.sendRedirect(url);
	}

}
