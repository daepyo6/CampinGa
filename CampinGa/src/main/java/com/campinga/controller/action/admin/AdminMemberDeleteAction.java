package com.campinga.controller.action.admin;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.campinga.controller.action.Action;
import com.campinga.dao.MemberDao;

public class AdminMemberDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String [] mid = request.getParameterValues("mid");
		
		for(int i=0; i<mid.length; i++) {
			MemberDao mdao = MemberDao.getInstance();
			mdao.deleteMember( mid[i] );
			
		}
		
		response.sendRedirect("camp.do?command=adminMemberList");

	}

}
