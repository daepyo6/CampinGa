package com.campinga.controller.action.member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campinga.controller.action.Action;
import com.campinga.dao.BusinessmanDao;
import com.campinga.dao.MemberDao;
import com.campinga.dto.BusinessmanVO;
import com.campinga.dto.MemberVO;
public class IdCheckFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		
		if(type.equals("1")) {				
			MemberDao mdao = MemberDao.getInstance();
			MemberVO mvo = mdao.getMember(id);
			
			if(mvo==null) request.setAttribute("result", -1);
			else request.setAttribute("result", 1);		
		} else if(type.equals("2")) {
			BusinessmanDao bdao = BusinessmanDao.getInstance();
			BusinessmanVO bvo = bdao.getBusinessman(id);
			if(bvo==null) request.setAttribute("result", -1);
			else request.setAttribute("result", 1);
		}
		
		request.setAttribute("type", type);
		request.setAttribute("id", id);
		
		RequestDispatcher rd = request.getRequestDispatcher("member/idCheck.jsp");
		rd.forward(request, response);	
	}
}
