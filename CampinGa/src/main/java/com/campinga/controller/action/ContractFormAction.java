package com.campinga.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.campinga.dto.MemberVO;

public class ContractFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		MemberVO mvo = (MemberVO)session.getAttribute("loginUser");		
		String url = "member/contract.jsp";
		if(mvo!=null) {
			url = "camp.do?command=index";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
